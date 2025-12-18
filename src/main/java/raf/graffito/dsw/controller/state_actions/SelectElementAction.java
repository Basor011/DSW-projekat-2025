package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectElementAction extends AbstractGraffAction {
    public SelectElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/selectelement.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Select an element?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startSelectState();
    }
}
