package raf.graffito.dsw.model.state.concrete;

import raf.graffito.dsw.model.command.MoveElementCommand;
import raf.graffito.dsw.model.state.ElementState;
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

public class MoveState implements ElementState {
    private boolean dragging = false;
    private Point start;
    private MoveElementCommand command;

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView view = slideView.getElementAt(e.getPoint());

        if (view != null && view.getElement().isSelected()) {
            dragging = true;
            start = e.getPoint();

            List<Element> elements = new ArrayList<>();
            for(GraffNode node : slideView.getSlideModel().getChildren()){
                Element element = (Element) node;
                if(element.isSelected()) elements.add(element);
            }
            command = new MoveElementCommand(elements);
        }
    }
    @Override
    public void mouseDragged(MouseEvent e, SlideView slideView) {
        if (!dragging) return;

        int dx = e.getX() - start.x;
        int dy = e.getY() - start.y;

        for(GraffNode gf: slideView.getSlideModel().getChildren()){
            Element el = (Element) gf;
            if(el.isSelected()){
                el.move(dx, dy);
            }
        }
        start = e.getPoint();
    }
    @Override public void mouseReleased(MouseEvent e, Element element) {
        if(dragging && command != null){
            command.captureAfterPositions();
            ApplicationFramework.getInstance().getCommandManager().executeCommand(command);
            command = null;
        }
        dragging = false;
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
