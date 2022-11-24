package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.CircleObject;
import mvc.model.GraphicObject;

public abstract class AbstractPerimeterCommand implements Command {

    protected GraphicObjectPanel panel;

    public AbstractPerimeterCommand(GraphicObjectPanel panel) {
        this.panel = panel;
    }

    protected double calculatePerimetro(GraphicObject go) {
        if(go.getType().equals("Circle")) {
            CircleObject circle =  (CircleObject)go;
            return 2* Math.PI *circle.getRadius(); //2*pi*r

        }//circle
        if(go.getType().equals("Rectangle")) {
            return (go.getDimension().getWidth()* 2 ) + (go.getDimension().getHeight()*2);
        }//Rectangle

        if(go.getType().equals("Image")) {
            System.out.println("Error: image does not have area.");

        }//Image
        return 0;
    }

}
