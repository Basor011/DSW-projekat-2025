package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveElementAction extends AbstractGraffAction {
    public MoveElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/ttuturumaxverstappen-removebg-preview.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Move element?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startMoveState();
    }
}
