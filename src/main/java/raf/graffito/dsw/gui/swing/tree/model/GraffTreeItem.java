package raf.graffito.dsw.gui.swing.tree.model;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;

import javax.swing.tree.DefaultMutableTreeNode;

public class GraffTreeItem extends DefaultMutableTreeNode {
    private GraffNode graffNode;

    public GraffTreeItem(GraffNode nodeModel) {
        this.graffNode = nodeModel;
    }

    @Override
    public String toString() {
        return graffNode.getName();
    }

    public void setName(String name) {
        this.graffNode.setName(name);
    }

    public GraffNode getGraffNode() {
        return graffNode;
    }
    public boolean hasSameSiblings(GraffTreeItem item, DefaultMutableTreeNode parent, String newName)
    {
        if (parent != null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                DefaultMutableTreeNode sibling = (DefaultMutableTreeNode) parent.getChildAt(i);
                if (sibling == item) continue;
                if (sibling.toString().equalsIgnoreCase(newName)) {
                    ApplicationFramework.getInstance().getMg().generateError("Ne mogu biti dva istoimena cvora");
                    return false;
                }
            }
        }
        return true;
    }
    public void SortRenamedNodes(int[] indices, GraffTreeItem parent)
    {
        if (indices != null && indices.length > 0)
        {
            for (int index : indices) {
                GraffTreeItem child = (GraffTreeItem) parent.getChildAt(index);
                if(child.getGraffNode() instanceof Project)
                {
                    ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PROJECT_RENAMED,child);
                }
                else if(child.getGraffNode() instanceof Presentation)   /// PRESENTATION RENAMED
                {
                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_RENAMED,child);
                }
            }
        }
        else ///  WORKSPACE
        {
            ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendToAll("", "");
        }
    }
    public void sortInsertedNodes(int[] indices, GraffTreeItem parent)
    {
        if (indices != null && indices.length > 0)
        {
            for (int index : indices) {
                GraffTreeItem child = (GraffTreeItem) parent.getChildAt(index);
                if(child.getGraffNode() instanceof Presentation) ///  PRESENTATION INSERTED
                {
                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_INSERTED,child);
                }
            }
        }
    }

}
