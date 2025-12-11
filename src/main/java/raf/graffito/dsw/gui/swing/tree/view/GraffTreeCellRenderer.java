package raf.graffito.dsw.gui.swing.tree.view;

import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Workspace;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.model.composite.leaves.ImageElement;
import raf.graffito.dsw.model.composite.leaves.LogoElement;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

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
            img_URL = getClass().getResource("/images/icons for JTree/workspace.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof Project){
            img_URL = getClass().getResource("/images/icons for JTree/project.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof Presentation){
            img_URL = getClass().getResource("/images/icons for JTree/presentation.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof Slide) {
            img_URL = getClass().getResource("/images/icons for JTree/slide.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof LogoElement){
            img_URL = getClass().getResource("/images/bananaleclerc.jpg");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof ImageElement){
            img_URL = getClass().getResource("images/icons for JTree/imageelement.png");
        }else if(((GraffTreeItem)value).getGraffNode() instanceof TextFieldElement){
            img_URL = getClass().getResource("images/icons for JTree/textfieldelement.png");
        }
        if(img_URL != null){
            icon = new ImageIcon(img_URL);
        }
        setIcon(icon);
        return this;
    }
}
