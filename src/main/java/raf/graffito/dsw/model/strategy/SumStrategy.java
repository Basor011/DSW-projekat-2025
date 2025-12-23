package raf.graffito.dsw.model.strategy;

public class SumStrategy implements SpaceStrategy
{

    @Override
    public boolean enoughSpace(Object data) {
        return false;
    }
}
