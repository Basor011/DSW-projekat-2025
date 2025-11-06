package raf.graffito.dsw.gui.swing.model.factory.factories;

import raf.graffito.dsw.gui.swing.model.composite.GraffNode;
import raf.graffito.dsw.gui.swing.model.factory.GraffNodeFactory;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.Slide;

import java.util.Random;

public class PresentationFactory implements GraffNodeFactory {
    @Override
    public GraffNode createNode(GraffNode parent) {
        return new Slide("Slide" + new Random().nextInt(100), parent);
    }
}
