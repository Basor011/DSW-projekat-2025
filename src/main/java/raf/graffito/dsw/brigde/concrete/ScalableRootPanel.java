package raf.graffito.dsw.brigde.concrete;

import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ScalableRootPanel extends JPanel {
    private final MainFrame mainFrame;

    public ScalableRootPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.scale(mainFrame.getGlobalScale(), mainFrame.getGlobalScale());
        super.paintComponent(g2);
        g2.dispose();
    }
}
