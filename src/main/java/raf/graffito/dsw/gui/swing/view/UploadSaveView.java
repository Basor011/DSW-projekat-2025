package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.serializer.Jackson;
import raf.graffito.dsw.model.serializer.Serializer;

import javax.swing.*;
import java.awt.*;

public class UploadSaveView extends JFrame {
private JButton saveButton;
private JButton saveAsButton;
private JButton loadButton;
private JPanel buttonPanel;
private Serializer serializer;

    public UploadSaveView(JFrame parent)
    {
        initUI();
    }
    private void initUI()
    {
        serializer=new Jackson();
        setLayout(new BorderLayout());
        setTitle("Upload or save");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,100);

        saveButton=new JButton("Save Project");saveButton.setAction(MainFrame.getInstance().getActionManager().getSaveAction());
        saveAsButton= new JButton("Save as");saveAsButton.setAction(MainFrame.getInstance().getActionManager().getSaveAsAction());
        loadButton= new JButton("Load Project");loadButton.setAction(MainFrame.getInstance().getActionManager().getLoadAction());


        buttonPanel= new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAsButton);
        buttonPanel.add(loadButton);






        add(buttonPanel,BorderLayout.CENTER);

    }
}
