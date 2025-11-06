package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class GraffTreeCellEditor  extends DefaultTreeCellEditor implements ActionListener {
    private JTextField textField = null;
    private Object clicked = null;

    public GraffTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        clicked = value;
        textField = new JTextField(value.toString());
        textField.addActionListener(this);
        return textField;
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if(event instanceof MouseEvent){

            if(((MouseEvent)event).getClickCount() == 3){
                return true;
            }
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(clicked instanceof GraffTreeItem){
            GraffTreeItem item = (GraffTreeItem)clicked;
            String newName = e.getActionCommand().trim();
            if(newName.isEmpty()) return;

            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) item.getParent();
            if (parent != null)
            {
                for (int i = 0; i < parent.getChildCount(); i++)
                {
                    DefaultMutableTreeNode sibling = (DefaultMutableTreeNode) parent.getChildAt(i);
                    if (sibling == item) continue;
                    if (sibling.toString().equalsIgnoreCase(newName)) {
                        ApplicationFramework.getInstance().getMg().generateError("Ne mogu biti dva istoimena cvora");
                        return;
                    }
                }
            }

            item.setName(newName);

            DefaultTreeModel model=(DefaultTreeModel) tree.getModel();
            model.nodeChanged(item);
        }
    }



    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public Object getClicked() {
        return clicked;
    }

    public void setClicked(Object clicked) {
        this.clicked = clicked;
    }
}
