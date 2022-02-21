package com.stephengware.java.ai.pathfinding;

import java.util.ArrayList;

/**
 * A location is anything with an x and y coordinate in 2D space.
 * 
 * @author Stephen G. Ware
 */
public class Location {

	/** The map on which this location appears. */
	protected final Map map;
	
	/** The horizontal position */
	protected int x;
	
	/** The vertical position */
	protected int y;
	
	/** Whether or not the location contains an impassable wall */
	public final boolean solid;
	
	/**
	 * Creates a new location.
	 * 
	 * @param map the map on which this location appears
	 * @param x the horizontal location
	 * @param y the vertical location
	 * @param solid whether or not the location contains a wall
	 */
	public Location(Map map, int x, int y, boolean solid) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.solid = solid;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Location) {
			Location otherLocation = (Location) other;
			return x == otherLocation.x && y == otherLocation.y;
		}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return x * map.height + y;
	}
	
	@Override
	public String toString() {
		return "location (" + x + "," + y + ")";
	}
	
	/**
	 * Return the horizontal position of this object.
	 * 
	 * @return the horizontal position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Return the vertical position of this object.
	 * 
	 * @return the vertical position
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Returns all locations around this object which are accessible by one
	 * step north, south, east, or west.
	 * 
	 * @return all neighboring locations
	 */
	public Iterable<Location> neighbors() {
		ArrayList<Location> neighbors = new ArrayList<>();
		// North
		if(y > 0)
			neighbors.add(map.getLocation(x, y - 1));
		// East
		if(x < map.width - 1)
			neighbors.add(map.getLocation(x + 1, y));
		// South
		if(y < map.height - 1)
			neighbors.add(map.getLocation(x, y + 1));
		// West
		if(x > 0)
			neighbors.add(map.getLocation(x - 1, y));
		neighbors.removeIf(location -> location.solid);
		return neighbors;
	}
}
