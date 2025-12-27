package raf.graffito.dsw.brigde.controller;

import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;

public class WindowModeController {
    private WindowMode mode;
    public void setMode(WindowMode mode) {
        this.mode = mode;
        mode.apply();
    }
}
