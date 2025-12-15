package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ZoomElementAction extends AbstractGraffAction {
    public ZoomElementAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK)); // Ovo je prečica za izlaz
        putValue(SMALL_ICON, loadIcon("/images/amoguszoomus.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Zoom?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startZoomElementState();

    }
}
