package raf.graffito.dsw.model.command;

public interface Command {
    void execute();
    void undo();
}
