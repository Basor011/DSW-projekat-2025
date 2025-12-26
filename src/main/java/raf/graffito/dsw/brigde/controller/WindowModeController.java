package raf.graffito.dsw.brigde.controller;

import raf.graffito.dsw.brigde.WindowMode;

public class WindowModeController {
    private WindowMode mode;
    public void setMode(WindowMode mode) {
        this.mode = mode;
        mode.apply();
    }
}
