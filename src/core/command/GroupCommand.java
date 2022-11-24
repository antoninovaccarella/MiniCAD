package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObjectContainer;
import mvc.model.Memento;
import mvc.model.Originator;

import java.util.List;

public class GroupCommand implements Command, Originator {

    private List<Integer> listID;
    private GraphicObjectPanel panel;

    public GroupCommand(List<Integer> listID, GraphicObjectPanel panel) {
        this.listID = listID;
        this.panel = panel;
    }


    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        System.out.println(goContainer.addNewGroup(listID));
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
