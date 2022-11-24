package core.command;

import mvc.controller.GraphicObjectPanel;

public abstract class AbstractListCommand implements Command {
    protected GraphicObjectPanel panel;

    public AbstractListCommand(GraphicObjectPanel panel) {
        this.panel = panel;
    }
}
