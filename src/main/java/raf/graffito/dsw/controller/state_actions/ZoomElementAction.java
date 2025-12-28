package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomElementAction extends AbstractGraffAction {
    public ZoomElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/zoomin.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Zoom?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startZoomElementState();
    }
}
