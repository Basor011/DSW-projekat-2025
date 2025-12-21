package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.controller.state.StateManager;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.*;

public class SlideViewMouseController extends MouseAdapter implements MouseMotionListener, MouseWheelListener{
    private final SlideView slideView;
    private final StateManager stateManager;

    public SlideViewMouseController(SlideView slideView, StateManager stateManager) {
        this.slideView = slideView;
        this.stateManager = stateManager;
    }
    @Override public void mousePressed(MouseEvent e) {stateManager.getCurrentState().mousePressed(e, slideView);}
    @Override public void mouseDragged(MouseEvent e) {stateManager.getCurrentState().mouseDragged(e, slideView);}
    @Override public void mouseWheelMoved(MouseWheelEvent e) {stateManager.getCurrentState().mouseWheelMoved(e, slideView);}
    @Override public void mouseReleased(MouseEvent e) {stateManager.getCurrentState().mouseReleased(e, null);}
}
