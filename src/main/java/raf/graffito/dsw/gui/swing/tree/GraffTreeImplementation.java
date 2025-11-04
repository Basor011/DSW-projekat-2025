package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.observer.TBPublisher;
import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
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
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraffTreeImplementation implements GraffTree, TBPublisher
{
    private GraffTreeView graffTreeView;
    private DefaultTreeModel treeModel;
    private List<TBSubscriber> tbSubscriberList;

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
        }else if(parent instanceof Presentation) {
            return new Slide("Slide" + new Random().nextInt(100), parent);
        }

        return null;
    }

    @Override
    public GraffTreeView generateTree(Workspace workspace) {
        GraffTreeItem root = new GraffTreeItem(workspace);
        this.treeModel = new DefaultTreeModel(root);
        this.graffTreeView = new GraffTreeView(treeModel);
        tbSubscriberList=new ArrayList<>();
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


    @Override
    public void addSubscriber(TBSubscriber subscriber) {
        tbSubscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(TBSubscriber subscriber) {
        tbSubscriberList.remove(subscriber);

    }

    @Override
    public void sendToAll() {

    }

    public List<TBSubscriber> getTbSubscriberList() {
        return tbSubscriberList;
    }

    public GraffTreeView getGraffTreeView() {
        return graffTreeView;
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }
}

