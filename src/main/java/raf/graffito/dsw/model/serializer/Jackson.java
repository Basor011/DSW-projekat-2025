package raf.graffito.dsw.model.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.abs.GraffNode;
import raf.graffito.dsw.model.composite.abs.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

import java.io.File;
import java.io.IOException;

public class Jackson implements  Serializer {
    private final ObjectMapper objectMapper;

    public Jackson() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void loadProject(File file) {
        try {
            Workspace root = ApplicationFramework.getInstance().getGr().getWorkspace();
            Project loadedProject = objectMapper.readValue(file, Project.class);
            root.addChild(loadedProject);
            rebuildParents(loadedProject);
            updateTreeUI(loadedProject, root);
            System.out.println("Projekat je ucitan");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void saveProject(Project project, File file) {

        try {
           // System.out.println(project.isIzmenjen());
            objectMapper.writeValue(file, project);
            System.out.println("Projekat je sačuvan u: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateTreeUI(Project loadedProject, Workspace root) {
        GraffTreeImplementation graffTree = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();
        DefaultTreeModel treeModel = graffTree.getTreeModel();
        GraffTreeItem rootItem = (GraffTreeItem) treeModel.getRoot();
        GraffTreeItem projectItem = createTreeItemRecursive(loadedProject);
        treeModel.insertNodeInto(projectItem, rootItem, rootItem.getChildCount());
        graffTree.expantNodes(graffTree.getGraffTreeView());
        SwingUtilities.updateComponentTreeUI(graffTree.getGraffTreeView());
    }

    private GraffTreeItem createTreeItemRecursive(GraffNode node) {
        GraffTreeItem item = new GraffTreeItem(node);
        if (node instanceof GraffNodeComposite) {
            GraffNodeComposite composite = (GraffNodeComposite) node;
            for (GraffNode child : composite.getChildren()) {
                GraffTreeItem childItem = createTreeItemRecursive(child);
                item.add(childItem);
            }
        }

        return item;
    }
    public static void rebuildParents(GraffNodeComposite parent) {
        for (GraffNode child : parent.getChildren()) {
            child.setParent(parent);
            if (child instanceof GraffNodeComposite composite) {
                rebuildParents(composite);
            }
        }
    }

}



