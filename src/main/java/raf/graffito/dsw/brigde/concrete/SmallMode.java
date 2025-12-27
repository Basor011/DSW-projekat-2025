package raf.graffito.dsw.brigde.concrete;

import com.fasterxml.jackson.annotation.JsonCreator;
import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;
import raf.graffito.dsw.gui.swing.view.SlideView;

import java.awt.*;
import java.util.List;

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
