package raf.graffito.dsw.brigde.concrete;

import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.WindowMode;
import raf.graffito.dsw.gui.swing.view.MainFrame;

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
    public void apply() {
        MainFrame mf = MainFrame.getInstance();
        Toolkit tk = mf.getToolkit();
        Dimension screenSize = tk.getScreenSize();
        mf.setSize(screenSize);
        mf.setLocationRelativeTo(null);
        scaleWindow(1.5);
    }

    @Override
    public Dimension getWindowSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
