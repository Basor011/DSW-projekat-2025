package raf.graffito.dsw.gui.swing;

import raf.graffito.dsw.controller.ExitAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    private MainFrame mainFrame;
    public MyToolBar(MainFrame mainFrame) {
        super(HORIZONTAL);
        this.mainFrame = mainFrame;
        setFloatable(false);

        add(mainFrame.getActionManager().getExitAction());
    }
}
