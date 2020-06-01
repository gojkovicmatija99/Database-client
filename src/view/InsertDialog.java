package view;

import actions.InsertAction;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import resource.tree.DBNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InsertDialog extends JDialog {
    private Entity entity;
    private List<JTextField> textFieldsList;
    private JButton insertButton;
    private ArrayList<String> values;

    public InsertDialog(Entity entity) {
        this.entity=entity;
        textFieldsList=new ArrayList<>();

        this.setTitle("Insert into "+entity.getName());
        this.setLayout(new GridLayout(0,2));
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(400,400));

        List<DBNode> attributes=entity.getChildren();
        for(int i=0;i<attributes.size();i++) {
            Attribute currAttribute= (Attribute) attributes.get(i);
            JLabel currLabel=new JLabel(currAttribute.getName(), SwingConstants.CENTER);
            this.add(currLabel);
            JTextField currTextField=new JTextField(SwingConstants.CENTER);
            currTextField.setName(currAttribute.getName());
            textFieldsList.add(currTextField);
            this.add(currTextField);
        }

        insertButton=new JButton("INSERT");
        insertButton.addActionListener(new InsertAction(entity, textFieldsList));
        this.add(insertButton);
    }
}
