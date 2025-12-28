package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteElementAction extends AbstractGraffAction {
    public DeleteElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/delete.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Delete element?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startDeleteElementState();
    }
}
