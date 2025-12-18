package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.commands.AddElementCommand;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddImageAction extends AbstractGraffAction {
    public AddImageAction() {
        putValue(SMALL_ICON, loadIcon("/images/imageelement - Copy.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Insert a new image?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startAddImageState();
    }
}
