package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;

import java.util.List;

public class PerimeterTypeCommand extends AbstractPerimeterCommand {

    private String objectType;

    public PerimeterTypeCommand(String objectType, GraphicObjectPanel panel) {
        super(panel);
        this.objectType = objectType;
    }



    @Override
    public Boolean execute() {
        List<GraphicObject> objectList = panel.getGoContainer().getListGo();
        Double perimetro = 0.0;
        for(int i=0; i<objectList.size();i++) {
            if(objectType.equals(objectList.get(i).getType())) {
                perimetro += calculatePerimetro(objectList.get(i));
            }
        }

        System.out.println("Perimetro of object: " + objectType + "is: " + perimetro);
        return true;
    }

}
