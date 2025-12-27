package raf.graffito.dsw.brigde.concrete;

import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;
import raf.graffito.dsw.gui.swing.view.SlideView;

import java.awt.*;
import java.util.List;

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
