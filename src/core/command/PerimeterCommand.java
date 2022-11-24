package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;

import java.util.List;

public class PerimeterCommand extends AbstractPerimeterCommand {

    public PerimeterCommand(GraphicObjectPanel panel) {
        super(panel);
    }

    @Override
    public Boolean execute() {
        List<GraphicObject> objectList = panel.getGoContainer().getListGo();
        Double perimetro = 0.0;
        for(GraphicObject go: objectList) {
            perimetro += calculatePerimetro(go);
        }
        System.out.println("Perimetro of all objects: " + perimetro);
        return true;
    }
}
