package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.Slide;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel  {

    private GraffNodeComposite presentation;
    private List<SlideView> slajdovi;
    private SlideView test;

    public PresentationView(String title, GraffNodeComposite presentation)
    {
        this.setName(title);
        this.presentation = presentation;
        slajdovi=new ArrayList<>();
        test=new SlideView(new Slide("TEST",presentation));
        setLayout(new BorderLayout());
        add(test, BorderLayout.CENTER);
        System.out.println(presentation.getChildren().size());
        for(GraffNode child : presentation.getChildren())
        {
            System.out.println(child.toString() + " OVDE");
        }
    }


    public String getTitle() {
        return this.getName();
    }

    public GraffNodeComposite getPresentation() {
        return presentation;
    }

    public List<SlideView> getSlajdovi() {
        return slajdovi;
    }


}
