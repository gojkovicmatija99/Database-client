package resource.implementation;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.enums.AttributeType;

public class Attribute extends DBNodeComposite {
    public AttributeType attributeType;
    private int length;
    private Attribute inRealationWith;

    public Attribute(String name, DBNode parent, AttributeType attributeType, int length) {
        super(name, parent);
        this.attributeType=attributeType;
        this.length=length;
    }

    @Override
    public void addChild(DBNode child) {
        if(child!=null && child instanceof AttributeConstraint) {
            AttributeConstraint attributeConstraint=(AttributeConstraint) child;
            this.getChildren().add(attributeConstraint);
        }
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public int getLength() {
        return length;
    }

    public Attribute getInRealationWith() {
        return inRealationWith;
    }
}
