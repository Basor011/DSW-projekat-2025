package raf.graffito.dsw.controller.state.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CopyElementAction extends AbstractGraffAction {
    public CopyElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/copy-icon.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Copy?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startCopyElementState();
    }
}
