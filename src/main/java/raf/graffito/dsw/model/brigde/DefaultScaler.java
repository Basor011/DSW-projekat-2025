package raf.graffito.dsw.model.brigde;

import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.awt.*;

public class DefaultScaler implements ScaleImplement{
    private MainFrame frame;
    //samo ovde smemo da menjamo mf
    public DefaultScaler(MainFrame mf) {
        this.frame = mf;
    }

    @Override
    public void applyScale(Dimension windowsize, double factor) {
        frame.setSize(windowsize);
        frame.setLocationRelativeTo(null);
        frame.setGlobalScale(factor);
    }
}
