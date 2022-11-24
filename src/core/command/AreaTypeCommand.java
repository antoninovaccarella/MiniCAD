package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;

import java.util.List;

public class AreaTypeCommand extends AbstractAreaCommand {

    private String objectType;

    public AreaTypeCommand(String objectType, GraphicObjectPanel panel) {
        super(panel);
        this.objectType = objectType;
    }


    @Override
    public Boolean execute() {
        List<GraphicObject> objectList = panel.getGoContainer().getListGo();
        Double area = 0.0;
        for(int i=0; i<objectList.size();i++) {
            if(objectType.equals(objectList.get(i).getType())) {
                area += calculateArea(objectList.get(i));
            }
        }

        System.out.println("Area of object: " + objectType + "is: " + area);
        return true;
    }
}
