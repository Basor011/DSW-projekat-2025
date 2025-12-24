package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.controller.state.StateManager;
import raf.graffito.dsw.model.proxy.ImageProxy;
import raf.graffito.dsw.model.proxy.ImageSubject;

import javax.swing.*;
import java.awt.*;

public class ImageListView extends JPanel {
    private JPanel panel;
    private StateManager stateManager;

    public ImageListView(StateManager stateManager) {
        this.stateManager = stateManager;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(50, 200));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
    }
    public void addImg(ImageProxy proxy) {
        panel.add(new ImageThumbnail(proxy, stateManager));
        revalidate();
        repaint();
    }
}
