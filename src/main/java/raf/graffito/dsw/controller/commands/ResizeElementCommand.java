package raf.graffito.dsw.controller.commands;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;

public class ResizeElementCommand implements Command {
    private Element element;
    private Dimension before;
    private Dimension after;

    public ResizeElementCommand(Element element, Dimension before, Dimension after) {
        this.element = element;
        this.before = before;
        this.after = after;
    }
    public void execute() {element.setDimensions(after.width, after.height);}
    public void undo() {element.setDimensions(before.width, before.height);}
}
