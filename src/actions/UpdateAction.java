package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAction extends AbstractAction implements ActionListener {

    public UpdateAction() {
        putValue(NAME, "Update");
        putValue(SHORT_DESCRIPTION, "Update Row");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
