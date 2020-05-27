package resource;

import view.DBview;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class DBtree extends JTree implements TreeSelectionListener {
    private DBview dBview;

    public DBtree(DBview dBview) {
        this.dBview=dBview;
        addTreeSelectionListener(this);
        setEditable(false);
    }
    @Override
    public void valueChanged(TreeSelectionEvent e) {

    }
}
