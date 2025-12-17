package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;

import java.awt.event.ActionEvent;

public class SaveAction extends AbstractGraffAction {
    public SaveAction() {
        putValue(NAME, "Save Project");
        putValue(SHORT_DESCRIPTION,"Save the current project");
    }

    @Override

    public void actionPerformed(ActionEvent e) {

    }
}
