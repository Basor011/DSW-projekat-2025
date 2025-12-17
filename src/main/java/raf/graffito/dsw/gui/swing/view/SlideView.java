package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.controller.state.StateManager;
import raf.graffito.dsw.gui.swing.tree.controller.SlideViewMouseController;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ImageView;
import raf.graffito.dsw.gui.swing.view.slide_elements.LogoView;
import raf.graffito.dsw.gui.swing.view.slide_elements.TextFieldVIew;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.ImageElement;
import raf.graffito.dsw.model.composite.leaves.LogoElement;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SlideView extends JPanel {

    private Slide slideModel;
    private Map<Element, ElementView> elementViewMap;

    private StateManager stateManager;
    private static final Dimension size=new Dimension(700,500);

    private double scaleFactor = 1.0;
    private AffineTransform currentTransform = new AffineTransform();

    public SlideView(Slide slideModel, StateManager stateManager) {
        this.slideModel = slideModel;
        this.elementViewMap = new HashMap<>();
        this.stateManager = stateManager;
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        initElementViews();
        initMouseListener();
    }

    private void initMouseListener() {
        SlideViewMouseController controller = new SlideViewMouseController(this, stateManager);
        addMouseMotionListener(controller);
        addMouseListener(controller);
        addMouseWheelListener(controller);
    }

    private void initElementViews() {
        for(GraffNode e: slideModel.getChildren()){
            elementViewMap.put((Element) e, elementFactory((Element) e));

        }
    }
    private ElementView elementFactory(Element element) {
        if(element instanceof LogoElement) return new LogoView((LogoElement) element);
        if(element instanceof TextFieldElement) return new TextFieldVIew((TextFieldElement) element);
        if (element instanceof ImageElement) return new ImageView((ImageElement) element);
        return null;
    }
    public void addElement(Element element) {
        slideModel.addChild(element);
        elementViewMap.put(element, elementFactory((Element) element));

        repaint();
    }
    public ElementView getElementAt(Point p) { //omogucava da znamo koji element je kliknut
        for (Element e : elementViewMap.keySet()) {
            ElementView view = elementViewMap.get(e);
            if (view.getBounds().contains(p)) {
                return view;
            }
        }
        return null;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.transform(currentTransform);

        Iterator<Element> it = elementViewMap.keySet().iterator();
        while(it.hasNext()){
            Element e = it.next();
            if(!slideModel.getChildren().contains(e)) it.remove();
        }

        for(GraffNode e: slideModel.getChildren()){
            Element el = (Element) e;
            ElementView elementView = elementViewMap.get(e);
            if(elementView == null) {
                elementView = elementFactory(el);
                elementViewMap.put(el, elementView);
            }
            elementView.paintWithRotate(g2d);
        }
        g2d.dispose();
    }
    public Slide getSlideModel() {return slideModel;}
    public Map<Element, ElementView> getElementViewMap() {return elementViewMap;}
    public StateManager getStateManager() {return stateManager;}
    public double getScaleFactor() {return scaleFactor;}
    public AffineTransform getCurrentTransform() {return currentTransform;}
    public void setScaleFactor(double scaleFactor) {this.scaleFactor = scaleFactor;}
    public void setCurrentTransform(AffineTransform currentTransform) {this.currentTransform = currentTransform;}
}
