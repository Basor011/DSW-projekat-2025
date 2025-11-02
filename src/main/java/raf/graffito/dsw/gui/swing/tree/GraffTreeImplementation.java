package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;
import raf.graffito.dsw.gui.swing.tree.view.PresentationOrSlidePopUp;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;
import raf.graffito.dsw.model.implementations.leaves.compositions.Workspace;
import raf.graffito.dsw.model.implementations.leaves.Slide;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.view.GraffTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class GraffTreeImplementation implements GraffTree{
    private GraffTreeView graffTreeView;
    private DefaultTreeModel treeModel;

    private GraffNode createChild(GraffNode parent) {
        if(parent instanceof Workspace) {
           PresentationOrSlidePopUp dialog = new PresentationOrSlidePopUp(MainFrame.getInstance());
           dialog.setVisible(true);
           Project project = new Project("Project" + new Random().nextInt(100), parent, "autor");
           GraffNode child = null;

           if(dialog.isPresentation()){
               child = new Presentation("Presentation" + new Random().nextInt(100), project);
           }else if(dialog.isSlide()){
               child = new Slide("Slide" + new Random().nextInt(100), project);
           }
           project.addChild(child);

           if(child == null) return null;

           return project;


        }else if(parent instanceof Project) {
            return new Presentation("Presentation" + new Random().nextInt(100), parent);
        }if(parent instanceof Presentation) {
            return new Slide("Slide" + new Random().nextInt(100), parent);
        }
        else if(parent instanceof Slide) {
            ///JOptionPane.showMessageDialog(new Message("You can't add child", "greska", ));
        }
        return null;
    }

    @Override
    public GraffTreeView generateTree(Workspace workspace) {
        GraffTreeItem root = new GraffTreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        graffTreeView = new GraffTreeView(treeModel);
        return graffTreeView;
    }

    @Override
    public void addChild(GraffTreeItem root) {
        if(root.getGraffNode() instanceof GraffNodeComposite){
            GraffNode child = createChild(root.getGraffNode());

            if(child == null) return;

            GraffTreeItem childItem = new GraffTreeItem(child);
            root.add(childItem);
            SwingUtilities.updateComponentTreeUI(graffTreeView);
            ((GraffNodeComposite)root.getGraffNode()).addChild(child);

            if(child instanceof Project){
                Project project = (Project) child;
                for(GraffNode childNode : project.getChildren()){
                    childItem.add(new GraffTreeItem(childNode));
                }
            }
            treeModel.reload(root);
            expantNodes(graffTreeView);

            graffTreeView.expandPath(graffTreeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(graffTreeView);
        }else if(root.getGraffNode() instanceof Slide){
            ApplicationFramework.getInstance().getMg().generateError("Ne moze se dodati dete slajdu");
        }
    }

   @Override
    public void removeNode(GraffTreeItem node) {
       if(node.getGraffNode() instanceof Workspace){
           /// ovde treba da se ispise poruka od messageGeneratora da ne moze da se obrise
           /// workspace
           ApplicationFramework.getInstance().getMg().generateError("Ne moze se obrisati workspace");
           return;
       }
       else {
           treeModel.removeNodeFromParent(node);
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
