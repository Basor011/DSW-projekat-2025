package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.state.StateManager;
import raf.graffito.dsw.gui.swing.controller.RightPaneButtonMouseListener;
import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
import javax.swing.*;
import java.awt.*;


public class RightPane extends JPanel implements TBSubscriber {
    private JLabel projectNameLabel;
    private JLabel presentationNameLabel;

    private StateManager stateManager;

    private ImageListView imageListView;

    public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
        this.projectNameLabel = projectNameLabel;
        this.presentationNameLabel = presentationNameLabel;
        stateManager = MainFrame.getInstance().getStateManager();
        setLayout(new BorderLayout());

        //top
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(projectNameLabel);
        topPanel.add(presentationNameLabel);
        add(topPanel, BorderLayout.NORTH);

        //buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 2));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getInsertImagesAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getAddTextFieldButton()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getAddLogoButton()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getSelectElementAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getMoveAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getShowRotateButtonAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getZoomElementAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getDeleteElementAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getResizeElementAction()));
        buttonPanel.add(createIconButton(MainFrame.getInstance().getActionManager().getCopyElementAction()));
        add(buttonPanel, BorderLayout.CENTER);

        //bottom
        this.imageListView = new ImageListView(stateManager);
        add(imageListView, BorderLayout.SOUTH);
    }
    private JButton createIconButton(Action action) {
        JButton button = new JButton(action);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBackground(new Color(240, 240, 240));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        button.addMouseListener(new RightPaneButtonMouseListener(button));
        Icon icon = button.getIcon();
        if (icon != null) button.setPreferredSize(new Dimension(icon.getIconWidth() + 10, icon.getIconHeight() + 10));
        return button;
    }
    public void startSelectState() {stateManager.setSelectState();}
    public void startMoveState() {stateManager.setMoveState();}
    public void startAddLogoState() {stateManager.setAddLogoState();}
    public void startAddTextFieldState(){stateManager.setAddTextFieldState();}
    public void startDeleteElementState(){stateManager.setDeleteState();}
    public void startResizeElementState(){stateManager.setResizeElementState();}
    public void startZoomElementState(){stateManager.setZoomState();}
    public void startCopyElementState(){stateManager.setCopyElementState();}

    @Override
    public void update(String presentationName, String projectName) {
       if(presentationName == null) this.projectNameLabel.setText(projectName);
       else if(projectName == null) this.presentationNameLabel.setText(presentationName);
       else{
            this.projectNameLabel.setText(projectName);
            this.presentationNameLabel.setText(presentationName);
       }
    }

    public ImageListView getImageListView() {return imageListView;}

    public JLabel getProjectNameLabel() {
        return projectNameLabel;
    }
    public void setProjectNameLabel(JLabel projectNameLabel) {
        this.projectNameLabel = projectNameLabel;
    }
    public JLabel getPresentationNameLabel() {
        return presentationNameLabel;
    }
    public void setPresentationNameLabel(JLabel presentationNameLabel) {this.presentationNameLabel = presentationNameLabel;}
}
