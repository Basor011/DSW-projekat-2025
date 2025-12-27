package raf.graffito.dsw.model.brigde.concrete;

import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.*;

public class NormalMode extends WindowMode {
    public NormalMode(ScaleImplement scale) {
        super(scale);
    }

    @Override
    public double getScaleFactor() {
        return 1.0;
    }

    @Override
    public Dimension getWindowSize() {
        MainFrame frame = MainFrame.getInstance();
        return new Dimension(frame.getNormalSize());
    }
}
