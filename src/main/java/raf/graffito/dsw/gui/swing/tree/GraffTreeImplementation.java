package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.tree.observer.*;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.compositions.Workspace;
import raf.graffito.dsw.gui.swing.tree.view.    GraffTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class GraffTreeImplementation implements GraffTree, TBPublisher, PPublisher
{
    private GraffTreeView graffTreeView;
    private DefaultTreeModel treeModel;
    private List<TBSubscriber> tbSubscriberList; //publisher
    private List<PSubscriber> pSubscribers;

    @Override
    public GraffTreeView generateTree(Workspace workspace) {
        GraffTreeItem root = new GraffTreeItem(workspace);
        this.treeModel = new DefaultTreeModel(root);
        this.graffTreeView = new GraffTreeView(treeModel);
        graffTreeView.setToggleClickCount(0);
        tbSubscriberList=new ArrayList<>(); //publisher
        pSubscribers=new ArrayList<>();
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
        ((DefaultTreeModel) treeModel).insertNodeInto(childItem, root, root.getChildCount());

        if(child instanceof GraffNodeComposite composite){
            for(GraffNode c : composite.getChildren()){
                childItem.add(new GraffTreeItem(c));
            }
        }
        expantNodes(graffTreeView);
    }

    @Override
    public void removeNode(GraffTreeItem node) {
        if (node.getGraffNode() instanceof Workspace) {
            ApplicationFramework.getInstance().getMg().generateError("Ne moze se obrisati workspace");
            return;
        } else {
            treeModel.removeNodeFromParent(node);
            SwingUtilities.updateComponentTreeUI(graffTreeView);
        }
    }
    @Override
    public void addElement(GraffTreeItem element) {
        GraffTreeItem parentItem = getSelectedNode();

        if (!(parentItem.getGraffNode() instanceof Slide)) {
            ApplicationFramework.getInstance().getMg().generateError("Element se može dodati samo na Slide.");
            return;
        }

        DefaultTreeModel model = (DefaultTreeModel) treeModel;
        model.insertNodeInto(element, parentItem, parentItem.getChildCount());
        SwingUtilities.updateComponentTreeUI(graffTreeView);
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

    @Override //publisher
    public void addSubscriber(TBSubscriber subscriber) {
        tbSubscriberList.add(subscriber);
    }

    @Override //publisher
    public void removeSubscriber(TBSubscriber subscriber) {
        tbSubscriberList.remove(subscriber);
    }

    @Override //publisher
    public void sendToAll(String presentationName, String projectName) {
        for(TBSubscriber s : tbSubscriberList) {
            s.update(presentationName, projectName);
        }
    }
    public void setSelectedNode(SlideView slideView)
    {
        if (slideView == null || slideView.getSlideModel() == null) return;

        GraffTreeItem slideNode = findTreeNode((GraffTreeItem) treeModel.getRoot(), slideView.getSlideModel());

        if (slideNode != null) {
            TreePath path = new TreePath(slideNode.getPath());
            graffTreeView.setSelectionPath(path);
            graffTreeView.scrollPathToVisible(path);
        }
    }

    private GraffTreeItem findTreeNode(GraffTreeItem current, GraffNode target) {
        if (current.getGraffNode().equals(target)) {
            return current;
        }

        for (int i = 0; i < current.getChildCount(); i++) {
            GraffTreeItem child = (GraffTreeItem) current.getChildAt(i);
            GraffTreeItem result = findTreeNode(child, target);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public List<TBSubscriber> getTbSubscriberList() { //publisher
        return tbSubscriberList;
    }

    public GraffTreeView getGraffTreeView() {
        return graffTreeView;
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }

    @Override
    public void addSubscriber(PSubscriber subscriber) {
        pSubscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(PSubscriber subscriber) {
        pSubscribers.remove(subscriber);
    }

    @Override
    public void sendingToAll(Notification notification, GraffTreeItem node) {
        for(PSubscriber s : new ArrayList<>(pSubscribers)) {
            s.update(notification, node);
        }
    }
}

