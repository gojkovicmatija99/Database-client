package resource.tree;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class DBtreeCellRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if(value instanceof DBtreeNode) {
            DBtreeNode currDBtreeNode=(DBtreeNode) value;
            DBNode dbNode=currDBtreeNode.getDbNode();

            if(dbNode instanceof InformationResource) {
                URL imageURL=getClass().getResource("images/database.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);

            } else if(dbNode instanceof Entity) {
                URL imageURL=getClass().getResource("images/entity.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if(dbNode instanceof Attribute) {
                URL imageURL=getClass().getResource("images/attribute.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }


        return this;
    }
}
