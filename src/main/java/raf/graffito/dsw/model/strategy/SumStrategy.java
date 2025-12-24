package raf.graffito.dsw.model.strategy;


import raf.graffito.dsw.model.composite.leaves.Element;

public class SumStrategy implements SpaceStrategy
{
    @Override
    public boolean hasEnoughSpace(Element data, int[][] dimensions) {
        int rows= dimensions.length;
        int cols=dimensions[0].length;

        double totalArea=rows*cols;
        double occupiedArea=calculateOccupiedArea(dimensions);
        double occupiedPercentage = (occupiedArea / totalArea) * 100;



        return occupiedPercentage <= 80.0;
    }

    private int calculateOccupiedArea(int[][] dimensions)
    {
        int cnt=0;
        int rows= dimensions.length;
        int cols=dimensions[0].length;
        for(int i=0;i< rows;i++)
        {
            for(int j=0;j< cols;j++)
            {
                if(dimensions[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}
