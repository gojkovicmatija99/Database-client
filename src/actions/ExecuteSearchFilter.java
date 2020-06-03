package actions;

import resource.implementation.Entity;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteSearchFilter implements ActionListener {
    private String filter;
    private Entity entity;
    public ExecuteSearchFilter(String filter, Entity entity) {
        this.entity=entity;
        this.filter=filter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getAppCore().getDatabase().searchRows(filter,entity);
    }
}
