package raf.graffito.dsw.model.brigde;

import java.awt.*;

public abstract class WindowMode {
    private ScaleImplement scale;

    public WindowMode(ScaleImplement scale) {
        this.scale = scale;
    }
    public final void apply(){
        scale.applyScale(getWindowSize(),getScaleFactor());
    }
    public abstract double getScaleFactor();
    public abstract Dimension getWindowSize();
}
