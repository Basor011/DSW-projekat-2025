package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.controller.JTabbedPaneChangeListener;
import raf.graffito.dsw.gui.swing.tree.decorator.ColourDecorator;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTabbedPane extends JTabbedPane {

   // private Map<Color, DefaultMutableTreeNode> projectColor;
    private DefaultMutableTreeNode latestNode;
    private List<ColourDecorator>  decoratedProjects;


    public MyTabbedPane(Map<Color, DefaultMutableTreeNode> projectColor) {
     //   this.projectColor = projectColor;
        this.addChangeListener(new JTabbedPaneChangeListener());
       // this.projectColor = new HashMap<>();
        this.decoratedProjects=new ArrayList<>();



    }
/*
    public Map<Color, DefaultMutableTreeNode> getProjectColor() { ///izbrisi
        return projectColor;
    }

 */

    public List<ColourDecorator> getDecoratedProjects() {
        return decoratedProjects;
    }

    public void fillTabs(DefaultMutableTreeNode node) {
        Color colour = JColorChooser.showDialog(MainFrame.getInstance(), "Choose colour", Color.PINK);
        if (colour == null) return;

        //System.out.println(child.toString() + " Test");
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
       // projectColor.put(decoratedProject.getColour(),node); ///izbrisi
        decoratedProjects.add(decoratedProject);
    }

    public void recoverTabs(DefaultMutableTreeNode node)
    {
        this.removeAll();
        Color color=Color.GREEN;
        latestNode=node;
        /*
        for(Map.Entry<Color,DefaultMutableTreeNode> entry : projectColor.entrySet())
        {
            if(entry.getValue().equals(node))
            {
                 color=entry.getKey();
            }
        }

         */
        for(ColourDecorator dp :decoratedProjects)
        {
            if( (dp.getGraffTreeItem()).equals((GraffTreeItem)node) )
            {
                color=dp.getColour();
            }
        }
        for(int i=0;i<node.getChildCount();i++)
        {
            DefaultMutableTreeNode child=(DefaultMutableTreeNode) node.getChildAt(i);
            String title=child.toString();
            JPanel panel=new JPanel();
            this.addTab(title,panel);
            this.setBackgroundAt(i,color);
            this.setForegroundAt(i,Color.BLACK);
        }
    }

    public DefaultMutableTreeNode getLatestNode() {
        return latestNode;
    }


}

