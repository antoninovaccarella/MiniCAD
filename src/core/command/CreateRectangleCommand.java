package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;
import mvc.model.RectangleObject;

import java.awt.geom.Point2D;

public class CreateRectangleCommand extends AbstractCreateCommand {

    private Float weight, height;

    public CreateRectangleCommand(GraphicObjectPanel panel, Float posX, Float posY, Float weight, Float height) {
        super(panel, posX, posY);
        this.weight = weight;
        this.height = height;
    }


    @Override
    public Boolean execute() {
        GraphicObject go = new RectangleObject(new Point2D.Double(posX, posY), weight, height);
        System.out.println(panel.add(go));
        return true;
    }
}
