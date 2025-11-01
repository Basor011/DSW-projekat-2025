package raf.graffito.dsw.gui.swing.tree;

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
import java.util.Random;

public class GraffTreeImplementation implements GraffTree{
    private GraffTreeView graffTreeView;
    private DefaultTreeModel treeModel;

    private GraffNode createChild(GraffNode parent) {
        if(parent instanceof Workspace) {
            /// popraviti autor. smisli nesto kako se upisuje ime autora,, eg. kada zeli
            /// novoi projekat, izadje pop up koji trazi da se upise ime autora u textBox
            /// iz tog textBoxa se kasnije vuce ime autora
            return new Project("Project" + new Random().nextInt(100), parent, "autor");
        }else if(parent instanceof Project) {
            /// ide pop up window koji pita da li ce presentation ili slide
            return new Presentation("Presentation" + new Random().nextInt(100), parent);
            //return new Slide("Project" + new Random().nextInt(100), parent);
        }else if(parent instanceof Presentation) {
            return new Slide("Slide" + new Random().nextInt(100), parent);
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
            root.add(new GraffTreeItem(child));
            ((GraffNodeComposite)root.getGraffNode()).addChild(child);
            graffTreeView.expandPath(graffTreeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(graffTreeView);
        }
    }

    @Override
    public GraffTreeItem getSelectedNode() {
        return (GraffTreeItem) graffTreeView.getLastSelectedPathComponent();
    }
}
