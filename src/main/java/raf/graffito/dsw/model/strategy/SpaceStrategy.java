package raf.graffito.dsw.model.strategy;


import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;


import java.util.List;

public interface SpaceStrategy {

    boolean hasEnoughSpace(Slide slide, List<Element> data);
    void clearOccupied(Slide slide, Element element);
    boolean canMark(Slide slide, Element element);
    void markOccupied(Slide slide, Element element);
    boolean over80(Slide slide, Element element);

}
