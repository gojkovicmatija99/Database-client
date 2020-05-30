package resource.tree;

import resource.DBNodeComposite;
import resource.implementation.Entity;
import view.MainFrame;
import view.RightTopPanel;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class DBtree implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        if (path == null)
            return;
        for (int i = 0; i < path.getPathCount(); i++) {
            DBtreeNode node = (DBtreeNode) path.getPathComponent(i);
            if (node.getDbNode() instanceof Entity) {
                Entity entity = (Entity) node.getDbNode();
                RightTopPanel topTableView = new RightTopPanel();
                topTableView.getjTable().setModel(MainFrame.getInstance().getTableModel());
                MainFrame.getInstance().readDataFromTable(entity.getName());
                MainFrame.getInstance().getTopTab().addTab(entity.getName(), topTableView);
                MainFrame.getInstance().getTopTab().setSelectedComponent(topTableView);
            }
        }

    }
}
