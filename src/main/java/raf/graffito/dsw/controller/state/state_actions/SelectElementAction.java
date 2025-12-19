package raf.graffito.dsw.controller.state.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectElementAction extends AbstractGraffAction {
    public SelectElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/selectelement-removebg-preview.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Select an element?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startSelectState();
    }
}
