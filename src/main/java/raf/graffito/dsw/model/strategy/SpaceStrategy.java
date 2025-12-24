package raf.graffito.dsw.model.strategy;


import raf.graffito.dsw.model.composite.leaves.Element;

public interface SpaceStrategy {

    boolean hasEnoughSpace(Element data, int[][] dimensions);

}
