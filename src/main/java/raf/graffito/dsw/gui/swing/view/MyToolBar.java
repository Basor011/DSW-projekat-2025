package raf.graffito.dsw.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(MainFrame mainFrame) {
        super(HORIZONTAL);
        setFloatable(false);

        add(mainFrame.getActionManager().getExitAction());
        add(mainFrame.getActionManager().getNewChildAction());
        add(mainFrame.getActionManager().getRemoveChildAction());
        add(mainFrame.getActionManager().getSaveOrLoadAction());

        add(mainFrame.getActionManager().getUndoAction());
        add(mainFrame.getActionManager().getRedoAction());

        add(mainFrame.getActionManager().getFullModeAction());
        add(mainFrame.getActionManager().getNormalModeAction());
        add(mainFrame.getActionManager().getSmallModeAction());
    }
}
