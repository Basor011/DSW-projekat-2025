package raf.graffito.dsw.model.command;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        afterPositions.clear();
        for (Element element : elements) {
            afterPositions.add(new Point(element.getLocation()));
        }
    }
    @Override
    public void execute() {
        for(int i = 0; i < elements.size(); i++){
            elements.get(i).setLocationa(afterPositions.get(i));
        }
    }

    @Override
    public void undo() {
        for(int i = 0; i < elements.size(); i++){
            elements.get(i).setLocationa(beforePositions.get(i));
        }
    }
}
