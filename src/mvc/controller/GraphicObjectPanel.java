package mvc.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import mvc.model.GraphicEvent;
import mvc.model.GraphicObject;
import mvc.model.GraphicObjectContainer;
import mvc.model.GraphicObjectListener;
import mvc.view.GraphicObjectView;

public class GraphicObjectPanel extends JComponent implements GraphicObjectListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993548105090978185L;

	/**
	 * @directed true
	 */

	private GraphicObjectContainer goContainer = new GraphicObjectContainer();
	private Map<Class<? extends GraphicObject>, GraphicObjectView> viewMap = new HashMap<>();


	public GraphicObjectPanel() {
		setBackground(Color.WHITE);
	}

	public GraphicObjectContainer getGoContainer() {
		return goContainer;
	}


	public void setGoContainer(GraphicObjectContainer goContainer) {
		this.goContainer = goContainer;
		repaint();
	}

	@Override
	public void graphicChanged(GraphicEvent e) {
		repaint();
		revalidate();

	}

	
	public GraphicObject getGraphicObjectAt(Point2D p) {
		for (GraphicObject g : goContainer.getListGo()) {
			if (g.contains(p))
				return g;
		}
		return null;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension ps = super.getPreferredSize();
		double x = ps.getWidth();
		double y = ps.getHeight();
		for (GraphicObject go : goContainer.getListGo()) {
			double nx = go.getPosition().getX() + go.getDimension().getWidth() / 2;
			double ny = go.getPosition().getY() + go.getDimension().getHeight() / 2;
			if (nx > x)
				x = nx;
			if (ny > y)
				y = ny;
		}
		return new Dimension((int) x, (int) y);
	}


	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		for (GraphicObject go : goContainer.getListGo()) {
			GraphicObjectView view = viewMap.get(go.getClass());
			view.drawGraphicObject(go, g2);
		}

	}

	public Integer add(GraphicObject go) {
		Integer id = goContainer.add(go);
		go.addGraphicObjectListener(this);
		repaint();
		return id;
	}

	public void remove(Integer objectID) {
		GraphicObject go = goContainer.getObject(objectID);
		repaint();
		go.removeGraphicObjectListener(this);
		goContainer.remove(objectID);
	}

	public void installView(Class<? extends GraphicObject> clazz, GraphicObjectView view) {
		viewMap.put(clazz, view);
	}
}
