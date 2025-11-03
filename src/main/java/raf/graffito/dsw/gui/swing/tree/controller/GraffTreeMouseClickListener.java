package raf.graffito.dsw.gui.swing.tree.controller;

import com.sun.tools.javac.Main;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraffTreeMouseClickListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTree tree = (JTree) e.getSource();
            TreePath path = tree.getSelectionPath();
            if (path == null) return;

            DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode)path.getLastPathComponent();  //vraca poslednji element na kraju path-a

           if(selectedNode.toString().contains("Presentation")) {
               MainFrame.getInstance().getTabbedPane().removeAll();
               for (int i = 0; i < selectedNode.getChildCount(); i++) {
                   DefaultMutableTreeNode child = (DefaultMutableTreeNode) selectedNode.getChildAt(i);
                   System.out.println(child.toString() + " Test"); // or whatever you stored
                   MainFrame.getInstance().fillJTabbedpane(child);
               }
           }

        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
