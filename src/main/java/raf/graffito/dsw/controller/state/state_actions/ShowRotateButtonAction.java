package raf.graffito.dsw.controller.state.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;

import java.awt.event.ActionEvent;

public class ShowRotateButtonAction extends AbstractGraffAction {
    public ShowRotateButtonAction() {
        putValue(SMALL_ICON, loadIcon("/images/amogusrotatus.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Rotate?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTabbedPane().getSelectedComponent() != null) {
            boolean toggle = ((PresentationView) (MainFrame.getInstance().getTabbedPane().getSelectedComponent())).getButtonContainer().isVisible();

            ((PresentationView) (MainFrame.getInstance().getTabbedPane().getSelectedComponent())).getButtonContainer().setVisible(!toggle);
        }
    }
}
