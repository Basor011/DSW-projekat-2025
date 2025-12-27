package raf.graffito.dsw.controller.command_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.core.ApplicationFramework;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGraffAction {
    public RedoAction() {
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/redo.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Redo?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFramework.getInstance().getCommandManager().redo();
    }
}
