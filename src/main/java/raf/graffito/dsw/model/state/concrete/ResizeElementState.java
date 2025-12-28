package raf.graffito.dsw.model.state.concrete;

import raf.graffito.dsw.model.command.ResizeElementCommand;
import raf.graffito.dsw.model.command.ResizeTextFieldElementCommand;
import raf.graffito.dsw.model.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.abs.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

public class ResizeElementState implements ElementState {
    private boolean dragging = false;
    private Point start;

    private ResizeElementCommand command;
    private ResizeTextFieldElementCommand txfCommand;


    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView view = slideView.getElementAt(e.getPoint());
        if(view == null) return;
        Element clicked = view.getElement();
        if(clicked == null || !clicked.isSelected()) return;
        if (!view.isOnBorder(e.getPoint(), slideView.getScaleFactor())) return;

        dragging = true;
        start = e.getPoint();

        List<TextFieldElement> txfs = new ArrayList<>();
        List<Element> others = new ArrayList<>();

        for(GraffNode gf : slideView.getSlideModel().getChildren()){
            Element element = (Element) gf;
            if(!element.isSelected()) continue;
            if(element instanceof TextFieldElement tf) txfs.add(tf);
            else others.add(element);
        }
        if(!txfs.isEmpty()) txfCommand = new ResizeTextFieldElementCommand(txfs);
        if(!others.isEmpty()) command = new ResizeElementCommand(others);
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {
        if (!dragging) return;

        double scale = slideView.getScaleFactor();
        int rawDx = e.getPoint().x - start.x;
        int rawDy = e.getPoint().y - start.y;
        int dx = (int) (rawDx/scale);
        int dy = (int) (rawDy/scale);

        if(txfCommand != null) txfCommand.apply(dy);
        if(command != null) command.apply(dx, dy);

        start = e.getPoint();

        System.out.println("RAW dx=" + rawDx + " dy=" + rawDy +
                " | scale=" + scale +
                " | model dx=" + dx + " dy=" + dy);
    }
    @Override public void mouseReleased(MouseEvent e, Element element) {
        if(!dragging) return;
        dragging = false;

        if(txfCommand != null) ApplicationFramework.getInstance().getCommandManager().executeCommand(txfCommand);
        if(command != null) ApplicationFramework.getInstance().getCommandManager().executeCommand(command);

        command = null;
        txfCommand = null;
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
