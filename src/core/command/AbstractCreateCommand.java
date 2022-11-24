package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObjectContainer;
import mvc.model.Memento;
import mvc.model.Originator;

public abstract class AbstractCreateCommand implements Command, Originator {
    protected GraphicObjectPanel panel;
    protected Float posX, posY;

    public AbstractCreateCommand(GraphicObjectPanel panel, Float posX, Float posY) {
        this.panel = panel;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public Memento saveState() {
        return new GraphicObjectContainer(panel.getGoContainer().getGroupsMap(),panel.getGoContainer().getObjectMap());
    }

    @Override
    public void undo(Memento memento) {
        panel.setGoContainer((GraphicObjectContainer) memento);
    }
}
