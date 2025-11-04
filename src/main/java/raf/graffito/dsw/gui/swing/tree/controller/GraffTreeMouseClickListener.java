package raf.graffito.dsw.gui.swing.tree.controller;

import com.sun.tools.javac.Main;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraffTreeMouseClickListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 2 ) {
            JTree tree = (JTree) e.getSource();
            TreePath path = tree.getSelectionPath();
            if (path == null) return;

            GraffTreeItem selectedNode=(GraffTreeItem)path.getLastPathComponent();  //vraca poslednji element na kraju path-a

           if(selectedNode.getGraffNode() instanceof Project) {
               if(MainFrame.getInstance().getTabbedPane().getProjectColor().containsValue(selectedNode)){

                  MainFrame.getInstance().getTabbedPane().recoverTabs(selectedNode);
               }
               else {
                   Color colour = JColorChooser.showDialog(MainFrame.getInstance(), "Choose colour", Color.PINK);
                   if (colour == null) return;
                   MainFrame.getInstance().getTabbedPane().fillTabs(selectedNode, colour);
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
