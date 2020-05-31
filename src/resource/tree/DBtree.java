package resource.tree;

import resource.implementation.Entity;
import view.MainFrame;
import view.RightTopPanel;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class DBtree extends JTree implements TreeSelectionListener {

    public DBtree() {
        addTreeSelectionListener(this);
        setCellRenderer(new DBtreeCellRenderer());
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        if (path == null)
            return;
        for (int i = 0; i < path.getPathCount(); i++) {
            DBNode node = (DBNode) path.getPathComponent(i);
            if (node instanceof Entity) {
                Entity entity = (Entity) node;
                RightTopPanel topTableView = new RightTopPanel();
                topTableView.getjTable().setModel(MainFrame.getInstance().getAppCore().getTableModel1());
                MainFrame.getInstance().getAppCore().readDataFromTable(entity.getName());
                MainFrame.getInstance().getTopTab().addTab(entity.getName(), topTableView);
                MainFrame.getInstance().getTopTab().setSelectedComponent(topTableView);
            }
        }
    }
}
