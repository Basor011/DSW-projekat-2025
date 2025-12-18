package raf.graffito.dsw.gui.swing.commands;

import raf.graffito.dsw.model.composite.leaves.Element;

public class RotateElementCommand implements Command {
    private Element element;
    private double before;
    private double after;

    public RotateElementCommand(Element element, double before, double after) {
        this.element = element;
        this.before = before;
        this.after = after;
    }

    public void execute() {element.setRotationAngle(after);}
    public void undo() {element.setRotationAngle(before);}
}
