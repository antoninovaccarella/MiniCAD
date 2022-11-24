package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.CircleObject;
import mvc.model.GraphicObject;

public abstract class AbstractAreaCommand implements Command {

    protected GraphicObjectPanel panel;

    public AbstractAreaCommand(GraphicObjectPanel panel) {
        this.panel = panel;
    }

    protected double calculateArea(GraphicObject go) {
        if(go.getType().equals("Circle")) {
            CircleObject circle =  (CircleObject)go;
            return Math.PI *circle.getRadius()*circle.getRadius(); //pi*r^2

        }//circle
        if(go.getType().equals("Rectangle")) {
            return (go.getDimension().getWidth())*(go.getDimension().getHeight());
        }//Rectangle

        if(go.getType().equals("Image")) {
            System.out.println("Error: image does not have area.");

        }//Image
        return 0;
    }
}
