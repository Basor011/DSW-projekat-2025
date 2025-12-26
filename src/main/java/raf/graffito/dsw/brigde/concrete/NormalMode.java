package raf.graffito.dsw.brigde.concrete;

import com.fasterxml.jackson.annotation.JsonCreator;
import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
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
    public void apply() {
        MainFrame mf = MainFrame.getInstance();
        mf.setSize(mf.getScreenWidth(), mf.getScreenHeight());
        mf.setLocationRelativeTo(null);
        scaleWindow(1.0);
    }

    @Override
    public Dimension getWindowSize() {
        return new Dimension(MainFrame.getInstance().getScreenWidth(), MainFrame.getInstance().getScreenHeight());
    }
}
