package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObjectContainer;
import mvc.model.Memento;
import mvc.model.Originator;

import java.util.List;

public class RemoveCommand implements Command, Originator {

    private Integer objectID;
    private GraphicObjectPanel panel;

    public RemoveCommand(Integer objectID, GraphicObjectPanel panel) {
        this.objectID = objectID;
        this.panel = panel;
    }

    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
            List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
            for(Integer goObjID: groupObjectID) {
                panel.remove(goObjID);
            }
            goContainer.removeGroup(objectID);
        }
        else { //caso singolo oggetto
            panel.remove(objectID);
        }
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
