package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;




public class ZoomState implements ElementState
{
    private static final double MAX_ZOOM = 3.0;
    private static final double MIN_ZOOM = 0.5;
    private static final double ZOOM_INCREMENT = 0.5;
    @Override public void mousePressed(MouseEvent e, SlideView slideView) {}
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override
    public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView)
    {

        int rotation = e.getWheelRotation();
        double scaleFactor= slideView.getScaleFactor();

        if (rotation < 0 && scaleFactor < MAX_ZOOM)
        {
            scaleFactor+=ZOOM_INCREMENT;
        }
        else if (rotation > 0 && scaleFactor > MIN_ZOOM)
        {
            scaleFactor-=ZOOM_INCREMENT;
        }
        slideView.setScaleFactor(scaleFactor);

        slideView.getCurrentTransform().setToIdentity();
        slideView.getCurrentTransform().setToScale(scaleFactor,scaleFactor);
        slideView.repaint();
    }
}
