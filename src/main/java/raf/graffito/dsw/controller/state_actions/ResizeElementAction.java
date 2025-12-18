package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ResizeElementAction extends AbstractGraffAction {
    public ResizeElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/resize.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Resize an element?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startResizeElementState();
    }
}
