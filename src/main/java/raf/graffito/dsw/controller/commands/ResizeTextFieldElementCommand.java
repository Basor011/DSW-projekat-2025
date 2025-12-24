package raf.graffito.dsw.controller.commands;

import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import java.util.ArrayList;
import java.util.List;

public class ResizeTextFieldElementCommand implements Command {
    private final List<TextFieldElement> elements;
    private final List<Integer> before;
    private List<Integer> after;

    public ResizeTextFieldElementCommand(List<TextFieldElement> elements) {
        this.elements = elements;
        this.before = new ArrayList<>();
        for (TextFieldElement e : elements) {
            before.add(e.getFontSize());
        }
    }
    public void apply(int delta) {
        for (TextFieldElement e : elements) e.changeFontSize(delta);
    }
    @Override
    public void execute() {
        if (after == null) {
            after = new ArrayList<>();
            for (TextFieldElement e : elements) {
                after.add(e.getFontSize());
            }
        }

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setFontSize(after.get(i));
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < elements.size(); i++) elements.get(i).setFontSize(before.get(i));
    }
}
