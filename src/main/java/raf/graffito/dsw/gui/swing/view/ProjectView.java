package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectView implements PSubscriber {
    private Project project;
    private MyTabbedPane tabbedPane;

    public ProjectView(MyTabbedPane tabbedPane) {
        this.tabbedPane = MainFrame.getInstance().getTabbedPane();
    }

    @Override
    public void update(DefaultMutableTreeNode node) {

    }
}
