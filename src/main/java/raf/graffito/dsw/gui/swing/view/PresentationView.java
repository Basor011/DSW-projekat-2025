package raf.graffito.dsw.gui.swing.view;

import com.sun.tools.javac.Main;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.controller.GraffTreeModelListener;
import raf.graffito.dsw.gui.swing.tree.controller.GraffTreeMouseClickListener;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel {

    private GraffNodeComposite presentation;
    private List<SlideView> slajdovi;
    private SlideView test;

    public PresentationView(String title, GraffNodeComposite presentation)
    {
        this.setName(title);
        this.presentation = presentation;
        slajdovi=new ArrayList<>();
        setLayout(new BorderLayout());
        System.out.println(presentation.getChildren().size());
        for(GraffNode child : presentation.getChildren()) {
            if(child instanceof Slide) {
                SlideView toAdd = new SlideView((Slide) child, MainFrame.getInstance().getStateManager());
                slajdovi.add(toAdd);
            }
        }
        if(!slajdovi.isEmpty()) {
            add(slajdovi.getFirst(), BorderLayout.CENTER);
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

    public void refresh() {
        System.out.println("Refreshing " + presentation.getName());
        revalidate();
        repaint();
    }
    public void showSlide(Slide slide) {
        SlideView toShow = null;
        for(SlideView sv: slajdovi){
            if(sv.getSlideModel() == slide){
                toShow = sv;
                break;
            }
        }
        if(toShow == null) {
            return;
        }
        removeAll();
        add(toShow, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
