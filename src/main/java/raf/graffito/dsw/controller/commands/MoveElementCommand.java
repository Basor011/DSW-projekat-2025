package raf.graffito.dsw.controller.commands;

import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveElementCommand implements Command {
    private List<Element> elements;
    private List<Point> beforePositions;
    private List<Point> afterPositions;

    public MoveElementCommand(List<Element> elements) {
        this.elements = elements;
        this.beforePositions = new ArrayList<Point>();
        this.afterPositions = new ArrayList<Point>();

        for(Element element : elements){
            beforePositions.add(new Point(element.getLocation()));
        }
    }
    public void captureAfterPositions() {
        for (Element element : elements) {
            afterPositions.add(new Point(element.getLocation()));
        }
    }
    @Override
    public void execute() {
        for(int i = 0; i < elements.size(); i++){
            elements.get(i).getLocation().setLocation(afterPositions.get(i));
        }
        MainFrame.getInstance().repaint();
    }

    @Override
    public void undo() {
        for(int i = 0; i < elements.size(); i++){
            elements.get(i).getLocation().setLocation(beforePositions.get(i));
        }
        MainFrame.getInstance().repaint();
    }
}
