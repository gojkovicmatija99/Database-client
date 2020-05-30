package resource.tree;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.AttributeConstraint;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class DBtreeNodeComposite extends DBtreeNode {

    public DBtreeNodeComposite(DBNode dbNode) {
        super(dbNode);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        DBNode dbNode=((DBNodeComposite) getDbNode()).getChildren().get(childIndex);
        DBtreeNode dbTreeNode=null;

        if(dbNode instanceof AttributeConstraint)
            dbTreeNode=new DBtreeNodeLeaf(dbNode);
        else
            dbTreeNode=new DBtreeNodeComposite(dbNode);

        return (TreeNode) dbTreeNode;
    }

    @Override
    public int getChildCount() {
        DBNodeComposite dbNodeComposite= (DBNodeComposite) getDbNode();
        return dbNodeComposite.getChildren().size();
    }

    @Override
    public int getIndex(TreeNode node) {
        DBNodeComposite dbNodeComposite= (DBNodeComposite) getDbNode();
        return dbNodeComposite.getChildren().indexOf(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }
}
