package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.controller.state.concrete.*;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

import java.awt.image.BufferedImage;

public class StateManager {
    private ElementState elementState;
    private AddState addImageState;
    private ChangeElementState changeElementState;
    private CopyState copyState;
    private DeleteState deleteState;
    private MoveState moveState;
    private RotationState rotationState;
    private ScaleState scaleState;
    private SelectState selectState;

    public StateManager(SlideView slidePanel, GraffNodeComposite slideNode, String imagepath, BufferedImage logoimage) {

    }
    private void init(SlideView slidePanel, GraffNodeComposite slideNode, String imagepath, BufferedImage logoimage) {
        addImageState = new AddState(slidePanel, slideNode, imagepath);
    }

    public ElementState getState() {
        return elementState;
    }

    public void setAddImageState(AddState addImageState) {
        this.addImageState = addImageState;
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
