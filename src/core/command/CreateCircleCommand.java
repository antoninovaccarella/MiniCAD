package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.CircleObject;
import mvc.model.GraphicObject;

import java.awt.geom.Point2D;

public class CreateCircleCommand extends AbstractCreateCommand {

    private Float radius;

    public CreateCircleCommand(GraphicObjectPanel panel, Float posX, Float posY, Float radius) {
        super(panel, posX, posY);
        this.radius = radius;
    }

    @Override
    public Boolean execute() {
        GraphicObject go = new CircleObject(new Point2D.Double(posX, posY), radius);
        System.out.println(panel.add(go));
        return true;
    }
    
}
