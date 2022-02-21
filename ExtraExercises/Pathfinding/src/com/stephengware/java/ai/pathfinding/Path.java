package com.stephengware.java.ai.pathfinding;

/**
 * A path is a sequence of {@link Location}s that is defined by the last
 * location on the path.
 * 
 * @author Stephen G. Ware
 */
public class Path extends Location {

	/** All the locations before this location in the path (or null) */
	public final Path rest;
	
	/** The lengt of this path */
	public final int length;
	
	/**
	 * Constructs a path which has visited a given path of locations and then
	 * ends at the given location.
	 * 
	 * @param rest the locations to visit at the start of this path
	 * @param last the last location to visit
	 */
	private Path(Path rest, Location last) {
		super(last.map, last.x, last.y, false);
		this.rest = rest;
		if(rest == null)
			length = 1;
		else
			length = rest.length + 1;
	}
	
	/**
	 * Constructs a path with only a single given location.
	 * 
	 * @param first the first location on the path
	 */
	public Path(Location first) {
		this(null, first);
	}
	
	@Override
	public String toString() {
		return "path to (" + x + "," + y + ")";
	}
	
	/**
	 * Tests whether or not this path contains the given location.
	 * 
	 * @param location the location to test
	 * @return true if this location is part of this path, false otherwise
	 */
	public boolean contains(Location location) {
		if(equals(location))
			return true;
		else if(rest == null)
			return false;
		else
			return rest.contains(location);
	}
	
	/**
	 * Returns a new path with the given location added to the end.
	 * 
	 * @param last the location to add to the end of the new path
	 * @return a new path with the given location added to the end
	 */
	public Path addToPath(Location last) {
		return new Path(this, last);
	}
}
