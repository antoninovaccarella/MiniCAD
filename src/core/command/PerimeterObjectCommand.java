package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;
import mvc.model.GraphicObjectContainer;

import java.util.List;

public class PerimeterObjectCommand extends PerimeterCommand {

    private Integer objectID;

    public PerimeterObjectCommand(Integer objectID, GraphicObjectPanel panel) {
        super(panel);
        this.objectID = objectID;
    }

    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
            List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
            Double perimetro = 0.0;
            for(Integer grpObjID: groupObjectID) {
                perimetro *= calculatePerimetro(goContainer.getObject(grpObjID));
            }
            System.out.println("Perimetro of the group "+ objectID + "member is: "+ perimetro);
        }
        else { //caso singolo oggetto
            GraphicObject go = goContainer.getObject(objectID);
            System.out.println("Perimetro of "+ objectID+ "is: "+ calculatePerimetro(go));
        }
        return true;
    }




}
