package raf.graffito.dsw.model.brigde.controller;

import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;
import raf.graffito.dsw.model.brigde.concrete.FullMode;

public class FullModeAction extends AbstractWindowModeAction {
    public FullModeAction() {
        super("FULL");
    }

    @Override
    protected WindowMode createMode(ScaleImplement scaler) {
        return new FullMode(scaler);
    }
}
