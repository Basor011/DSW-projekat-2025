package raf.graffito.dsw.model.strategy;

import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.util.List;

public class MatrixStrategy implements  SpaceStrategy
{
    private Rectangle rect;
    @Override
    public boolean hasEnoughSpace(Slide slide, List<Element> data)
    {
        int[][] copy= deepCopy(slide.getFreeSpace());

        if (!canMark(slide, data.getFirst())) {
            return false;
        }

        markOccupied(slide, data.getFirst());

        if (over80(slide, data.getFirst())) {
            return false;
        }
        slide.setFreeSpace(copy);

        return true;
    }
    public void markOccupied(Slide slide, Element element)
    {
        int[][]spaceMatrix=slide.getFreeSpace();
        rect=element.getBounds();
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
    public boolean canMark(Slide slide, Element element) {
        int[][]dimensions=slide.getFreeSpace();
        rect=element.getBounds();
        int startX = Math.max(0, rect.x);
        int startY = Math.max(0, rect.y);
        int endX = Math.min(dimensions[0].length, rect.x + rect.width);
        int endY = Math.min(dimensions.length, rect.y + rect.height);
        for (int row = startY; row < endY; row++) {
            for (int col = startX; col < endX; col++) {
                if(dimensions[row][col]==1) return false;

            }
        }
        return true;
    }

    public void clearOccupied(Slide slide, Element element) {
        int[][]dimensions=slide.getFreeSpace();
        rect = element.getBounds();
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
    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }

    @Override
    public boolean over80(Slide slide, Element element) {
        int[][] spaceMatrix= slide.getFreeSpace();
        int cnt = 0;
        int rows = spaceMatrix.length;
        int cols = spaceMatrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (spaceMatrix[i][j] == 1) cnt++;
            }
        }
        double totalArea = rows * cols;
        double occupiedPercentage = (cnt / totalArea) * 100;


        return occupiedPercentage >= 80.0;
    }
}
