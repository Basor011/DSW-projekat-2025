package raf.graffito.dsw.model.state.concrete;

import raf.graffito.dsw.model.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.abs.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;

public class SelectState implements ElementState {

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        List<GraffNode> elements = slideView.getSlideModel().getChildren();

        if (!e.isShiftDown()) {
            for (GraffNode el : elements) {
                Element element = (Element) el;
                element.setSelected(false);
            }
        }

        Element clickedElement = slideView.getElementModel(e.getPoint());
        if (clickedElement != null) {
            if(e.isShiftDown()){
                clickedElement.setSelected(!clickedElement.isSelected());
            }
            else clickedElement.setSelected(true);
        }
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
