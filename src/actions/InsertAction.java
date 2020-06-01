package actions;

import resource.implementation.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InsertAction extends AbstractAction implements ActionListener {
    private Entity entity;
    private List<JTextField> textFields;

    public InsertAction(Entity entity, List<JTextField> textFields) {
        putValue(NAME, "Insert");
        putValue(SHORT_DESCRIPTION, "Insert into");

        this.textFields=textFields;
        this.entity=entity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
