package resource.tree;

import resource.DBNode;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class DBtreeNodeLeaf extends DBtreeNode {

    public DBtreeNodeLeaf(DBNode dbNode) {
        super(dbNode);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }
}
