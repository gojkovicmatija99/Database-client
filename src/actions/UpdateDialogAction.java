package actions;

import resource.implementation.Attribute;
import resource.implementation.Entity;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateDialogAction extends AbstractAction implements ActionListener {
    private Entity entity;
    private Map<String, String> map;
    private List<JTextField> textFields;
    private JTextField wherePKequalsTextField;

    public UpdateDialogAction(Entity entity, List<JTextField> textFieldsList, JTextField wherePKequalsTextField) {
        putValue(NAME, "Update");
        putValue(SHORT_DESCRIPTION, "Update column");

        this.entity=entity;
        this.textFields=textFieldsList;
        this.map=new HashMap<>();
        this.wherePKequalsTextField=wherePKequalsTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<textFields.size();i++) {
            if(!textFields.get(i).getText().equals(""))
            map.put(textFields.get(i).getName(), textFields.get(i).getText());
        }
        String wherePK=wherePKequalsTextField.getText();
        MainFrame.getInstance().getAppCore().updateRow(map, entity, wherePK);
    }
}
