package actions;

import resource.implementation.Entity;
import view.InsertDialog;
import view.MainFrame;
import view.RightTopPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAction extends AbstractAction implements ActionListener {

    public AddAction() {
        putValue(NAME, "Add");
        putValue(SHORT_DESCRIPTION, "Add Row");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Entity entity= (Entity) ((RightTopPanel) MainFrame.getInstance().getTopTab().getSelectedComponent()).getEntity();
        InsertDialog addDialog=new InsertDialog(entity);
        addDialog.setVisible(true);
    }
}
