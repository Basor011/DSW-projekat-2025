package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;


import javax.swing.*;

public class PresentationView extends JPanel  {

    private GraffTreeItem presentation;
    private JTabbedPane tabbedPane;

    public PresentationView(String title, GraffTreeItem presentation)
    {
        this.setName(title);
        this.presentation = presentation;
    }



    public String getTitle() {
        return this.getName();
    }

    public GraffTreeItem getPresentation() {
        return presentation;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

}
