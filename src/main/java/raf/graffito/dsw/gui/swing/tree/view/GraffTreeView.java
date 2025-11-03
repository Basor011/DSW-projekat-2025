package raf.graffito.dsw.gui.swing.tree.view;

import raf.graffito.dsw.gui.swing.tree.controller.GraffTreeCellEditor;
import raf.graffito.dsw.gui.swing.tree.controller.GraffTreeMouseClickListener;
import raf.graffito.dsw.gui.swing.tree.controller.GraffTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;


public class GraffTreeView extends JTree {
    private GraffTreeCellEditor graffTreeCellEditor;
    public GraffTreeView(DefaultTreeModel newModel) {
        super(newModel); //setovali model


        GraffTreeCellRenderer renderer = new GraffTreeCellRenderer();
        addTreeSelectionListener(new GraffTreeSelectionListener());
        graffTreeCellEditor = new GraffTreeCellEditor(this, renderer);
        setCellEditor(graffTreeCellEditor);
        setCellRenderer(renderer);
        addMouseListener(new GraffTreeMouseClickListener());

        setEditable(true);


    }

    public GraffTreeCellEditor getGraffTreeCellEditor() {
        return graffTreeCellEditor;
    }
}
