package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteElementAction extends AbstractGraffAction {
    public DeleteElementAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK)); // Ovo je prečica za izlaz
        putValue(SMALL_ICON, loadIcon("/images/amogus.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Delete element?");
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startDeleteElementState();
    }
}
