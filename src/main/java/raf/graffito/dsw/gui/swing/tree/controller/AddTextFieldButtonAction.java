package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.controller.state.StateManager;

public class AddTextFieldButtonAction implements AddElementButtonAction{
    private StateManager stateManager;

    public AddTextFieldButtonAction(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void activate() {
        stateManager.setAddTextFieldState();
        System.out.println("aktiviran gumb za dodavanje tesktfielda");
    }
}
