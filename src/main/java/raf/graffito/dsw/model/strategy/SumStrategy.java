package raf.graffito.dsw.model.strategy;


import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.util.List;


public class SumStrategy implements SpaceStrategy {
    @Override
    public boolean hasEnoughSpace(Slide slide, List<Element> data) {
        return false;
    }


    public void clearOccupied(Slide slide, Element element) {
        int[][]dimensions=slide.getFreeSpace();
        Rectangle rect = element.getBounds();
        int startX = Math.max(0, rect.x);
        int startY = Math.max(0, rect.y);
        int endX = Math.min(dimensions[0].length, rect.x + rect.width);
        int endY = Math.min(dimensions.length, rect.y + rect.height);

        for (int row = startY; row < endY; row++) {
            for (int col = startX; col < endX; col++) {
                dimensions[row][col] = 0;
            }
        }
    }

    @Override
    public boolean canMark(Slide slide, Element element) {
        return true;
    }

    public void markOccupied(Slide slide, Element element)
    {
        int[][]spaceMatrix=slide.getFreeSpace();
        Rectangle rect=element.getBounds();
        int startX = Math.max(0, rect.x);
        int startY = Math.max(0, rect.y);
        int endX = Math.min(spaceMatrix[0].length, rect.x + rect.width);
        int endY = Math.min(spaceMatrix.length, rect.y + rect.height);

        for (int row = startY; row < endY; row++) {
            for (int col = startX; col < endX; col++) {
                spaceMatrix[row][col] = 1;
            }
        }
    }

    @Override
    public boolean over80(Slide slide, Element element) {
        return false;
    }


    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }
}
