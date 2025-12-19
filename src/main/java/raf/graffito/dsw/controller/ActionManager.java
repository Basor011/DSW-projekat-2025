package raf.graffito.dsw.controller;

import raf.graffito.dsw.controller.state.state_actions.*;

public class ActionManager {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewChildAction newChildAction;
    private RemoveChildAction removeChildAction;

    private MoveElementAction moveAction;
    private AddImageAction addImageButton;
    private AddLogoAction addLogoButton;
    private AddTextFieldAction addTextFieldButton;
    private SelectElementAction selectElementAction;
    private DeleteElementAction deleteElementAction;
    private ResizeElementAction resizeElementAction;
    private ZoomElementAction zoomElementAction;
    private ShowRotateButtonAction showRotateButtonAction;
    private RotateElementAction rotateElementAction;
    private CopyElementAction copyElementAction;

    private UndoAction undoAction;
    private RedoAction redoAction;

    public ActionManager() {
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
        newChildAction = new NewChildAction();
        removeChildAction = new RemoveChildAction();

        selectElementAction = new SelectElementAction();
        moveAction = new MoveElementAction();
        addImageButton = new AddImageAction();
        addLogoButton = new AddLogoAction();
        addTextFieldButton = new AddTextFieldAction();
        deleteElementAction=new DeleteElementAction();
        resizeElementAction=new ResizeElementAction();
        zoomElementAction=new ZoomElementAction();
        showRotateButtonAction =new ShowRotateButtonAction();
        rotateElementAction= new RotateElementAction();
        copyElementAction=new CopyElementAction();

        undoAction=new UndoAction();
        redoAction=new RedoAction();
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

    public SelectElementAction getSelectElementAction() {return selectElementAction;}
    public MoveElementAction getMoveAction() {return moveAction;}
    public AddImageAction getAddImageButton() {return addImageButton;}
    public AddLogoAction getAddLogoButton() {return addLogoButton;}
    public AddTextFieldAction getAddTextFieldButton() {return addTextFieldButton;}
    public DeleteElementAction getDeleteElementAction() {return deleteElementAction;}
    public ResizeElementAction getResizeElementAction() {return resizeElementAction;}
    public ZoomElementAction getZoomElementAction() {
        return zoomElementAction;
    }
    public RotateElementAction getRotateElementAction() {
        return rotateElementAction;
    }
    public ShowRotateButtonAction getShowRotateButtonAction() {
        return showRotateButtonAction;
    }
    public CopyElementAction getCopyElementAction() {return copyElementAction;}

    public UndoAction getUndoAction() {return undoAction;}
    public RedoAction getRedoAction() {return redoAction;}
}
