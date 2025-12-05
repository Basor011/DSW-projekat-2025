package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.factory.GraffNodeFactory;
import raf.graffito.dsw.model.composite.compositions.Slide;

import java.util.Random;

public class PresentationFactory implements GraffNodeFactory {
    @Override
    public GraffNode createNode(GraffNode parent) {
        return new Slide("Slide" + new Random().nextInt(100), parent);
    }
}
