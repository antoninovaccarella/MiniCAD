package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObjectContainer;
import mvc.model.Memento;
import mvc.model.Originator;

import java.util.List;

public class ScaleCommand implements Command, Originator {

    private Integer objectID;
    private Float scale;
    private GraphicObjectPanel panel;

    public ScaleCommand(Integer objectID, Float scale, GraphicObjectPanel panel) {
        this.objectID = objectID;
        this.scale = scale;
        this.panel = panel;
    }


    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
            List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
            for(Integer goObjID: groupObjectID) {
                goContainer.getObject(goObjID).scale(scale);
            }
        }
        else { //caso singolo oggetto
            goContainer.getObject(objectID).scale(scale);
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
