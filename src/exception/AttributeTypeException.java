package exception;

import resource.implementation.Attribute;

public class AttributeTypeException extends Exception{

    public AttributeTypeException(Attribute attribute) {
        super(attribute.getName() + " must be a " + attribute.getAttributeType());
    }
}
