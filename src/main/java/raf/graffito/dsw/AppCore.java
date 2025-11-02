package raf.graffito.dsw;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.GraffRepository;
import raf.graffito.dsw.core.Gui;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.tree.SwingGui;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        GraffRepository gr = new GraffRepositoryImplementation();
        appCore.initialize(gui, gr);
        appCore.run();
    }
}