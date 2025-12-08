package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.controller.state.concrete.*;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StateManager {
    private ElementState currentState;

    public StateManager(ElementState currentState) {
        this.currentState = currentState;
    }

    public void mousePressed(MouseEvent e, SlideView slideView) {
        if(currentState != null) {
            currentState.mousePressed(e, slideView);
        }
    }

    public void setCurrentState(ElementState currentState) {
        this.currentState = currentState;
    }

    public ElementState getCurrentState() { return currentState; }
}

