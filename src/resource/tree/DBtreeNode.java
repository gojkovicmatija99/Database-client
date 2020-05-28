package resource.tree;

import resource.DBNodeComposite;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class DBtreeNode implements TreeNode {
    DBNodeComposite dbNodeComposite;

    public DBtreeNode(DBNodeComposite dbNodeComposite) {
        this.dbNodeComposite=dbNodeComposite;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        TreeNode currTreeNode=new DBtreeNode((DBNodeComposite) dbNodeComposite.getChildren().get(childIndex));
        return currTreeNode;
    }

    @Override
    public int getChildCount() {
        return dbNodeComposite.getChildren().size();
    }

    @Override
    public TreeNode getParent() {
        return (TreeNode) dbNodeComposite.getDBNodeParent();
    }

    @Override
    public int getIndex(TreeNode node) {
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

    @Override
    public String toString() {
        return dbNodeComposite.getName();
    }

    public DBNodeComposite getDbNodeComposite() {
        return dbNodeComposite;
    }
}
