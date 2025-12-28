package raf.graffito.dsw.controller;

import raf.graffito.dsw.controller.program_actions.SaveOrLoadAction;
import raf.graffito.dsw.model.brigde.controller.FullModeAction;
import raf.graffito.dsw.model.brigde.controller.NormalModeAction;
import raf.graffito.dsw.model.brigde.controller.SmallModeAction;
import raf.graffito.dsw.controller.command_actions.RedoAction;
import raf.graffito.dsw.controller.command_actions.UndoAction;
import raf.graffito.dsw.controller.program_actions.AboutUsAction;
import raf.graffito.dsw.controller.program_actions.ExitAction;
import raf.graffito.dsw.controller.state_actions.InsertImagesAction;
import raf.graffito.dsw.controller.jtree_actions.NewChildAction;
import raf.graffito.dsw.controller.jtree_actions.RemoveChildAction;
import raf.graffito.dsw.controller.serializer_actions.LoadAction;
import raf.graffito.dsw.controller.serializer_actions.SaveAction;
import raf.graffito.dsw.controller.serializer_actions.SaveAsAction;

import raf.graffito.dsw.controller.state_actions.*;

public class ActionManager {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewChildAction newChildAction;
    private RemoveChildAction removeChildAction;
    private SaveOrLoadAction saveOrLoadAction;

    private MoveElementAction moveAction;
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

    private LoadAction loadAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;

    private InsertImagesAction insertImagesAction;

    private FullModeAction fullModeAction;
    private SmallModeAction smallModeAction;
    private NormalModeAction normalModeAction;

    public ActionManager() {
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
        newChildAction = new NewChildAction();
        removeChildAction = new RemoveChildAction();
        saveOrLoadAction= new SaveOrLoadAction();

        selectElementAction = new SelectElementAction();
        moveAction = new MoveElementAction();
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

        loadAction=new LoadAction();
        saveAction= new SaveAction();
        saveAsAction= new SaveAsAction();

        insertImagesAction = new InsertImagesAction();

        fullModeAction = new FullModeAction();
        normalModeAction = new NormalModeAction();
        smallModeAction = new SmallModeAction();
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
    public SaveOrLoadAction getSaveOrLoadAction() {
        return saveOrLoadAction;
    }

    public SelectElementAction getSelectElementAction() {return selectElementAction;}
    public MoveElementAction getMoveAction() {return moveAction;}
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

    public LoadAction getLoadAction() {
        return loadAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }
    public CopyElementAction getCopyElementAction() {return copyElementAction;}

    public UndoAction getUndoAction() {return undoAction;}
    public RedoAction getRedoAction() {return redoAction;}

    public InsertImagesAction getInsertImagesAction() {return insertImagesAction;}

    public FullModeAction getFullModeAction() {return fullModeAction;}
    public SmallModeAction getSmallModeAction() {return smallModeAction;}
    public NormalModeAction getNormalModeAction() {return normalModeAction;}
}
