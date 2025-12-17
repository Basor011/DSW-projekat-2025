package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;

import java.awt.event.ActionEvent;

public class SaveAsAction extends AbstractGraffAction {
    public SaveAsAction() {
        putValue(NAME, "Save as");
        putValue(SHORT_DESCRIPTION,"Save somewhere else");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
