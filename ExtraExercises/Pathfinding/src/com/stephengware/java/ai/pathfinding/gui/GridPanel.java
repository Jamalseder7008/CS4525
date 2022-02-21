package com.stephengware.java.ai.pathfinding.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.stephengware.java.ai.pathfinding.*;

/**
 * Visualizes a path search process.
 * 
 * @author Stephen G. Ware
 */
public class GridPanel extends JPanel {

	private static final int TILE_WIDTH = 75;
	private static final int TILE_HEIGHT = 75;
	private static final Color DEFAULT_FILL = new Color(250, 250, 250);
	private static final Color DEFAULT_LINE = new Color(220, 220, 220);
	private static final Color SOLID_FILL = new Color(10, 10, 10);
	private static final Color SOLID_LINE = new Color(0, 0, 0);
	private static final Color VISITED_FILL = new Color(51, 255, 51);
	private static final Color VISITED_LINE = new Color(0, 204, 0);
	private static final Color FRONTIER_FILL = new Color(255, 51, 51);
	private static final Color FRONTIER_LINE = new Color(204, 0, 0);
	private static final Color PATH_COLOR = Color.YELLOW;
	private static final long serialVersionUID = 1L;

	/** The map being visualized */
	public final Map map;
	private final Set<Location> visited;
	private final PriorityQueue<Path> frontier;
	private BufferedImage robot = null;
	private BufferedImage flag = null;
	private Path path;
	
	/**
	 * Constructs a new visualization of a path search.
	 * 
	 * @param map the map to visualize
	 * @param visited the set of locations to be shown as visited
	 * @param frontier the set of locations to be shown as on the frontier
	 */
	public GridPanel(Map map, Set<Location> visited, PriorityQueue<Path> frontier) {
		this.map = map;
		this.visited = visited;
		this.frontier = frontier;
		setPreferredSize(new Dimension(map.width * TILE_WIDTH, map.height * TILE_HEIGHT));
		try {
			robot = ImageIO.read(getClass().getResourceAsStream("/com/stephengware/java/ai/pathfinding/gui/robot.png"));
			flag = ImageIO.read(getClass().getResourceAsStream("/com/stephengware/java/ai/pathfinding/gui/flag.png"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void repaint() {
		super.repaint();
		try{ Thread.sleep(200); }
		catch(InterruptedException ex){};
	}
	
	/**
	 * Draws the current state of the path search process, showing the given
	 * path.
	 * 
	 * @param path the path to draw
	 */
	public void draw(Path path) {
		this.path = path;
		repaint();
	}
	
	/**
	 * Returns the current path being displayed.
	 * 
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		map.forEach(location -> {
			Color fill = DEFAULT_FILL;
			Color line = DEFAULT_LINE;
			if(visited.contains(location)) {
				fill = VISITED_FILL;
				line = VISITED_LINE;
			}
			else if(frontier.contains(location) || (path != null && path.contains(location))) {
				fill = FRONTIER_FILL;
				line = FRONTIER_LINE;
			}
			else if(location.solid) {
				fill = SOLID_FILL;
				line = SOLID_LINE;
			}
			int x = location.getX();
			int y = location.getY();
			g2d.setColor(fill);
			g2d.fillRect(x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
			g2d.setColor(line);
			g2d.drawRect(x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		});
		g2d.setColor(PATH_COLOR);
		g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		Path path = this.path;
		Point previous = null;
		while(path != null) {
			Point current = new Point(path.getX() * TILE_WIDTH + (TILE_WIDTH / 2), path.getY() * TILE_HEIGHT + (TILE_HEIGHT / 2));
			if(previous != null)
				g2d.draw(new Line2D.Float(previous, current));
			previous = current;
			path = path.rest;
		}
		g2d.drawImage(this.flag, map.flag.getX() * TILE_WIDTH, map.flag.getY() * TILE_HEIGHT, null);
		g2d.drawImage(this.robot, map.robot.getX() * TILE_WIDTH, map.robot.getY() * TILE_HEIGHT, null);
	}
}
