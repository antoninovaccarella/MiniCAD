package core.command;

import mvc.controller.GraphicObjectPanel;
import mvc.model.GraphicObject;
import mvc.model.ImageObject;

import javax.swing.*;
import java.awt.geom.Point2D;

public class CreateImgCommand extends AbstractCreateCommand {

    private String path;

    public CreateImgCommand(GraphicObjectPanel panel, Float posX, Float posY, String path) {
        super(panel, posX, posY);
        this.path = path;
    }

    @Override
    public Boolean execute() {
        GraphicObject go = new ImageObject(new ImageIcon(path), new Point2D.Double(posX, posY));
        System.out.println(panel.add(go));
        return true;
    }
}
