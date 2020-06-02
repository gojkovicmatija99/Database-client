package exception;

import resource.implementation.Attribute;
import view.MainFrame;

import javax.swing.*;

public class ExceptionHandler {
    private static ExceptionHandler instance = null;

    private Attribute attribute;

    public static ExceptionHandler getInstance() {
        if (instance == null)
            instance = new ExceptionHandler();
        return instance;
    }

    private AttributeTypeException attributeTypeException;

    public ExceptionHandler(Attribute attribute) {
        this.attribute = attribute;
        attributeTypeException = new AttributeTypeException(attribute);
    }

    public void showExceptionDialog(Exception exception)
    {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), exception.getMessage(attribute));
    }

    public AttributeTypeException getAttributeTypeException() {
        return attributeTypeException;
    }
}
