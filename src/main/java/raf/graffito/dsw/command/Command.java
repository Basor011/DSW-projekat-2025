package raf.graffito.dsw.command;

public interface Command {
    void execute();
    void undo();
}
