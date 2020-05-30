package view;

import resource.tree.DBtreeNode;

import javax.swing.*;

public class DBview extends JPanel {
    DBtreeNode dbTreeNode;

    public DBview(DBtreeNode dBtreeNode) {
        this.dbTreeNode=dBtreeNode;
        RightTopPanel topPanel = new RightTopPanel();
        this.add(topPanel);
        //topPanel.readDataFromTable("COUNTRIES");
    }
}
