package raf.graffito.dsw.brigde.controller;

import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.brigde.concrete.NormalMode;

import javax.swing.*;

public class NormalModeAction extends AbstractWindowModeAction {
    public NormalModeAction() {
        super("NORMAL");
    }

    @Override
    protected WindowMode createMode(ScaleImplement scaler) {
        return new NormalMode(scaler);
    }
}
