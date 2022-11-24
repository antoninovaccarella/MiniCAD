package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;
import mvc.model.GraphicObjectContainer;
import mvc.model.Memento;
import mvc.model.Originator;

import java.util.List;

public class MoveCommand implements Command, Originator {

    private Integer objectID;
    private Float posX; private Float posY;
    private boolean moveOff;
    private GraphicObjectPanel panel;

    public MoveCommand(Integer objectID, Float posX, Float posY, boolean moveOff, GraphicObjectPanel panel) {
        this.objectID = objectID;
        this.posX = posX;
        this.posY = posY;
        this.moveOff = moveOff;
        this.panel = panel;
    }


    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        if(!moveOff) { //caso MOVE
            if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
                List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
                for(Integer objID: groupObjectID) {
                    goContainer.getObject(objID).moveTo(posX, posY);
                }//for
            }//secondo if
            else {
                goContainer.getObject(objectID).moveTo(posX, posY);
            }
        }//primo if
        else { //caso MoveOff
            if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
                List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
                for(Integer objID: groupObjectID) {
                    GraphicObject go = goContainer.getObject(objID);
                    Double newPosX = go.getPosition().getX() + posX;
                    Double newPosY = go.getPosition().getY() + posY;
                    go.moveTo(newPosX, newPosY);
                }//for
            }//secondo if
            else {
                GraphicObject go = goContainer.getObject(objectID);
                Double newPosX = go.getPosition().getX() + posX;
                Double newPosY = go.getPosition().getY() + posY;
                go.moveTo(newPosX, newPosY);
            }
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
