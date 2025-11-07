package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.controller.JTabbedPaneChangeListener;
import raf.graffito.dsw.gui.swing.tree.decorator.ColourDecorator;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyTabbedPane extends JTabbedPane {

    private DefaultMutableTreeNode latestNode;
    private List<ColourDecorator>  decoratedProjects;

    public MyTabbedPane() {
        this.addChangeListener(new JTabbedPaneChangeListener());
        this.decoratedProjects=new ArrayList<>();

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
        ColourDecorator decoratedProject= new ColourDecorator((GraffTreeItem) node,colour);
        for (int i=0; i < node.getChildCount(); i++)
        {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            String title = child.toString();
            JPanel panel = new JPanel();
            this.addTab(title, panel);
            this.setBackgroundAt(i, colour);
            this.setForegroundAt(i, Color.BLACK);
        }

        decoratedProjects.add(decoratedProject);
    }

    public void recoverTabs(DefaultMutableTreeNode node)
    {
        this.removeAll();
        Color color=Color.PINK;
        latestNode=node;

        for(ColourDecorator dp :decoratedProjects)
        {
            if( (dp.getGraffTreeItem()).equals((GraffTreeItem)node) )
            {
                color=dp.getColour();
            }
        }
        for(int i=0;i<node.getChildCount();i++)
        {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            String title = child.toString();
            JPanel panel = new JPanel();
            this.addTab(title, panel);
            this.setBackgroundAt(i, color);
            this.setForegroundAt(i, Color.BLACK);

        }
    }

    public DefaultMutableTreeNode getLatestNode() {
        return latestNode;
    }


}

