package raf.graffito.dsw.model.command;

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
    public void apply(int dx, int dy) {
        for (Element e : elements) {
            e.resize(dx, dy);
        }
    }
    @Override
    public void execute() {
        if(after.isEmpty()) {
            for (Element e : elements) {
                after.add(new Dimension(e.getDimension()));
            }
        }
        for (int i = 0; i < elements.size(); i++) {
            Dimension d = after.get(i);
            elements.get(i).setDimensions(d.width, d.height);
        }
        System.out.println("EXECUTE resize");
    }
    @Override
    public void undo() {
        for (int i = 0; i < elements.size(); i++) {
            Dimension d = before.get(i);
            elements.get(i).setDimensions(d.width, d.height);
        }
    }
}
