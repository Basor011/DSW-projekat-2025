package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MyTabbedPane extends JTabbedPane {

    private Map<Color, DefaultMutableTreeNode> projectColor=new HashMap<>();
    public void fillTabs(DefaultMutableTreeNode node,Color colour, int index)
    {
        for(Color key : projectColor.keySet())
        {
            if(key.equals(colour))
            {
                ApplicationFramework.getInstance().getMg().generateError("Nedostupna boja");
                return;
            }
        }

        String title=node.toString();
        JPanel panel= new JPanel();
        //panel.setBackground(colour);
        this.addTab(title,panel);
        this.setBackgroundAt(index,colour);
        projectColor.put(colour,node);


    }

}
