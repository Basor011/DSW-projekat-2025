package raf.graffito.dsw.controller.command_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.core.ApplicationFramework;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGraffAction {
    public UndoAction() {
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/undo.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Undo?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFramework.getInstance().getCommandManager().undo();
    }
}
