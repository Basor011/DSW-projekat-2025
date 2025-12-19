package raf.graffito.dsw.controller.state.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

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
