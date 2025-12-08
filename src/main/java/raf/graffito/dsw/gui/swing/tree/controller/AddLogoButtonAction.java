package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.controller.state.StateManager;

public class AddLogoButtonAction implements AddElementButtonAction{
    private StateManager stateManager;

    public AddLogoButtonAction(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void activate() {

    }
}
