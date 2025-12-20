package raf.graffito.dsw.controller.commands;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResizeElementCommand implements Command {
    private List<Element> elements;
    private List<Dimension> before;
    private List<Dimension> after;

    public ResizeElementCommand(List<Element> elements) {
        this.elements = new ArrayList<>(elements);
        this.before = new ArrayList<>();
        this.after = new ArrayList<>();
        for (Element e : elements) {
            before.add(new Dimension(e.getDimension()));
        }
    }
    public void captureAfter() {
        after.clear();
        for (Element e : elements) {
            after.add(new Dimension(e.getDimension()));
        }
    }

    public void execute() {
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setDimensions(after.get(i).width, after.get(i).height);
        }
    }
    public void undo() {
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setDimensions(before.get(i).width, before.get(i).height);
        }
    }
}
