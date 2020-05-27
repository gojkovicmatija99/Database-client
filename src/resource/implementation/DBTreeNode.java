package resource.implementation;

import resource.DBNode;
import resource.DBNodeComposite;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class DBTreeNode extends DBNodeComposite implements TreeNode {
    public DBTreeNode(String name, DBNode parent) {
        super(name, parent);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return (TreeNode) getChildren().get(childIndex);
    }

    @Override
    public int getChildCount() {
        return getChildren().size();
    }

    @Override
    public TreeNode getParent() {
        return (TreeNode) getDBNodeParent();
    }

    @Override
    public int getIndex(TreeNode node) {
        return getChildren().indexOf(node);
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
    public void addChild(DBNode child) {
        getChildren().add(child);
    }
}
