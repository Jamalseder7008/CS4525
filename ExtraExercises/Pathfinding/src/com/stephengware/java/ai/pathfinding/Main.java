package com.stephengware.java.ai.pathfinding;

import java.util.HashSet;
import java.lang.Math;

import com.stephengware.java.ai.pathfinding.gui.*;


/**
 * This exercise will demonstrate how many different kinds of search algorithms
 * can be implemented using the same basic process with slight variations in
 * how the next state is chosen.
 * 
 * The problem being solved in this example is a simple navigation problem in a
 * 2D grid.  Your goal is to guide a robot from its starting location to its
 * destination (marked with a flag).  After each iteration of the search
 * process, the current state of the search will be drawn on the screen to show
 * which locations have been considered, which have not been considered, and
 * which can be considered next.
 * 
 * @author Stephen G. Ware
 */
public class Main {

	/**
	 * Performs a path search and guides the robot to the flag.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		// Choose a map.
		Map map = Map.MAP_4;
		// Step 0: Initialize the set of visited locations and the frontier.
		HashSet<Location> visited = new HashSet<Location>();
		PriorityQueue<Path> frontier = new PriorityQueue<Path>();
		frontier.push(
			new Path(map.getLocation(map.robot)), 
			manhattan(
				map.getLocation(map.robot), 
				map.getLocation(map.flag)
			) 
		);

		// Create the visualization.
		GridPanel grid = new GridPanel(map, visited, frontier);
		new GridFrame(grid);
		// Search for a path.
		boolean pathNotFound = true;
		while( pathNotFound  ) {
			// Step 1: Remove a path from the frontier. 
			if (frontier.size() == 0){
				System.out.println("Something went wrong");
			} 
			Path current = frontier.pop();
			// Draw the path on the screen.
			grid.draw(current);
			// Step 2: If this path is a solution (i.e. a path that ends at the
			// destination), then beak out of the loop.  A path is defined by
			// its last location, so you can check if this path is a solution
			// by comparing it to Map#flag.
			if (current.contains(map.getLocation(map.flag))){
				pathNotFound = false;
			}
			// Step 3: (optional) Add the current location to the set of
			// visited locations so that we don't repeat work later by visiting
			// it again.
			visited.add(new Location(map, current.x, current.y, false));
			// Step 4: Add each possible next unvisited state to the frontier.
			// You can use Location#neighbors() to a get a set of all the
			// locations that are one step away from the current location and
			// are not walls.  You can add a location to the current path by
			// using Path#addToPath(Location).  Be aware that addToPath does
			// not modify the path itself but returns a new path object.
			// Also, don't forget: you should only add a location to the
			// frontier if it has not yet been visited.
			for (Location neighbor : current.neighbors()){
				if (!visited.contains(neighbor)){
					//current.addToPath(neighbor);
					frontier.push(
						new Path(neighbor),
						(manhattan(
							neighbor, 
							map.flag)
							)
						);
				}
			}
			
		}
		// Follow the path.
		follow(grid, map.robot, grid.getPath());
	}
	
	/**
	 * Manhattan distance is the sum of the difference between the horizontal
	 * and vertical positions of two locations.  It is an admissible
	 * heuristic when navigating on a grid because it never overestimates.
	 * You can think of this as the distance you would need to travel between
	 * two locations if there were no walls in the way.
	 * 
	 * @param l1 the first location
	 * @param l2 the second location
	 * @return the Manhattan distance between the two locations
	 */
	private static int manhattan(Location l1, Location l2) {
		int x = Math.abs(l2.getX() - l1.getX());
		int y = Math.abs(l2.getY() - l1.getY());
		return x+y;
	}

	/**
	 * A search style takes the start position and the end position to discover
	 * the best posiblle path
	 * 
	 * @param l1 the start position
	 * @param l2 the end position
	 * @param l3 current neighbor position
	 * @return the total distance travelled
	 */
	private static int aStar(Location l1, Location l2, Location l3){
		int x = Math.abs(l2.getX() - l1.getX());
		int y = Math.abs(l2.getY() - l1.getY());
		
		return x+y;
	}
	
	/**
	 * A recursive method to guide the robot along a path.
	 * 
	 * @param grid the visualization of the map
	 * @param sprite the object to move along the path
	 * @param path the path to follow
	 */
	private static void follow(GridPanel grid, Sprite sprite, Path path) {
		if(path == null)
			return;
		else {
			follow(grid, sprite, path.rest);
			if(grid.map.getLocation(path.getX(), path.getY()).solid)
				throw new RuntimeException("You ran into a wall!");
			int dx = path.getX() - sprite.getX();
			int dy = path.getY() - sprite.getY();
			if(Math.abs(dx + dy) > 1)
				throw new RuntimeException("Invalid path!");
			sprite.move(dx, dy);
			grid.repaint();
		}
	}
}
