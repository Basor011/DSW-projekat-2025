package raf.graffito.dsw.model.brigde.controller;

import raf.graffito.dsw.model.brigde.WindowMode;

public class WindowModeController {
    private WindowMode mode;
    public void setMode(WindowMode mode) {
        this.mode = mode;
        mode.apply();
    }
}
