package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.controller.state.concrete.*;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

import java.awt.image.BufferedImage;

public class StateManager {
    private ElementState currentState;
    private AddImageState addImageState;
    private AddLogoState addLogoState;
    private AddTextFieldState addTextFieldState;

    public StateManager(SlideView slidePanel, GraffNodeComposite slideNode) {
        init(slidePanel, slideNode);
        currentState = null;
    }

    private void init(SlideView slidePanel, GraffNodeComposite slideNode) {
        addImageState = new AddImageState(slidePanel, slideNode);
        addLogoState = new AddLogoState(slidePanel, slideNode);
        addTextFieldState = new AddTextFieldState(slidePanel, slideNode);
    }

    public void setAddImageState()   { currentState = addImageState; }
    public void setAddLogoState()    { currentState = addLogoState; }
    public void setAddTextFieldState() { currentState = addTextFieldState; }

    public ElementState getCurrentState() { return currentState; }
}

