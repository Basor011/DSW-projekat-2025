package raf.graffito.dsw.gui.swing.tree.view;

import raf.graffito.dsw.core.composite.compositions.Presentation;
import raf.graffito.dsw.core.composite.compositions.Project;
import raf.graffito.dsw.core.composite.compositions.Workspace;
import raf.graffito.dsw.core.composite.leaves.Slide;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class GraffTreeCellRenderer extends DefaultTreeCellRenderer{

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel,
            boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        URL img_URL = null;
        Icon icon = null;
        if(((GraffTreeItem)value).getGraffNode() instanceof Workspace){
            img_URL = getClass().getResource("/images/workspace.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof Project){
            img_URL = getClass().getResource("/images/project.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof Presentation){
            img_URL = getClass().getResource("/images/presentation.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof Slide){
            img_URL = getClass().getResource("/images/slide.png");
        }
        if(img_URL != null){
            icon = new ImageIcon(img_URL);
        }
        setIcon(icon);
        return this;
    }
}
