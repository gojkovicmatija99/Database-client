package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAction extends AbstractAction implements ActionListener {

    public DeleteAction() {
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete row");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
