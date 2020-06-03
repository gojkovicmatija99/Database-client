package view;

import actions.ComboboxSelectAction;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import resource.tree.DBNode;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class SearchDialog extends JDialog {
    private Entity entity;
    private JComboBox<Attribute> cmbAttributes;
    private JPanel otherOptions;
    private JLabel lbQuery;

    public SearchDialog(Entity entity) {
        this.entity=entity;
        this.lbQuery=new JLabel();
        this.otherOptions=new JPanel(new GridLayout(1,5));
        this.setTitle("Search "+entity.getName());
        this.setLayout(new GridLayout(0,1));
        this.setAlwaysOnTop(true);

        List<DBNode> attributes=entity.getChildren();
        this.setSize(new Dimension(300, (attributes.size()+1)*50));
        cmbAttributes=new JComboBox(attributes.toArray());
        cmbAttributes.setSelectedIndex(-1);
        cmbAttributes.addItemListener(new ComboboxSelectAction(this));
        this.add(cmbAttributes);
        this.add(otherOptions);
        this.add(lbQuery);
    }

    public JPanel getOtherOptions() {
        return this.otherOptions;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public JComboBox<Attribute> getCmbAttributes() {
        return this.cmbAttributes;
    }

    public void appendQuery(String s) {
        String text=lbQuery.getText();
        lbQuery.setText(text+ " "+s);
    }

    public JLabel getLbQuery() {
        return lbQuery;
    }
}