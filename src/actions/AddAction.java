package actions;

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

    }
}
