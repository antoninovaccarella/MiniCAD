package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;

import java.util.List;

public class AreaCommand extends AbstractAreaCommand {

    public AreaCommand(GraphicObjectPanel panel) {
        super(panel);
    }

    @Override
    public Boolean execute() {
        List<GraphicObject> objectList = panel.getGoContainer().getListGo();
        Double area = 0.0;
        for(GraphicObject go: objectList) {
            area += calculateArea(go);
        }
        System.out.println("Area of all objects: " + area);
        return true;
    }
}
