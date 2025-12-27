package raf.graffito.dsw.model.brigde.concrete;

import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;

import java.awt.*;

public class SmallMode extends WindowMode {
    public SmallMode(ScaleImplement scale) {
        super(scale);
    }

    @Override
    public double getScaleFactor() {
        return 0.5;
    }

    @Override
    public Dimension getWindowSize() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension(d.width/2, d.height/2);
    }
}
