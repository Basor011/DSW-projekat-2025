package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.brigde.DefaultScaler;
import raf.graffito.dsw.controller.ActionManager;
import raf.graffito.dsw.model.state.StateManager;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.tree.GraffTree;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class MainFrame extends JFrame implements Subscriber {

    // Buduća polja za sve komponente view-a na glavnom prozoru
    private ActionManager actionManager;
    private static MainFrame instance = null;
    private GraffTree graffTree;
    private MyTabbedPane tabbedPane;
    private JSplitPane split;
    private JSplitPane split2;
    private File defaultFilePath;
    private File templatePath;
    private Label uputstvo;

    private RightPane rightPanel;
    private StateManager stateManager;
    private int screenHeight;
    private int screenWidth;

    private double globalScale = 1.0;

    private Dimension normalSize;

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

        instance=this;

        initialize();
    }
    private void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit(); // Toolkit omogućava interakciju sa platformom
        Dimension screenSize = kit.getScreenSize(); // Veličina ekrana
        screenHeight = (int) (screenSize.height / 1.3);
        screenWidth = (int) (screenSize.width / 1.3);
        normalSize = new Dimension(screenWidth, screenHeight);
        setSize(normalSize);

        setLocationRelativeTo(null); // Centriranje prozora na ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zatvaranje aplikacije pri zatvaranju prozora
        setTitle("Graffito"); // Naslov prozora

        MyMenuBar menu = new MyMenuBar(this); // Kreiranje menija
        setJMenuBar(menu); // Postavljanje menija na prozor

        JPanel rootPanel = new JPanel(new BorderLayout());
        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setLayout(new BoxLayout(toolbarPanel, BoxLayout.X_AXIS));
        WindowModeRadioButtons modeRadioButtons = new WindowModeRadioButtons(ApplicationFramework.getInstance().getWindowModeController(), new DefaultScaler(this));
        uputstvo=new Label("Triple DESNI klik za otvaranje projekta");

        MyToolBar toolBar = new MyToolBar(this); // Kreiranje toolbar-a

        toolbarPanel.add(toolBar);
        toolbarPanel.add(modeRadioButtons);
        toolbarPanel.add(uputstvo);
        rootPanel.add(toolbarPanel, BorderLayout.NORTH);

        defaultFilePath = null;
        templatePath = new File("src/main/resources/templates");

        JTree workspace = graffTree.generateTree(ApplicationFramework.getInstance().getGr().getWorkspace());

        rightPanel = new RightPane(new JLabel("Kalina"),new JLabel("Jug"));
        ((GraffTreeImplementation)graffTree).addSubscriber(rightPanel);

        JScrollPane scrollPane = new JScrollPane(workspace);
        scrollPane.setMinimumSize(new Dimension(200,150));
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,null);
        split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,split,rightPanel);
        split.setDividerLocation(screenWidth/6);

        split2.setDividerLocation(screenWidth- (screenWidth/6));
        split.setOneTouchExpandable(true);

        tabbedPane = new MyTabbedPane();
        ((GraffTreeImplementation)graffTree).addSubscriber(tabbedPane);

        split.setRightComponent(tabbedPane);

        rootPanel.add(split2, BorderLayout.CENTER);
        setContentPane(rootPanel);
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
    public File getDefaultFilePath() {
        return defaultFilePath;
    }
    public void setDefaultFilePath(File defaultFilePath) {
        this.defaultFilePath = defaultFilePath;
    }
    public File getTemplatePath() {
        return templatePath;
    }
    public GraffTree getGraffTree() {
        return graffTree;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public int getScreenWidth() {
        return screenWidth;
    }

    public double getGlobalScale() {return globalScale;}

    @Override
    public void ispisiPoruku(Message message) {
        if (message.getType().equals("GRESKA") || message.getType().equals("OBAVESTENJE")){
            JOptionPane.showMessageDialog(null, message.toString() + " " + message.getType());
        }
        else return;
    }

    public void setGlobalScale(double scale) {//skaliramo view
        this.globalScale = scale;

        List<PresentationView> pvl = getTabbedPane().getPresentationViewList();
        for(PresentationView pv : pvl){
            List<SlideView> svl = pv.getSlajdovi();
            for(SlideView sv : svl){
                sv.updateScale(scale);
            }
        }
        revalidate();
        repaint();
    }

    public Dimension getNormalSize() {return normalSize;}
}
