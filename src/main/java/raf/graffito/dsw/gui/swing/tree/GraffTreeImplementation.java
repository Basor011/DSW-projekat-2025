package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.GraffRepository;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.model.factory.GraffNodeFactory;
import raf.graffito.dsw.gui.swing.model.factory.factories.PresentationFactory;
import raf.graffito.dsw.gui.swing.model.factory.factories.ProjectFactory;
import raf.graffito.dsw.gui.swing.model.factory.factories.WorkspaceFactory;
import raf.graffito.dsw.gui.swing.tree.view.PresentationOrSlidePopUp;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.model.composite.GraffNode;
import raf.graffito.dsw.gui.swing.model.composite.GraffNodeComposite;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.compositions.Project;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.compositions.Workspace;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.Slide;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.view.GraffTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class GraffTreeImplementation implements GraffTree {
    private GraffTreeView graffTreeView;
    private DefaultTreeModel treeModel;


    @Override
    public GraffTreeView generateTree(Workspace workspace) {
        GraffTreeItem root = new GraffTreeItem(workspace);
        this.treeModel = new DefaultTreeModel(root);
        this.graffTreeView = new GraffTreeView(treeModel);
        //treeModel.addTreeModelListener(new GraffTreeModelListener());
        return graffTreeView;
    }

    @Override
    public void addChild(GraffTreeItem root) {

        GraffRepositoryImplementation repo = (GraffRepositoryImplementation) ApplicationFramework.getInstance().getGr(); //repo pravi dete pomocu factory
        GraffNode parentN = root.getGraffNode();
        GraffNode child = repo.createChild(parentN);

        if(child == null) return;

        repo.addChild(parentN, child);
        GraffTreeItem childItem = new GraffTreeItem(child);
        root.add(childItem);

        if(child instanceof GraffNodeComposite composite){
            for(GraffNode c : composite.getChildren()){
                childItem.add(new GraffTreeItem(c));
            }
        }

        treeModel.reload(root);
        expantNodes(graffTreeView);

       /* graffTreeView.expandPath(graffTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(graffTreeView);*/

        /*if (root.getGraffNode() instanceof GraffNodeComposite) {
            GraffNode child = createChild(root.getGraffNode());

            if (child == null) return;

            GraffTreeItem childItem = new GraffTreeItem(child);
            root.add(childItem);
            SwingUtilities.updateComponentTreeUI(graffTreeView);
            ((GraffNodeComposite) root.getGraffNode()).addChild(child);

            if (child instanceof Project) {
                Project project = (Project) child;
                for (GraffNode childNode : project.getChildren()) {
                    childItem.add(new GraffTreeItem(childNode));
                }
            }
            treeModel.reload(root);
            expantNodes(graffTreeView);

            graffTreeView.expandPath(graffTreeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(graffTreeView);
        } else if (root.getGraffNode() instanceof Slide) {
            ApplicationFramework.getInstance().getMg().generateError("Ne moze se dodati dete slajdu");
        }*/
    }

    @Override
    public void removeNode(GraffTreeItem node) {
        if (node.getGraffNode() instanceof Workspace) {
            /// ovde treba da se ispise poruka od messageGeneratora da ne moze da se obrise
            /// workspace
            ApplicationFramework.getInstance().getMg().generateError("Ne moze se obrisati workspace");
            return;
        } else {
            treeModel.removeNodeFromParent(node);
            SwingUtilities.updateComponentTreeUI(graffTreeView);
        }
    }

    @Override
    public GraffTreeItem getSelectedNode() {
        return (GraffTreeItem) graffTreeView.getLastSelectedPathComponent();
    }

    private void expantNodes(JTree tree){
        int row = 0;
        while(row < tree.getRowCount()){
            tree.expandRow(row);
            row++;
        }
    }
}
