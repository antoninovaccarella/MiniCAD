package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;
import mvc.model.GraphicObjectContainer;

import java.util.List;

public class AreaObjectCommand extends AbstractAreaCommand {

    private Integer objectID;

    public AreaObjectCommand(Integer objectID, GraphicObjectPanel panel) {
        super(panel);
        this.objectID = objectID;
    }

    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
            List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
            Double area = 0.0;
            for(Integer grpObjID: groupObjectID) {
                area += calculateArea(goContainer.getObject(grpObjID));
            }
            System.out.println("Area of the group "+ objectID + "member is: "+ area);
        }
        else { //caso singolo oggetto
            GraphicObject go = goContainer.getObject(objectID);
            System.out.println("Area of "+ objectID+ "is: "+ calculateArea(go));
        }
        return true;
    }

}
