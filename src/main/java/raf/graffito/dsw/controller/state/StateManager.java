package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.controller.state.concrete.*;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StateManager {
    private ElementState currentState;
    private MoveState moveState;
    private AddImageState addImageState;
    private AddLogoState addLogoState;
    private AddTextFieldState addTextFieldState;
    private SelectState selectState;

    public StateManager() {
        initstates();
    }

    private void initstates() {
        moveState = new MoveState();
        addLogoState = new AddLogoState();
        addTextFieldState = new AddTextFieldState();
        addImageState = new AddImageState(null);
        selectState = new SelectState();
        currentState = selectState;
    }

    public ElementState getCurrentState() {
        return currentState;
    }

    public void setSelectState() {
        currentState = selectState;
    }

    public void setMoveState() {
        currentState = moveState;
    }

    public void setAddImageState(String imagePath) {
        addImageState = new AddImageState(imagePath);
        currentState = addImageState;
    }

    public void setAddLogoState() {
        currentState = addLogoState;
    }

    public void setAddTextFieldState() {
        currentState = addTextFieldState;
    }

}
