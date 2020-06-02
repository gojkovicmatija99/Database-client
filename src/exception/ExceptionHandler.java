package exception;

import resource.implementation.Attribute;
import view.MainFrame;

import javax.swing.*;

public class ExceptionHandler {
    public static void handle(ExceptionType exceptionType, Attribute attribute) {
        if (exceptionType == ExceptionType.ATTRIBUTE_TYPE_ERROR) {
            String message = attribute.getName() + " must be a " + attribute.getAttributeType();
            String title = exceptionType.toString();
            JOptionPane.showMessageDialog(MainFrame.getInstance(), message, title, JOptionPane.ERROR_MESSAGE);
        }
        if (exceptionType == ExceptionType.ATTRIBUTE_LENGTH_ERROR) {
            String message = "Max length of " + attribute.getName() + " is " + attribute.getLength();
            String title = exceptionType.toString();
            JOptionPane.showMessageDialog(MainFrame.getInstance(), message, title, JOptionPane.ERROR_MESSAGE);
        }
    }
}