package view;

import resource.implementation.Attribute;
import resource.implementation.Entity;
import resource.tree.DBNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateDialog extends JDialog {
    private Entity entity;
    private List<JTextField> textFieldsList;
    private JButton updateButton;

    public UpdateDialog(Entity entity) {
        this.entity=entity;
        textFieldsList=new ArrayList<>();

        this.setTitle("Insert into "+entity.getName());
        this.setLayout(new GridLayout(0,2));
        this.setAlwaysOnTop(true);

        List<DBNode> attributes=entity.getChildren();
        this.setSize(new Dimension(300, (attributes.size()+1)*50));
        for(int i=0;i<attributes.size();i++) {
            Attribute currAttribute= (Attribute) attributes.get(i);
            JLabel currLabel=new JLabel(currAttribute.getName(), SwingConstants.CENTER);
            this.add(currLabel);
            JTextField currTextField=new JTextField(SwingConstants.CENTER);
            currTextField.setName(currAttribute.getName());
            textFieldsList.add(currTextField);
            this.add(currTextField);
        }

        updateButton=new JButton("UPDATE");
        //updateButton.addActionListener(new UpdateDialogAction(entity, textFieldsList));
        this.add(updateButton);
    }
}
