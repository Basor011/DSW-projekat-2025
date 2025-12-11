package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import java.awt.*;
import java.util.Random;

public class TextFieldElementNodeFactory implements ElementNodeFactory {
    String text;

    public TextFieldElementNodeFactory(String text) {
        this.text = text;
    }

    @Override
    public Element createElement(Slide parent, Point location) {
        return new TextFieldElement("TextField"+new Random().nextInt(200), parent, location, new Dimension(50, 50), text);
    }
}
