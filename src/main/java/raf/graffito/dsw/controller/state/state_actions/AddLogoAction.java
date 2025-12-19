package raf.graffito.dsw.controller.state.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddLogoAction extends AbstractGraffAction {
    public AddLogoAction() {
        putValue(SMALL_ICON, loadIcon("/images/bananaleclerc.jpg")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Insert the logo?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startAddLogoState();
    }
}
