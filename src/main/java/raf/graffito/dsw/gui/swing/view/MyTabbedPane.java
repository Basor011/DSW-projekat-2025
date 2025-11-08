package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.controller.JTabbedPaneChangeListener;
import raf.graffito.dsw.gui.swing.tree.decorator.ColourDecorator;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.implementations.leaves.Slide;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;
import raf.graffito.dsw.model.implementations.leaves.compositions.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyTabbedPane extends JTabbedPane implements PSubscriber {

    private DefaultMutableTreeNode latestNode;
    private List<ColourDecorator> decoratedProjects;


    public MyTabbedPane() {
        this.addChangeListener(new JTabbedPaneChangeListener());
        this.decoratedProjects = new ArrayList<>();

    }

    public List<ColourDecorator> getDecoratedProjects() {
        return decoratedProjects;
    }

    public void fillTabs(DefaultMutableTreeNode node) {
        Color colour = JColorChooser.showDialog(MainFrame.getInstance(), "Choose colour", Color.PINK);
        if (colour == null) return;


        for (ColourDecorator cd : decoratedProjects) {
            if (cd.getColour().equals(colour)) {
                ApplicationFramework.getInstance().getMg().generateError("Nedostupna boja");
                return;
            }
        }
        this.removeAll();
        latestNode = node;
        ColourDecorator decoratedProject = new ColourDecorator((GraffTreeItem) node, colour);
        for (int i = 0; i < node.getChildCount(); i++) {
            /*
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            String title = child.toString();
            JPanel panel = new JPanel();
            this.addTab(title, panel);
            this.setBackgroundAt(i, colour);
            this.setForegroundAt(i, Color.BLACK);

             */

            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            String title = child.toString();
            PresentationView presentationView = new PresentationView(title, (GraffTreeItem) child);
            //System.out.println(presentationView.toString());
            this.addTab(presentationView.getTitle(), presentationView);

            this.setBackgroundAt(i, colour);
            this.setForegroundAt(i, Color.BLACK);
        }

        decoratedProjects.add(decoratedProject);
    }

    public void recoverTabs(DefaultMutableTreeNode node) {
        this.removeAll();
        Color color = Color.PINK;
        latestNode = node;

        for (ColourDecorator dp : decoratedProjects) {
            if ((dp.getGraffTreeItem()).equals((GraffTreeItem) node)) {
                color = dp.getColour();
            }
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            String title = child.toString();
            PresentationView presentationView = new PresentationView(title, (GraffTreeItem) child);
            this.addTab(presentationView.getTitle(), presentationView);

            this.setBackgroundAt(i, color);
            this.setForegroundAt(i, Color.BLACK);

        }
    }

    public DefaultMutableTreeNode getLatestNode() {
        return latestNode;
    }

    public boolean hasChild(GraffTreeItem child) {
        for (int i = 0; i < latestNode.getChildCount(); i++) {
            GraffTreeItem kid = (GraffTreeItem) latestNode.getChildAt(i);
            if (kid.equals(child)) return true;
        }
        return false;
    }


    @Override
    public void update(Notification notification, Object node)
    {
        if(notification==Notification.PRESENTATION_RENAMED)
        {
            if(getSelectedComponent()==null) return;
            GraffTreeItem test=((PresentationView) this.getSelectedComponent()).getPresentation();

            if(test.equals(node)) // ako je renamed prez tr otvorena
            {
                String newName = ((GraffTreeItem) node).getGraffNode().getName();
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
            if( ((DefaultMutableTreeNode)node).getParent().equals(latestNode) )
            {
                recoverTabs( (DefaultMutableTreeNode) ((DefaultMutableTreeNode) node).getParent() );
            }
        }
        else if (notification == Notification.PROJECT_RENAMED)
        {
            if(latestNode==null) return;
            if(latestNode.equals(node))
            {
                String newName = ((GraffTreeItem)node).getGraffNode().getName();
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
            MainFrame.getInstance().getGraffTree().removeNode((GraffTreeItem) node);
        }
        else if (notification == Notification.PRESENTATION_DELETED)
        {
            if(((GraffTreeItem) node).getParent().getChildCount() == 1){ ApplicationFramework.getInstance().getMg().generateInfo("Projekat mora imati barem jedno dete"); return;}
            if(hasChild((GraffTreeItem) node))
            {

                MainFrame.getInstance().getGraffTree().removeNode((GraffTreeItem)node);
                recoverTabs(latestNode);
            }
        }
        else if (notification == Notification.SLIDE_DELETED)
        {
            if(((GraffTreeItem) node).getParent().getChildCount() == 1){ ApplicationFramework.getInstance().getMg().generateInfo("Projekat mora imati barem jedno dete"); return;}
            MainFrame.getInstance().getGraffTree().removeNode((GraffTreeItem)node);

        }
        else if (notification== Notification.OPENING_TABS)
        {
            if(((GraffTreeItem) node).getGraffNode() instanceof Project) {
                for(ColourDecorator cd : getDecoratedProjects()) {
                    if (cd.getGraffTreeItem().equals(node)) {

                       recoverTabs((GraffTreeItem) node);
                        return;
                    }
                }
                fillTabs((GraffTreeItem) node);
            }
        }
        else if (notification == Notification.NODE_DELETED)
        {
            if(node == null)
            {
                ApplicationFramework.getInstance().getMg().generateInfo("Molim vas izaberite cvor za brisanje");
                return;
            }

            if(((GraffTreeItem) node).getGraffNode() instanceof Project)
            {
                update(Notification.PROJECT_DELETED,node);
               // ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PROJECT_DELETED,node);
            }
            else if (((GraffTreeItem) node).getGraffNode() instanceof  Presentation)
            {
                update(Notification.PRESENTATION_DELETED,node);
               // ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_DELETED,node);
            }
            else if (((GraffTreeItem) node).getGraffNode() instanceof Slide)
            {
                update(Notification.SLIDE_DELETED,node);
                //((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.SLIDE_DELETED,node);
            }
            else if (((GraffTreeItem) node).getGraffNode()instanceof Workspace)
            {
                ApplicationFramework.getInstance().getMg().generateError("Ne moze se izbrisati workspace");
            }
        }
    }
}

