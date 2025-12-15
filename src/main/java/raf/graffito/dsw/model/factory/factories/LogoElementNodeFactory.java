package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.*;
import java.util.Random;

public class LogoElementNodeFactory implements ElementNodeFactory {
    @Override
    public Element createElement(Slide parent, Point location) {
        return new LogoElement("Logo"+ new Random().nextInt(200), parent, location, new Dimension(50, 50));
    }
}
