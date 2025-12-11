package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.controller.JTabbedPaneChangeListener;
import raf.graffito.dsw.gui.swing.tree.decorator.ColourDecorator;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyTabbedPane extends JTabbedPane implements PSubscriber {

    private GraffTreeItem latestNode;
    private List<ColourDecorator> decoratedProjects;//vec otvoreni projekti
    private List<PresentationView> presentationViewList;


    public MyTabbedPane() {
        this.addChangeListener(new JTabbedPaneChangeListener());
        this.decoratedProjects = new ArrayList<>();
        this.presentationViewList=new ArrayList<>();
    }

    public List<ColourDecorator> getDecoratedProjects() {
        return decoratedProjects;
    }

    public void fillTabs(GraffTreeItem node) {//node == project,za svaku prezentaciju otvara tab
        Color colour = JColorChooser.showDialog(MainFrame.getInstance(), "Izaberite boju", Color.PINK);
        if (colour == null) return;

        for (ColourDecorator cd : decoratedProjects) {
            if (cd.getColour().equals(colour)) {
                ApplicationFramework.getInstance().getMg().generateError("Vec odabrana boja");
                return;
            }
        }
        this.removeAll(); //sklanaja prethodno otvorene tabove
        latestNode = node;
        ColourDecorator decoratedProject = new ColourDecorator(node, colour);

        for (int i = 0; i < node.getChildCount(); i++) {
            GraffTreeItem child = (GraffTreeItem) node.getChildAt(i);
            GraffNode childNode =  child.getGraffNode();
            String title = childNode.getName();
            System.out.println(node.getGraffNode().getName()+" ja sam veliki carobnjak feniks");

            PresentationView presentationView = new PresentationView(title, (GraffNodeComposite) childNode);
            this.addTab(presentationView.getTitle(), presentationView);
            this.setBackgroundAt(i, colour);
            this.setForegroundAt(i, Color.BLACK);
            presentationViewList.add(presentationView);


        }
        decoratedProjects.add(decoratedProject);
        for(PresentationView pv :presentationViewList)
        {
            ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).addSubscriber(pv);
        }
    }

    public void recoverTabs(GraffTreeItem node) { //project
        this.removeAll();
        Color color = Color.PINK;
        latestNode = node;

        for (ColourDecorator dp : decoratedProjects) {
            if ((dp.getGraffTreeItem()).equals(node)) {
                color = dp.getColour();
            }
        }
        for (int i = 0; i < node.getChildCount(); i++) {///ponovo postavlja stare presentationview tabove koji imaju istu boju kao ranije
            GraffTreeItem child = (GraffTreeItem) node.getChildAt(i); /// prolazim kroz decu od projecta
            for(PresentationView pw :presentationViewList)
            {
                 if(pw.getPresentation().equals(child.getGraffNode()))
                 {
                     this.addTab(pw.getTitle(),pw);
                 }
            }
            this.setBackgroundAt(i, color);
            this.setForegroundAt(i, Color.BLACK);
        }
    }
    public GraffTreeItem getLatestNode() {
        return latestNode;
    }

    public List<PresentationView> getPresentationViewList() {
        return presentationViewList;
    }

    public boolean hasChild(GraffTreeItem child) {
        for (int i = 0; i < latestNode.getChildCount(); i++) {
            GraffTreeItem kid = (GraffTreeItem) latestNode.getChildAt(i);
            if (kid.equals(child)) return true;
        }
        return false;
    }

    @Override
    public void update(Notification notification, GraffTreeItem node)
    {
        if(notification==Notification.PRESENTATION_RENAMED)
        {
            if(getSelectedComponent()==null) return;
            GraffNodeComposite test=((PresentationView) this.getSelectedComponent()).getPresentation();

            if(test.equals(node.getGraffNode())) // ako je renamed prez tr otvorena
            {
                String newName = (node.getGraffNode().getName());
                int index=this.getSelectedIndex();
                this.setTitleAt(index,newName);
                ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendToAll(newName, null);
            }
            else
            {
               recoverTabs(latestNode);
            }
        }
        else if (notification == Notification.PRESENTATION_INSERTED)
        {
            if( node.getParent().equals(latestNode))
            {
                PresentationView presentationView= new PresentationView(node.getGraffNode().getName(), (GraffNodeComposite) node.getGraffNode());
                presentationViewList.add(presentationView);
                recoverTabs( (GraffTreeItem)node.getParent());
            }
        }
        else if (notification == Notification.PROJECT_RENAMED)
        {
            if(latestNode==null) return;
            if(latestNode.equals(node))
            {
                String newName = node.getGraffNode().getName();
                ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendToAll(null, newName);
            }
        }
        else if (notification == Notification.TAB_CHANGED)
        {
            int index=getSelectedIndex();
            if (index == -1) return; //ako ne postoje tabovi return
            String text=getTitleAt(index);
            String text2=latestNode.toString();

            MainFrame.getInstance().getRightPanel().update(text,text2);

        }
        else if(notification == Notification.PROJECT_DELETED)
        {
         getDecoratedProjects().removeIf(cd -> cd.getGraffTreeItem().equals(node));

            if(node.equals(latestNode))
            {
                ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendToAll("","");
                removeAll();
            }
            MainFrame.getInstance().getGraffTree().removeNode(node);
        }
        else if (notification == Notification.PRESENTATION_DELETED){
            if(((GraffTreeItem) node).getParent().getChildCount() == 1){ ApplicationFramework.getInstance().getMg().generateInfo("Projekat mora imati barem jedno dete"); return;}
            if(latestNode!=null && hasChild(node)) {
                presentationViewList.removeIf(pv -> pv.getPresentation().equals(node.getGraffNode()));
                MainFrame.getInstance().getGraffTree().removeNode(node);
                recoverTabs(latestNode);
            }
            else{
                presentationViewList.removeIf(pv -> pv.getPresentation().equals(node.getGraffNode()));
                MainFrame.getInstance().getGraffTree().removeNode(node);
            }
        }
        else if(notification == Notification.SLIDE_INSERTED) // prosledjen node je slajd
        {
            GraffTreeItem parent=(GraffTreeItem)node.getParent(); // presentation grafftreeitem
            GraffNodeComposite parentNode=(GraffNodeComposite) parent.getGraffNode(); // presentation graffnode
            if(!(parent.getGraffNode() instanceof Presentation)) return; //treba da se doda u listu slajdova, parent.getgraffnode= Presentation,

            Slide newSlide = (Slide) node.getGraffNode();
            SlideView newSlideView= new SlideView(newSlide, MainFrame.getInstance().getStateManager());
             /*
                SlideController sc = new SlideController();
                slideView.addMouseListener...
                ---npr klikom na dugme--provera za buttons ce morati ovde
                sc.setState(new AddImageState(slideView,newSlide, "image.path"));
            * */

            for(PresentationView prez : presentationViewList)
            {
                if(prez.getPresentation().equals(parentNode))
                {
                    prez.getSlajdovi().add(newSlideView); // Dodajem  slideview presentationview-u
                    if(parent.getParent().equals(latestNode)) {
                        prez.removeAll();
                        if(!prez.getSlajdovi().isEmpty()) { // ako imaju vec slajdovi
                            prez.add(prez.getSlajdovi().getLast());
                        }
                       // prez.revalidate();
                       // prez.repaint();
                        int idx = this.indexOfComponent(prez);
                        this.setComponentAt(idx, prez);
                        prez.update(Notification.SLIDE_SELECTED,node);
                    }
                }
            }
        }
        else if (notification == Notification.SLIDE_DELETED)
        {
            GraffTreeItem parent= (GraffTreeItem) node.getParent();
            if(node.getParent().getChildCount() == 1 && parent.getGraffNode() instanceof Project){ ApplicationFramework.getInstance().getMg().generateInfo("Projekat mora imati barem jedno dete"); return;}
            MainFrame.getInstance().getGraffTree().removeNode(node);

        }
        else if (notification== Notification.OPENING_TABS)
        {
            if(node.getGraffNode() instanceof Project) {
                for(ColourDecorator cd : getDecoratedProjects()) {
                    if (cd.getGraffTreeItem().equals(node)) {

                       recoverTabs(node);
                        return;
                    }
                }
                fillTabs(node);
            }
            else if(node.getGraffNode() instanceof  Slide)
            {
                System.out.println(node);
                ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.SLIDE_SELECTED,node);
            }

        }
        else if (notification == Notification.NODE_DELETED)
        {
            if(node == null)
            {
                ApplicationFramework.getInstance().getMg().generateInfo("Molim vas izaberite cvor za brisanje");
                return;
            }

            if(node.getGraffNode() instanceof Project)
            {
                update(Notification.PROJECT_DELETED,node);

            }
            else if ( node.getGraffNode() instanceof  Presentation)
            {
                update(Notification.PRESENTATION_DELETED,node);
            }
            else if (node.getGraffNode() instanceof Slide)
            {
                update(Notification.SLIDE_DELETED,node);
            }
            else if (node.getGraffNode() instanceof Workspace)
            {
                ApplicationFramework.getInstance().getMg().generateError("Ne moze se izbrisati workspace");
            }
        }
        else if( notification == Notification.SWITCH_TABS)
        {
            Presentation presentation = (Presentation) node.getGraffNode().getParent();
            for(PresentationView prv : presentationViewList)
            {
                if(presentation.equals(prv.getPresentation()))
                {
                    setSelectedComponent(prv);
                }
            }
        }

    }
}

