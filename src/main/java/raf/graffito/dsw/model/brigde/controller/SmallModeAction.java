package raf.graffito.dsw.model.brigde.controller;

import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;
import raf.graffito.dsw.model.brigde.concrete.SmallMode;

public class SmallModeAction extends AbstractWindowModeAction {
    public SmallModeAction() {
        super("SMALL");
    }

    @Override
    protected WindowMode createMode(ScaleImplement scaler) {
        return new SmallMode(scaler);
    }
}
