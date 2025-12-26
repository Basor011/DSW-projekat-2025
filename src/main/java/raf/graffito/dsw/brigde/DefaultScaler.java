package raf.graffito.dsw.brigde;

import com.sun.tools.javac.Main;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.MyTabbedPane;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class DefaultScaler implements ScaleImplement{
    private MainFrame frame;

    public DefaultScaler(MainFrame mf) {
        this.frame = mf;
    }

    @Override
    public void applyScale(double factor) {
        frame.setGlobalScale(factor);
    }
}
