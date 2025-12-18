package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
