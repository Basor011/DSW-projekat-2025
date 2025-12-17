    package raf.graffito.dsw.gui.swing.view;

    import raf.graffito.dsw.controller.state.StateManager;
    import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
    import javax.swing.*;
    import java.awt.*;
    import java.io.File;


    public class RightPane extends JPanel implements TBSubscriber {
        private JLabel projectNameLabel;
        private JLabel presentationNameLabel;

        private StateManager stateManager;
        private JButton buttonAddImage;
        private JButton buttonAddTextField;
        private JButton buttonAddLogo;
        private JButton buttonMoveElement;
        private JButton buttonSelectElement;
        private JButton buttonZoomElement;
        private JButton buttonRotateElement;
        private JButton buttonDeleteElement;
        private JButton buttonResizeElement;

        public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
            this.projectNameLabel = projectNameLabel;
            this.presentationNameLabel = presentationNameLabel;
            stateManager = MainFrame.getInstance().getStateManager();
            setLayout(new BorderLayout());

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
            topPanel.add(projectNameLabel);
            topPanel.add(presentationNameLabel);
            add(topPanel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            this.buttonAddImage = createIconButton(MainFrame.getInstance().getActionManager().getAddImageButton());
            this.buttonAddTextField = createIconButton(MainFrame.getInstance().getActionManager().getAddTextFieldButton());
            this.buttonAddLogo = createIconButton(MainFrame.getInstance().getActionManager().getAddLogoButton());
            this.buttonSelectElement = createIconButton(MainFrame.getInstance().getActionManager().getSelectElementAction());
            this.buttonMoveElement = createIconButton(MainFrame.getInstance().getActionManager().getMoveAction());
            this.buttonRotateElement=createIconButton(MainFrame.getInstance().getActionManager().getShowRotateButtonAction());
            this.buttonZoomElement=createIconButton(MainFrame.getInstance().getActionManager().getZoomElementAction());
            this.buttonDeleteElement = createIconButton(MainFrame.getInstance().getActionManager().getDeleteElementAction());
            this.buttonResizeElement = createIconButton(MainFrame.getInstance().getActionManager().getResizeElementAction());
            buttonPanel.add(buttonAddImage);
            buttonPanel.add(buttonAddTextField);
            buttonPanel.add(buttonAddLogo);
            buttonPanel.add(buttonSelectElement);
            buttonPanel.add(buttonMoveElement);
            buttonPanel.add(buttonRotateElement);
            buttonPanel.add(buttonZoomElement);
            buttonPanel.add(buttonDeleteElement);
            buttonPanel.add(buttonResizeElement);

            add(buttonPanel, BorderLayout.CENTER);
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

            button.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    button.setBackground(new Color(220, 220, 220)); // tamnije
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    if (!button.getModel().isPressed() && !button.getModel().isSelected()) button.setBackground(new Color(240, 240, 240));
                }
            });
            Icon icon = button.getIcon();
            if (icon != null) {
                button.setPreferredSize(new Dimension(icon.getIconWidth() + 10, icon.getIconHeight() + 10));
            }
            return button;
        }
        public void startSelectState() {stateManager.setSelectState();}
        public void startMoveState() {stateManager.setMoveState();}
        public void startAddImageState() {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choose an image");

            int result = chooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                stateManager.setAddImageState(selectedFile.getAbsolutePath());
            }
        }
        public void startAddLogoState() {stateManager.setAddLogoState();}
        public void startAddTextFieldState(){stateManager.setAddTextFieldState();}
        public void startDeleteElementState(){stateManager.setDeleteState();}
        public void startResizeElementState(){stateManager.setResizeElementState();}
        public void startRotateElementState(){stateManager.setRotationState();}
        public void startZoomElementState(){stateManager.setZoomState();}


        @Override
        public void update(String presentationName, String projectName) {
           if(presentationName == null) this.projectNameLabel.setText(projectName);
           else if(projectName == null) this.presentationNameLabel.setText(presentationName);
           else{
                this.projectNameLabel.setText(projectName);
                this.presentationNameLabel.setText(presentationName);
           }
        }

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
