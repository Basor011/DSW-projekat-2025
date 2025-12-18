package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.serializer.Jackson;
import raf.graffito.dsw.model.serializer.Serializer;

import javax.swing.*;
import java.awt.*;

public class UploadSaveView extends JFrame {
private JButton saveButton;
private JButton saveAsButton;
private JButton loadButton;

private JButton saveAsTemplateButton;
private JButton loadTemplateButton;
private JPanel buttonPanel;
private JPanel templatesPanel;
private Serializer serializer;
private JPanel centerWrapper;

    public UploadSaveView()
    {
        initUI();
    }
    private void initUI()
    {
        serializer=new Jackson();
        setLayout(new BorderLayout());
        setTitle("Upload or save");
        setSize(400,300);

        saveButton=new JButton("Save Project");saveButton.setAction(MainFrame.getInstance().getActionManager().getSaveAction());
        saveAsButton= new JButton("Save as");saveAsButton.setAction(MainFrame.getInstance().getActionManager().getSaveAsAction());
        loadButton= new JButton("Load Project");loadButton.setAction(MainFrame.getInstance().getActionManager().getLoadAction());
        saveAsTemplateButton=new JButton();saveAsTemplateButton.setAction(MainFrame.getInstance().getActionManager().getSaveAction());saveAsTemplateButton.setActionCommand("template");saveAsTemplateButton.setText("Save as template");
        loadTemplateButton= new JButton();loadButton.setAction(MainFrame.getInstance().getActionManager().getLoadAction());loadTemplateButton.setActionCommand("template");loadTemplateButton.setText("Load a template");


        buttonPanel= new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAsButton);
        buttonPanel.add(loadButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        templatesPanel=new JPanel();
        templatesPanel.add(saveAsTemplateButton);
        templatesPanel.add(loadTemplateButton);


        centerWrapper = new JPanel();
        centerWrapper.setLayout(new BoxLayout(centerWrapper, BoxLayout.Y_AXIS));
        centerWrapper.add(Box.createVerticalGlue());
        centerWrapper.add(buttonPanel);
        centerWrapper.add(Box.createVerticalGlue());


        add(centerWrapper, BorderLayout.CENTER);
        add(templatesPanel,BorderLayout.SOUTH);

    }
}
