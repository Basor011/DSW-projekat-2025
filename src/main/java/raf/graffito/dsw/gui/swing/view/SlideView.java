package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SlideView extends JPanel {

    private Slide slideModel;
    private Map<Element, ElementView> elementViewMap;

    public SlideView(Slide slideModel) {
        this.slideModel = slideModel;
        elementViewMap = new HashMap<>();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(800, 600));

    }

    private void init(){
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

    public Slide getSlideModel() {
        return slideModel;
    }
}

