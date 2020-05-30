package resource.tree;

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
        System.out.println(path.getPathComponent(i));
        Entity entity = (Entity) path.getPathComponent(1);
        System.out.println(entity.getName());
        /*for (int i = 0; i < path.getPathCount(); i++) {
        System.out.println(path.getPathComponent(i));
            if (path.getPathComponent(i) instanceof Entity) {
                Entity entity = (Entity) path.getPathComponent(i);
                System.out.println(entity.getName());
                RightTopPanel topTableView = new RightTopPanel();
                JTable jTable = topTableView.getjTable();
                MainFrame.getInstance().readDataFromTable(entity.getName());
                jTable.setModel(MainFrame.getInstance().getTableModel());
                MainFrame.getInstance().getTopTab().addTab(entity.getName(), topTableView);
            }
        }*/

    }
}
