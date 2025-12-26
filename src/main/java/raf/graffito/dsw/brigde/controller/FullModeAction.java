package raf.graffito.dsw.brigde.controller;

import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.brigde.concrete.FullMode;

import javax.swing.*;

public class FullModeAction extends AbstractWindowModeAction {
    public FullModeAction() {
        super("FULL");
    }

    @Override
    protected WindowMode createMode(ScaleImplement scaler) {
        return new FullMode(scaler);
    }
}
