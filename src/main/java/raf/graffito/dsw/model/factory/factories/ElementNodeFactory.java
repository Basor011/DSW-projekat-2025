package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;

public interface ElementNodeFactory {
    Element createElement(Slide parent, Point location);
}
