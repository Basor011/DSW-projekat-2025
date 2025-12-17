package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;

import java.awt.event.ActionEvent;

public class LoadAction extends AbstractGraffAction {
    public LoadAction() {
        putValue(NAME, "Load Project");
        putValue(SHORT_DESCRIPTION,"Load a project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
