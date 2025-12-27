package raf.graffito.dsw.model.brigde.concrete;

import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;

import java.awt.*;

public class FullMode extends WindowMode {
    public FullMode(ScaleImplement scaleImplement) {
        super(scaleImplement);
    }

    @Override
    public double getScaleFactor() {
        return 1.5;
    }


    @Override
    public Dimension getWindowSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
