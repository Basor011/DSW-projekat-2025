package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.commands.ResizeElementCommand;
import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

public class ResizeElementState implements ElementState {
    private boolean dragging = false;
    private Point start;
    private ResizeElementCommand command;
    private List<Element> selected;
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView view = slideView.getElementAt(e.getPoint());
        if(view == null || !view.getElement().isSelected()) return;
        selected = new ArrayList<>();
        dragging = true;
        start = e.getPoint();

        for(GraffNode gf : slideView.getSlideModel().getChildren()){
            Element element = (Element) gf;
            if(element.isSelected()){
                selected.add(element);
            }
        }
        command = new ResizeElementCommand(selected);
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {
        if (!dragging) return;

        int dx = e.getX() - start.x;
        int dy = e.getY() - start.y;

        for(Element el : selected){
            Dimension d = el.getDimension();
            el.resize(dx, dy);
        }

        start = e.getPoint();
        slideView.repaint();
    }
    @Override public void mouseReleased(MouseEvent e, Element element) {
        if(!dragging) return;
        dragging = false;
        command.captureAfter();
        ApplicationFramework.getInstance().getCommandManager().executeCommand(command);
        command= null;
        selected = null;
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
