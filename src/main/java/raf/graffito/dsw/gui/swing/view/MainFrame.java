package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.controller.ActionManager;
import raf.graffito.dsw.controller.state.StateManager;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.tree.GraffTree;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;

public class MainFrame extends JFrame implements Subscriber {

    // Buduća polja za sve komponente view-a na glavnom prozoru
    private ActionManager actionManager;
    private static MainFrame instance = null;
    private GraffTree graffTree;
    private MyTabbedPane tabbedPane;
    private JSplitPane split;
    private JSplitPane split2;

    private RightPane rightPanel;
    private StateManager stateManager;

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }
    private MainFrame() {
        actionManager = new ActionManager();
        stateManager = new StateManager();
        graffTree = new GraffTreeImplementation();
        instance = this;
        initialize();
    }
    private void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit(); // Toolkit omogućava interakciju sa platformom
        Dimension screenSize = kit.getScreenSize(); // Veličina ekrana
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null); // Centriranje prozora na ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zatvaranje aplikacije pri zatvaranju prozora
        setTitle("Graffito"); // Naslov prozora

        MyMenuBar menu = new MyMenuBar(this); // Kreiranje menija
        setJMenuBar(menu); // Postavljanje menija na prozor

        MyToolBar toolBar = new MyToolBar(this); // Kreiranje toolbar-a
        add(toolBar, BorderLayout.NORTH); // Postavljanje toolbar-a na vrh prozora

        JTree workspace = graffTree.generateTree(ApplicationFramework.getInstance().getGr().getWorkspace());

        rightPanel = new RightPane(new JLabel("Kalina"),new JLabel("Jug"));
        ((GraffTreeImplementation)graffTree).addSubscriber(rightPanel);
        JScrollPane scrollPane = new JScrollPane(workspace);
        scrollPane.setMinimumSize(new Dimension(200,150));
        split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,null);
        split2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,split,rightPanel);
        split.setDividerLocation(screenWidth/5);
        split2.setDividerLocation(screenWidth - 200);
        split.setOneTouchExpandable(true);
        tabbedPane = new MyTabbedPane();
        ((GraffTreeImplementation)graffTree).addSubscriber(tabbedPane);

        split.setRightComponent(tabbedPane);

        getContentPane().add(split2,BorderLayout.CENTER);
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public MyTabbedPane getTabbedPane(){
        return tabbedPane;
    }
    public RightPane getRightPanel() {
        return rightPanel;
    }
    public StateManager getStateManager() {
        return stateManager;
    }

    @Override
    public void ispisiPoruku(Message message) {
        if (message.getType().equals("GRESKA") || message.getType().equals("OBAVESTENJE")){
            JOptionPane.showMessageDialog(null, message.toString() + " " + message.getType());
        }
        else return;
    }

    public GraffTree getGraffTree() {
        return graffTree;
    }
}
