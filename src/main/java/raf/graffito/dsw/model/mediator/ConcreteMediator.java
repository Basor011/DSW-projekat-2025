package raf.graffito.dsw.model.mediator;


import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.brigde.DefaultScaler;
import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;
import raf.graffito.dsw.model.brigde.concrete.FullMode;
import raf.graffito.dsw.model.brigde.concrete.NormalMode;
import raf.graffito.dsw.model.brigde.concrete.SmallMode;
import raf.graffito.dsw.model.brigde.controller.WindowModeController;

public class ConcreteMediator implements iMediator{

private WindowModeController controller;

    public ConcreteMediator(WindowModeController controller) {
        this.controller = controller;
    }

    @Override
    public void notify(String event) {
        ScaleImplement scaler=new DefaultScaler(MainFrame.getInstance());
        WindowMode mode=new NormalMode(scaler);

        switch(event){
            case "NORMAL"->mode=new NormalMode(scaler);
            case "FULL"-> mode=new FullMode(scaler);
            case "SMALL"-> mode= new SmallMode(scaler);
        }
        controller.setMode(mode);

    }
}
