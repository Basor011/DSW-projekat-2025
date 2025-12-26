package raf.graffito.dsw.brigde.controller;

import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.brigde.concrete.SmallMode;

import javax.swing.*;

public class SmallModeAction extends AbstractWindowModeAction {
    public SmallModeAction() {
        super("SMALL");
    }

    @Override
    protected WindowMode createMode(ScaleImplement scaler) {
        return new SmallMode(scaler);
    }
}
