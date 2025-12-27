package raf.graffito.dsw.model.brigde.controller;

import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;
import raf.graffito.dsw.model.brigde.concrete.NormalMode;

public class NormalModeAction extends AbstractWindowModeAction {
    public NormalModeAction() {
        super("NORMAL");
    }

    @Override
    protected WindowMode createMode(ScaleImplement scaler) {
        return new NormalMode(scaler);
    }
}
