package raf.graffito.dsw.controller.state.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddImageAction extends AbstractGraffAction {
    public AddImageAction() {
        putValue(SMALL_ICON, loadIcon("/images/imageelement - Copy.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Insert a new image?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startAddImageState();
    }
}
