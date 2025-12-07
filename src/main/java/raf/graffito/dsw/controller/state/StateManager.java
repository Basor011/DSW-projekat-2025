package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.controller.state.concrete.*;

public class StateManager {
    private ElementState elementState;
    private AddImageState addImageState;
    private AddTextState addTextState;
    private AddLogoState addLogoState;
    private ChangeElementState changeElementState;
    private CopyState copyState;
    private DeleteState deleteState;
    private MoveState moveState;
    private RotationState rotationState;
    private ScaleState scaleState;
    private SelectState selectState;

    public StateManager() {
        initStates();
    }
    private void initStates() {
        addImageState = new AddImageState();
        addTextState = new AddTextState();
        addLogoState = new AddLogoState();
        changeElementState = new ChangeElementState();
        copyState = new CopyState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        rotationState = new RotationState();
        scaleState = new ScaleState();
        selectState = new SelectState();
    }

    public ElementState getState() {
        return elementState;
    }

    public void setAddImageState(AddImageState addImageState) {
        this.addImageState = addImageState;
    }

    public void setAddTextState(AddTextState addTextState) {
        this.addTextState = addTextState;
    }

    public void setAddLogoState(AddLogoState addLogoState) {
        this.addLogoState = addLogoState;
    }

    public void setChangeElementState(ChangeElementState changeElementState) {
        this.changeElementState = changeElementState;
    }

    public void setCopyState(CopyState copyState) {
        this.copyState = copyState;
    }

    public void setDeleteState(DeleteState deleteState) {
        this.deleteState = deleteState;
    }

    public void setMoveState(MoveState moveState) {
        this.moveState = moveState;
    }

    public void setRotationState(RotationState rotationState) {
        this.rotationState = rotationState;
    }

    public void setScaleState(ScaleState scaleState) {
        this.scaleState = scaleState;
    }

    public void setSelectState(SelectState selectState) {
        this.selectState = selectState;
    }
}
