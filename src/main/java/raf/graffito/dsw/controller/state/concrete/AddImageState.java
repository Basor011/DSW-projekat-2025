package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.ImageElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AddImageState implements ElementState {
    private String imagePath;
    public AddImageState(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImagePath(String path) {
        this.imagePath = path;
    }
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        if (imagePath == null) return;

        Point p = e.getPoint();

        Element img = new ImageElement(
                "Image",
                slideView.getSlideModel(),
                new Point(p.x, p.y),
                new Dimension(120, 90),
                imagePath
        );

        slideView.addElement(img);
        slideView.repaint();
        MainFrame.getInstance().getRightPanel().startSelectState();
    }

    @Override
    public void mouseDragged(MouseEvent e, SlideView slideView) {

    }

    @Override
    public void mouseReleased(MouseEvent e, Element element) {

    }

    @Override
    public void mouseClicked(MouseEvent e, Element element) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {

    }
}
