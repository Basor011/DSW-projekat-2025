package raf.graffito.dsw.brigde.concrete;

import com.fasterxml.jackson.annotation.JsonCreator;
import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;
import raf.graffito.dsw.gui.swing.view.SlideView;

import java.awt.*;
import java.util.List;

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
