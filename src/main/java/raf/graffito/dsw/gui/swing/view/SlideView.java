package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.controller.state.StateManager;
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
import java.util.HashMap;
import java.util.Map;

public class SlideView extends JPanel {

    private Slide slideModel;
    private Map<Element, ElementView> elementViewMap;
    private StateManager stateManager;

    public SlideView(Slide slideModel, StateManager stateManager) {
        this.slideModel = slideModel;
        this.elementViewMap = new HashMap<>();
        this.stateManager = stateManager;
        JLabel mainLabel = new JLabel(slideModel.getName(), SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(mainLabel, BorderLayout.CENTER);
        //setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(800, 600));
        initElementViews();
        initMouseListener();
    }

    private void initMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                stateManager.getCurrentState().mousePressed(e, SlideView.this);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                stateManager.getCurrentState().mouseDragged(e, SlideView.this);
            }
        });

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
    public void startMoveState(){
        this.stateManager.setMoveState();
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

    public Map<Element, ElementView> getElementViewMap() {
        return elementViewMap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for(GraffNode e: slideModel.getChildren()){
            ElementView elementView = elementViewMap.get(e);
            if(elementView == null) {
                elementView = elementFactory((Element) e);
                elementViewMap.put((Element) e, elementView);
            }
            else elementView.paint(g2d);
        }
        g2d.dispose();
    }

    public Slide getSlideModel() {
        return slideModel;
    }
}
/// dummy model slideview
/* private void init(){
        setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(800, 600));
        JLabel mainLabel = new JLabel("Empty Slide", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(mainLabel, BorderLayout.CENTER);

        JPanel thumbnailsPanel = new JPanel();
        thumbnailsPanel.setLayout(new BoxLayout(thumbnailsPanel, BoxLayout.Y_AXIS));

        String[] imagePaths = {
                "/images/amogus.png",
                "/images/amogus.png",
                "/images/amogus.png",
                "/images/amogus.png",
                "/images/amogus.png"
        };

        for (String path : imagePaths) {
            ImageIcon icon = new ImageIcon(getClass().getResource(path));

            Image scaled = icon.getImage().getScaledInstance(100, 75, Image.SCALE_SMOOTH);
            JLabel thumbLabel = new JLabel(new ImageIcon(scaled));
            thumbLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
            thumbLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            thumbnailsPanel.add(thumbLabel);
        }
        add(thumbnailsPanel, BorderLayout.EAST);
    }
*/

