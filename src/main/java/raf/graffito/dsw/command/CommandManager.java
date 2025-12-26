package raf.graffito.dsw.command;

import raf.graffito.dsw.core.ApplicationFramework;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> history = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
            redoStack.push(command);
        } else ApplicationFramework.getInstance().getMg().generateError("Nema vise undo");
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            history.push(command);
        } else ApplicationFramework.getInstance().getMg().generateError("Nema vise redo");
    }
}
