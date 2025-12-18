package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddTextFieldAction extends AbstractGraffAction {
    public AddTextFieldAction() {
        putValue(SMALL_ICON, loadIcon("/images/textfieldelement - Copy.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Insert a new Text Field?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startAddTextFieldState();
    }
}
