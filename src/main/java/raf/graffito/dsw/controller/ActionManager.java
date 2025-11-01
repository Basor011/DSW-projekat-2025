package raf.graffito.dsw.controller;

public class ActionManager {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewChildAction newChildAction;
    private RemoveChildAction removeChildAction;

    public ActionManager() {
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
        newChildAction = new NewChildAction();
        removeChildAction = new RemoveChildAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }
    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public NewChildAction getNewChildAction() {
        return newChildAction;
    }

    public RemoveChildAction getRemoveChildAction() {
        return removeChildAction;
    }
}
