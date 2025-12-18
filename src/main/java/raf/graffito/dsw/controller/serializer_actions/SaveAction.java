package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.model.serializer.Jackson;
import raf.graffito.dsw.model.serializer.Serializer;

import java.awt.event.ActionEvent;

public class SaveAction extends AbstractGraffAction {
    private Serializer serializer;
    public SaveAction() {
        serializer=new Jackson();
        putValue(NAME, "Save Project");
        putValue(SHORT_DESCRIPTION,"Save the current project");
    }

    @Override

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("template"))
        {

        }
        else {

        }
    }

    private void saveProject()
    {

    }
}
