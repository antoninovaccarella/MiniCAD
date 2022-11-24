package mvc.view;

import mvc.model.GraphicObject;

import java.awt.*;

public interface GraphicObjectView {
	void drawGraphicObject(GraphicObject go, Graphics2D g);
}
