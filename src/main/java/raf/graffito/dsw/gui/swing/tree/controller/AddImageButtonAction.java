package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.controller.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddImageButtonAction implements AddElementButtonAction {
    private StateManager stateManager;

    public AddImageButtonAction(StateManager stateManager) {
        this.stateManager = stateManager;
    }
    @Override
    public void activate() {
        stateManager.setAddImageState();
        System.out.println("aktiviran je gumb za dodavanje slike slika");
    }
}
