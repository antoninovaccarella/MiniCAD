package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;
import mvc.model.GraphicObjectContainer;

import java.util.List;

public class ListObjectCommand extends AbstractListCommand {

    private Integer objectID;

    public ListObjectCommand(Integer objectID, GraphicObjectPanel panel) {
        super(panel);
        this.objectID = objectID;
    }

    @Override
    public Boolean execute() {
        GraphicObjectContainer goContainer = panel.getGoContainer();
        if(goContainer.groupExists(objectID)) { //caso gruppo di oggetti
            List<Integer> groupObjectID = goContainer.getGroupElements(objectID);
            StringBuilder sb = new StringBuilder();
            sb.append("Objects of group ");
            sb.append(objectID);
            sb.append(" {");
            for(Integer grpObjID: groupObjectID) {
                sb.append(grpObjID);
                sb.append(", ");
            }
            sb.append("}");
            System.out.println(sb.toString());
        }
        else { //caso singolo oggetto
            StringBuilder sb = new StringBuilder();
            sb.append("Object ");
            sb.append(objectID);
            sb.append(": ");
            GraphicObject go = goContainer.getObject(objectID);
            sb.append(go.getType());
            sb.append(go.getPosition());
            sb.append(go.getDimension());
            System.out.println(sb.toString());
        }


        return true;
    }

}
