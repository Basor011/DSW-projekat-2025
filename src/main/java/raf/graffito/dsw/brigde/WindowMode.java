package raf.graffito.dsw.brigde;

import java.awt.*;

public abstract class WindowMode {
    private ScaleImplement scale;

    public WindowMode(ScaleImplement scale) {
        this.scale = scale;
    }
    public void apply(){
        scale.applyScale(getScaleFactor());
    }
    public abstract double getScaleFactor();
    public abstract Dimension getWindowSize();
    protected void scaleWindow(double factor) {
        scale.applyScale(factor);
    }
}
