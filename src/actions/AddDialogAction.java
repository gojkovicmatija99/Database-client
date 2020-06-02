package actions;

import exception.AttributeTypeException;
import exception.ExceptionHandler;
import resource.enums.AttributeType;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDialogAction extends AbstractAction implements ActionListener {
    private Entity entity;
    private Map<String, String> map;
    List<JTextField> textFields;

    public AddDialogAction(Entity entity, List<JTextField> textFields) {
        putValue(NAME, "Insert");
        putValue(SHORT_DESCRIPTION, "Insert into");

        this.textFields=textFields;
        this.entity=entity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map=new HashMap<>();
        for(int i=0;i<textFields.size();i++) {
            map.put(textFields.get(i).getName(), textFields.get(i).getText());
            Attribute attribute = (Attribute) entity.getChildByName(textFields.get(i).getName());
            try {
                if (attribute.getAttributeType() == AttributeType.FLOAT)
                    Float text = Float.parseFloat(textFields.get(i).getText());
            } catch(NumberFormatException nfe) {
                throws ExceptionHandler.getInstance().getAttributeTypeException();
            } catch(AttributeTypeException ate) {
                ExceptionHandler.getInstance().showExceptionDialog(ate);
            }
        }
        MainFrame.getInstance().getAppCore().addRow(map, entity);
    }
}
