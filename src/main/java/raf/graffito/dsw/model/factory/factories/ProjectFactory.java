package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.abs.GraffNode;
import raf.graffito.dsw.model.factory.GraffNodeFactory;
import raf.graffito.dsw.model.composite.compositions.Presentation;

import java.util.Random;

public class ProjectFactory implements GraffNodeFactory {
    @Override
    public GraffNode createNode(GraffNode parent) {
        return new Presentation("Presentation" + new Random().nextInt(100), parent);
    }
}
