    package raf.graffito.dsw.gui.swing.view;

    import raf.graffito.dsw.state.StateManager;
    import raf.graffito.dsw.gui.swing.controller.SlideViewMouseController;
    import raf.graffito.dsw.gui.swing.tree.observer.SSubscriber;
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
    import java.awt.geom.AffineTransform;
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Map;

    public class SlideView extends JPanel implements SSubscriber {

        private Slide slideModel;
        private Map<Element, ElementView> elementViewMap;

        private StateManager stateManager;

        private double scaleFactor = 1.0;
        private AffineTransform currentTransform = new AffineTransform();

        private Dimension base;

        public SlideView(Slide slideModel, StateManager stateManager) {
            this.slideModel = slideModel;
            this.elementViewMap = new HashMap<>();
            this.stateManager = stateManager;

            Dimension frameSize = MainFrame.getInstance().getSize();
            this.base = new Dimension(frameSize.width/2, frameSize.height/2);

            slideModel.addSubscriber((SSubscriber) this);
            slideModel.setFreeSpace(new int[base.height][base.width]);

            setBackground(Color.LIGHT_GRAY);
            setPreferredSize(base);

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
        private Point toModelPoint(Point p){
            return new Point((int)(p.getX()/scaleFactor), (int)(p.getY()/scaleFactor));
        }
        public int toModelDelta(int delta){
            return (int) (delta/scaleFactor);
        }
        public ElementView getElementAt(Point p) { //omogucava da znamo koji element je kliknut
            Point modelPoint =  toModelPoint(p);
            for (Element e : elementViewMap.keySet()) {
                ElementView view = elementViewMap.get(e);
                if (view.getBounds().contains(modelPoint)) {
                    return view;
                }
            }
            return null;
        }
        public Element getElementModel(Point p) {
            ElementView view = getElementAt(p);
            if(view == null) return null;
            return view.getElement();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            AffineTransform at = new AffineTransform();
            at.scale(scaleFactor, scaleFactor);
            g2d.transform(at);

            Iterator<Element> it = elementViewMap.keySet().iterator();
            while(it.hasNext()){
                Element e = it.next();
                if(!slideModel.getChildren().contains(e)) it.remove();
            }

            for(GraffNode e: slideModel.getChildren()){
                Element el = (Element) e;
                ElementView elementView = elementViewMap.computeIfAbsent(el, this :: elementFactory);
                elementView.paintWithRotate(g2d);
            }
            g2d.dispose();
        }
        public void updateScale(double newScale) {
            this.scaleFactor = newScale;
            int w = (int) (base.width * newScale);
            int h = (int) (base.height * newScale);

            setPreferredSize(new Dimension(w, h));

            revalidate();
            repaint();
        }
        public Slide getSlideModel() {return slideModel;}
        public double getScaleFactor() {return scaleFactor;}
        public AffineTransform getCurrentTransform() {return currentTransform;}
        public void setScaleFactor(double scaleFactor) {this.scaleFactor = scaleFactor;}

        @Override public void update() {repaint();}
    }
