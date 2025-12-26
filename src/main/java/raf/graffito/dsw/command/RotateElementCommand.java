package raf.graffito.dsw.command;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.util.ArrayList;
import java.util.List;

public class RotateElementCommand implements Command {
    private List<Element> elements;
    private List<Double> beforeRotations;
    private List<Double> afterRotations;

    public RotateElementCommand(List<Element> elements) {
        this.elements = new ArrayList<>(elements);
        this.beforeRotations = new ArrayList<>();
        this.afterRotations = new ArrayList<>();

        for (Element element : elements) {
            beforeRotations.add(element.getRotationAngle());
        }
    }

    public void apply(boolean clockwise) {
        for (Element element : elements) {
            element.rotate90(clockwise);
        }
    }

    public void captureAfterRotations() {
        afterRotations.clear();
        for (Element element : elements) {
            afterRotations.add(element.getRotationAngle());
        }
    }

    @Override
    public void execute() {
        if (afterRotations.isEmpty()) {
            for (Element element : elements) {
                afterRotations.add(element.getRotationAngle());
            }
        }

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setRotationAngle(afterRotations.get(i));
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setRotationAngle(beforeRotations.get(i));
        }
    }
}