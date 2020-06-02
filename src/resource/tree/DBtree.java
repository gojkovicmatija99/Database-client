package resource.tree;

import app.AppCore;
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
                MainFrame.getInstance().getAppCore().addRightPanel(entity);
                /*AppCore appCore = MainFrame.getInstance().getAppCore();
                JTabbedPane topTab = MainFrame.getInstance().getTopTab();
                int pozicijaIstog = -1;
                for (int j = 0; j < topTab.getTabCount(); j++) {
                    RightTopPanel rightTopPanel = (RightTopPanel) topTab.getComponentAt(j);
                    String tabTitle = rightTopPanel.getEntity().getName();
                    if (tabTitle.equals(entity.getName())){
                        pozicijaIstog = j;
                        break;
                    }
                }
                System.out.println(entity.getInRelationWith());
                if (pozicijaIstog == -1) {
                    RightTopPanel topTableView = new RightTopPanel(entity);
                    topTableView.getjTable().setModel(appCore.getTableModel1());
                    appCore.readDataFromTable(entity.getName());
                    topTab.addTab(entity.getName(), topTableView);
                    topTab.setSelectedComponent(topTableView);
                }
                else {
                    RightTopPanel topTableView = (RightTopPanel)topTab.getComponentAt(pozicijaIstog);
                    topTab.setSelectedComponent(topTableView);
                }*/
            }
        }
    }
}
