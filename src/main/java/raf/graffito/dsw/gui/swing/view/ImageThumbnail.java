package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.state.StateManager;
import raf.graffito.dsw.gui.swing.controller.ImageThumbnailMouseListener;
import raf.graffito.dsw.model.proxy.ImageProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageThumbnail extends JPanel{
    private final ImageProxy proxy;

    public ImageThumbnail(ImageProxy proxy, StateManager stateManager) {
        this.proxy = proxy;

        setPreferredSize(new Dimension(160, 100));
        setMaximumSize(new Dimension(160, 100));
        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new ImageThumbnailMouseListener(proxy, stateManager));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = proxy.getImage();
        if(image != null) {
            g.drawImage(image, 10, 10, 50, 50, null);
        }
    }
}
