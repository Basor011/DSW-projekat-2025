package raf.graffito.dsw.gui.swing.tree.controller.state_actions;

import raf.graffito.dsw.controller.state.concrete.MoveState;

public class StateActionManager {
    private MoveElementAction moveAction;

    public StateActionManager() {initActions();}

    private void initActions() {
        moveAction = new MoveElementAction();
    }

    public MoveElementAction getMoveAction() {
        return moveAction;
    }
}
