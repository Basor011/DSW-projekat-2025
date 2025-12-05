package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.model.implementations.leaves.Slide;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel  {

    private GraffTreeItem presentation;
    private List<SlideView> slajdovi;
    private JTabbedPane tabbedPane;
    private SlideView test;

    public PresentationView(String title, GraffTreeItem presentation)
    {
        this.setName(title);
        this.presentation = presentation;
        slajdovi=new ArrayList<>();
        test=new SlideView(new Slide("TEST",presentation.getGraffNode()));
        setLayout(new BorderLayout());
        add(test, BorderLayout.CENTER);
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

    public List<SlideView> getSlajdovi() {
        return slajdovi;
    }
}
