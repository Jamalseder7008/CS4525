package com.stephengware.java.ai.pathfinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Represents a 2D space that may contain walls.
 * 
 * @author Stephen G. Ware
 */
public class Map implements Iterable<Location> {

	/**
	 * Represents a wall to indicate what parts of the space are impassable.
	 * 
	 * @author Stephen G. Ware
	 */
	private static final class Wall {
		
		/** The horizontal position of the bottom left corner of the wall */
		public final int x;
		
		/** The vertical position of the bottom left corner of the wall */
		public final int y;
		
		/** The width the wall */
		public final int width;
		
		/** The height of the wall */
		public final int height;
		
		/**
		 * Defined a new wall.
		 * 
		 * @param x the horizontal position of the bottom left corner
		 * @param y the vertical position of the bottom left corner
		 * @param width the width
		 * @param height the height
		 */
		public Wall(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		/**
		 * Tests whether or not a given position falls within this wall.
		 * 
		 * @param x the horizontal position
		 * @param y the vertical position
		 * @return true if this position is inside a wall, false otherwise
		 */
		public boolean contains(int x, int y) {
			return x >= this.x &&
					x < this.x + width &&
					y >= this.y &&
					y < this.y + height;
		}
	}
	
	/** The width of the space */
	public final int width;
	
	/** The height of the space */
	public final int height;
	
	/** The robot */
	public final Sprite robot;
	
	/** The destination */
	public final Sprite flag;
	
	/** All the location objects representing each location in the space */
	private final ArrayList<Location> locations = new ArrayList<>();
	
	/**
	 * Creates a new 2D space with a give number of walls.
	 * 
	 * @param width the width of the space
	 * @param height the height of the space
	 * @param walls any walls the space contains
	 */
	public Map(int width, int height, Wall...walls) {
		this.width = width;
		this.height = height;
		for(int x=0; x<width; x++)
			for(int y=0; y<height; y++)
				locations.add(new Location(this, x, y, solid(x, y, walls)));
		this.robot = new Sprite(this, 1, height / 2);
		this.flag = new Sprite(this, width - 2, height / 2);
	}
	
	/**
	 * Tests whether or not a given X, Y location is inside a wall.
	 * 
	 * @param x the horizontal location
	 * @param y the vertical location
	 * @param walls the walls to tests
	 * @return true if the location is inside a wall, false otherwise
	 */
	private static final boolean solid(int x, int y, Wall[] walls) {
		for(Wall wall : walls)
			if(wall.contains(x, y))
				return true;
		return false;
	}

	@Override
	public Iterator<Location> iterator() {
		return locations.iterator();
	}
	
	@Override
	public void forEach(Consumer<? super Location> consumer) {
		locations.forEach(consumer);
	}
	
	/**
	 * Returns the {@link Location} object at the given coordinates.
	 * 
	 * @param x the horizontal position
	 * @param y the vertical position
	 * @return a {@link Location} object
	 */
	public Location getLocation(int x, int y) {
		return locations.get(x * height + y);
	}
	
	/**
	 * Returns the {@link Location} object at the position of a given
	 * {@link Sprite}.
	 * 
	 * @param sprite the sprite
	 * @return a {@link Location} object at the same position
	 */
	public Location getLocation(Sprite sprite) {
		return getLocation(sprite.getX(), sprite.getY());
	}
	
	/** An empty map */
	public static final Map MAP_1 = new Map(15, 9);
	
	/** A map with a simple wall */
	public static final Map MAP_2 = new Map(15, 9,
			new Wall(7, 1, 1, 7)
	);
	
	/** A map with 2 walls */
	public static final Map MAP_3 = new Map(15, 9,
			new Wall(5, 0, 1, 6),
			new Wall(9, 3, 1, 6)
	);
	
	/** A map with a long corridor leading to a dead end */
	public static final Map MAP_4 = new Map(15, 9,
			new Wall(3, 2, 8, 1),
			new Wall(11, 2, 1, 4),
			new Wall(3, 5, 8, 1)
	);
	
	/** A map with a long dead end corridor on the top */
	public static final Map MAP_5 = new Map(15, 9,
			new Wall(3, 4, 8, 1),
			new Wall(11, 2, 1, 3),
			new Wall(11, 2, 4, 1)
	);
	
	/** A map with a long, winding path that will fool greedy search */
	public static final Map MAP_6 = new Map(15, 9,
			new Wall(3, 5, 9, 1),
			new Wall(5, 1, 1, 7),
			new Wall(5, 1, 9, 1),
			new Wall(7, 3, 8, 1)
	);
}
