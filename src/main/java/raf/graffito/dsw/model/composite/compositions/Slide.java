package raf.graffito.dsw.model.composite.compositions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.tree.observer.SSubscriber;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.strategy.MatrixStrategy;
import raf.graffito.dsw.model.strategy.SpaceStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Slide extends GraffNodeComposite {
    private List<SSubscriber>subs= new ArrayList<>(); ///mozda bi observer za slide bio pametan
    private int[][] freeSpace;
    @JsonIgnore
    private SpaceStrategy strategy;
    protected Slide(){}
    public Slide(String name, GraffNode parent) {
        super(name, parent);
        strategy=new MatrixStrategy();
        freeSpace=null;
    }
    @Override
    public void addChild(GraffNode child) {
        if(child instanceof GraffNodeLeaf) {
            if(strategy.hasEnoughSpace((Element) child,freeSpace)) {
                if (!children.contains(child)) {
                    child.setParent(this);
                    children.add(child);
                    notifySubscribers();
                }
            } else ApplicationFramework.getInstance().getMg().generateInfo("Nema mesta");
        }
    }
    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
        notifySubscribers();
    }

    public int[][] getFreeSpace() {
        return freeSpace;
    }
    public void setFreeSpace(int[][] freeSpace) {
        this.freeSpace = freeSpace;
    }
    public SpaceStrategy getStrategy() {
        return strategy;
    }
    public void setStrategy(SpaceStrategy strategy) {
        this.strategy = strategy;
    }
    public void addSubscriber(SSubscriber s) {subs.add(s);}
    public void removeSubscriber(SSubscriber s) {subs.remove(s);}
    public void notifySubscribers() {
        for (SSubscriber s : subs) {
            s.update();
        }
    }
}
