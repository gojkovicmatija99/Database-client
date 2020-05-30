package view;

import actions.ActionManager;

import javax.swing.*;

public class MyToolbar extends JToolBar {

    public MyToolbar() {
        super(SwingConstants.HORIZONTAL);

        add(ActionManager.getInstance().getAddAction());

        addSeparator();

        add(ActionManager.getInstance().getDeleteAction());

        addSeparator();

        add(ActionManager.getInstance().getUpdateAction());

        addSeparator();

        setFloatable(false);

    }

}
