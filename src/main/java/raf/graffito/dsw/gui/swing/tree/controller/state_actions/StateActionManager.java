package raf.graffito.dsw.gui.swing.tree.controller.state_actions;

import raf.graffito.dsw.controller.state.concrete.MoveState;

public class StateActionManager {
    private MoveElementAction moveAction;
    private AddImageButtonAction addImageButton;
    private AddLogoButtonAction addLogoButton;
    private AddTextFieldButtonAction addTextFieldButton;

    public StateActionManager() {initActions();}

    private void initActions() {
        moveAction = new MoveElementAction();
        addImageButton = new AddImageButtonAction();
        addLogoButton = new AddLogoButtonAction();
        addTextFieldButton = new AddTextFieldButtonAction();
    }

    public MoveElementAction getMoveAction() {
        return moveAction;
    }
    public AddImageButtonAction getAddImageButton() {
        return addImageButton;
    }
    public AddLogoButtonAction getAddLogoButton() {
        return addLogoButton;
    }
    public AddTextFieldButtonAction getAddTextFieldButton() {
        return addTextFieldButton;
    }
}
