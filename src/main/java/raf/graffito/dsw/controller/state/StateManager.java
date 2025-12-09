package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.controller.state.concrete.*;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StateManager {
    private ElementState currentState;
    private MoveState moveState;

    public StateManager() {}
    private void initstates(){
        moveState = new MoveState();
        currentState = moveState;
    }

    public ElementState getCurrentState() {
        return currentState;
    }

    public void setMoveState() {
        currentState = moveState;
    }
}

