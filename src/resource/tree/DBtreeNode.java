package resource.tree;

import resource.DBNode;
import resource.DBNodeComposite;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public abstract class DBtreeNode implements TreeNode {
    private DBNode dbNode;

    public DBtreeNode(DBNode dbNode)
    {
        this.dbNode=dbNode;
    }

    @Override
    public TreeNode getParent() {
        return (TreeNode) dbNode.getDBNodeParent();
    }

    @Override
    public String toString() {
        return dbNode.getName();
    }

    public DBNode getDbNode() {
        return dbNode;
    }
}
