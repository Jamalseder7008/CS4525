package com.stephengware.java.ai.pathfinding;

/**
 * A sprite is a thing located in a 2D space that can move.
 * 
 * @author Stephen G. Ware
 */
public class Sprite extends Location {

	/**
	 * Creates a new sprite at a given location.
	 * 
	 * @param map the map on which the sprite will appear
	 * @param x the horizontal location of the sprite
	 * @param y the vertical location of the sprite
	 */
	public Sprite(Map map, int x, int y) {
		super(map, x, y, false);
	}

	/**
	 * Moves a sprite to a new location.
	 * 
	 * @param dx the change in the horizontal position
	 * @param dy the change in the vertical position
	 */
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
}
