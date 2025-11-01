package raf.graffito.dsw.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getNewChildAction());
        add(MainFrame.getInstance().getActionManager().getRemoveChildAction());
    }
}
