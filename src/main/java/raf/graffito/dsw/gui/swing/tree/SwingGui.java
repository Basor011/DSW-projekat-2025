package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.Gui;
import raf.graffito.dsw.gui.swing.view.MainFrame;

public class SwingGui implements Gui {
    private MainFrame mainFrame;

    @Override
    public void start() {
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}
