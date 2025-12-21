package raf.graffito.dsw.controller.commands;

public interface Command {
    void execute();
    void undo();
}
