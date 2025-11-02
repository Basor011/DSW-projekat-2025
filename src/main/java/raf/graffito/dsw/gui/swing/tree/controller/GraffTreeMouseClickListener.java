package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.view.MainFrame;
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

            DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode)path.getLastPathComponent();  //vraca poslednji element path-a

            Object userObject=selectedNode.getUserObject(); // da li je project, slide, prez
            if(userObject instanceof Project)
            {
                MainFrame.getInstance().showJTabbedpane((Project)userObject);
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
