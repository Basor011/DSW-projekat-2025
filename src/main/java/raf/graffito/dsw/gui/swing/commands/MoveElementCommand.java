package raf.graffito.dsw.gui.swing.commands;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveElementCommand implements Command {
    private Map<Element, Point> before = new HashMap<>();
    private Map<Element, Point> after = new HashMap<>();

    public MoveElementCommand(List<Element> elements, Map<Element, Point> beforePositions) {
        this.before.putAll(beforePositions);

        for (Element e : elements) {
            after.put(e, new Point(e.getLocation()));
        }
    }

    @Override
    public void execute() {
        for (Element e : after.keySet()) {
            Point p = after.get(e);
            e.getLocation().setLocation(p);
        }
    }

    @Override
    public void undo() {
        for (Element e : before.keySet()) {
            Point p = before.get(e);
            e.getLocation().setLocation(p);
        }
    }
}
