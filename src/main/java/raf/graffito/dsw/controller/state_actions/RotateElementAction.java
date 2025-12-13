package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RotateElementAction extends AbstractGraffAction {
    public RotateElementAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK)); // Ovo je prečica za izlaz
        putValue(SMALL_ICON, loadIcon("/images/amogusrotatus.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Rotate?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       boolean toggle= ((PresentationView)(MainFrame.getInstance().getTabbedPane().getSelectedComponent())).getButtonContainer().isVisible() ;
        ((PresentationView)(MainFrame.getInstance().getTabbedPane().getSelectedComponent())).getButtonContainer().setVisible(!toggle);
       // MainFrame.getInstance().getRightPanel().startRotateElementState();

    }
}
