package raf.graffito.dsw.model.strategy;

import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;

public class MatrixStrategy implements  SpaceStrategy
{
    int[][] setMatrix;
    private SpaceStrategy strategy=new SumStrategy();
    @Override
    public boolean hasEnoughSpace(Element data, int[][] dimensions)
    {
        int[][] copy= deepCopy(dimensions);

        if (!markOccupied(data, copy)) {
            return false;
        }

        if (!strategy.hasEnoughSpace(data, copy)) {
            return false;
        }

        MainFrame.getInstance().getTabbedPane().getSelectedPresentation().getLastSelectedSlide().getSlideModel().setFreeSpace(copy);

        return true;
    }
    private boolean markOccupied(Element element, int[][] dimensions)
    {
        Rectangle rect=element.getBounds();
        int startX = Math.max(0, rect.x);
        int startY = Math.max(0, rect.y);
        int endX = Math.min(dimensions[0].length, rect.x + rect.width);
        int endY = Math.min(dimensions.length, rect.y + rect.height);

        for (int row = startY; row < endY; row++) {
            for (int col = startX; col < endX; col++) {
                if(dimensions[row][col]==1) return false;
                dimensions[row][col] = 1;
            }
        }
        setMatrix=dimensions;
        return true;

    }

    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }


}
