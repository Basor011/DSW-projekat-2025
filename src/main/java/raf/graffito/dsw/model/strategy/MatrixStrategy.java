package raf.graffito.dsw.model.strategy;

public class MatrixStrategy implements  SpaceStrategy
{

    @Override
    public boolean enoughSpace(Object data) {
        return false;
    }
}
