package raf.graffito.dsw.gui.swing;

import com.sun.tools.javac.Main;
import raf.graffito.dsw.controller.ExitAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
    }
}
