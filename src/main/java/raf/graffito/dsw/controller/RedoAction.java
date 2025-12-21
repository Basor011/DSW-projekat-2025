package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;

import javax.swing.*;
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
