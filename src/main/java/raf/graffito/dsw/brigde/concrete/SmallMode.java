package raf.graffito.dsw.brigde.concrete;

import com.fasterxml.jackson.annotation.JsonCreator;
import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.*;

public class SmallMode extends WindowMode {
    private int width;
    private int height;

    public SmallMode(ScaleImplement scale) {
        super(scale);
        this.width = MainFrame.getInstance().getScreenWidth();
        this.height = MainFrame.getInstance().getScreenHeight();
    }
    @Override
    public void apply() {
        MainFrame frame = MainFrame.getInstance();

        int smallWidth = width / 2;
        int smallHeight = height / 2;

        frame.setSize(smallWidth, smallHeight);
        frame.setLocationRelativeTo(null);

        scaleWindow(0.5);
    }
    @Override
    public double getScaleFactor() {
        return 0.5;
    }

    @Override
    public Dimension getWindowSize() {
        return new Dimension(width/2, height/2);
    }
}
