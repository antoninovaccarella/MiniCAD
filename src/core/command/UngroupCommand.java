package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObjectContainer;
import mvc.model.Memento;
import mvc.model.Originator;

public class UngroupCommand implements Command, Originator {

    private Integer groupID;
    private GraphicObjectPanel panel;

    public UngroupCommand(Integer groupID, GraphicObjectPanel panel) {
        this.groupID = groupID;
        this.panel = panel;
    }

    @Override
    public Boolean execute() {
        panel.getGoContainer().removeGroup(groupID);
        return true;
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
