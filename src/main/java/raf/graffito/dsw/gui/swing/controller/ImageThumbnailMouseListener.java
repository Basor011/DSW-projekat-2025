package raf.graffito.dsw.gui.swing.controller;

import raf.graffito.dsw.state.StateManager;
import raf.graffito.dsw.model.proxy.ImageProxy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageThumbnailMouseListener extends MouseAdapter {
    private final ImageProxy proxy;
    private final StateManager stateManager;

    public ImageThumbnailMouseListener(ImageProxy proxy, StateManager stateManager) {
        this.proxy = proxy;
        this.stateManager = stateManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        stateManager.setAddImageState(proxy.getPath());
    }
}
