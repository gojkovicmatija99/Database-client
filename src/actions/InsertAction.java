package actions;

import resource.implementation.Entity;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertAction extends AbstractAction implements ActionListener {
    private Entity entity;
    private Map<String, String> map;
    List<JTextField> textFields;

    public InsertAction(Entity entity, List<JTextField> textFields) {
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
        }
        MainFrame.getInstance().getAppCore().getDatabase().addRow(map, entity);
        MainFrame.getInstance().getAppCore().readDataFromTable(entity.getName());
    }
}
