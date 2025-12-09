package raf.graffito.dsw.controller;

import raf.graffito.dsw.controller.state_actions.AddImageAction;
import raf.graffito.dsw.controller.state_actions.AddLogoAction;
import raf.graffito.dsw.controller.state_actions.AddTextFieldAction;
import raf.graffito.dsw.controller.state_actions.MoveElementAction;

import java.awt.*;

public class ActionManager {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewChildAction newChildAction;
    private RemoveChildAction removeChildAction;

    private MoveElementAction moveAction;
    private AddImageAction addImageButton;
    private AddLogoAction addLogoButton;
    private AddTextFieldAction addTextFieldButton;

    public ActionManager() {
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
        newChildAction = new NewChildAction();
        removeChildAction = new RemoveChildAction();

        moveAction = new MoveElementAction();
        addImageButton = new AddImageAction();
        addLogoButton = new AddLogoAction();
        addTextFieldButton = new AddTextFieldAction();
    }
    public ExitAction getExitAction() {return exitAction;}
    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }
    public NewChildAction getNewChildAction() {
        return newChildAction;
    }
    public RemoveChildAction getRemoveChildAction() {
        return removeChildAction;
    }

    public MoveElementAction getMoveAction() {return moveAction;}
    public AddImageAction getAddImageButton() {return addImageButton;}
    public AddLogoAction getAddLogoButton() {return addLogoButton;}
    public AddTextFieldAction getAddTextFieldButton() {return addTextFieldButton;}
}
