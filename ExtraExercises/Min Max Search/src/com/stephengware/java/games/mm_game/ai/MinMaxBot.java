package com.stephengware.java.games.mm_game.ai;

import com.stephengware.java.games.mm_game.state.Player;
import com.stephengware.java.games.mm_game.state.State;

/**
 * This bot expands the entire game tree and makes its decision based on Min
 * Max search.
 * 
 * @author Stephen G. Ware
 */
public class MinMaxBot implements Bot {
	
	@Override
	public Decision chooseMove(State state) {
		GameTree root = new GameTree(state);
		double value;
		if(state.getCurrentPlayer() == Player.X)
			value = findMax(root);
		else
			value = findMin(root);
		for(GameTree child : root.children)
			if(child.value == value)
				return new Decision(child.move, root.size());
		return null;
	}
	
	/**
	 * Given a {@link GameTree} node, expand its children (if any) to find the
	 * node with the highest minimum utility value.
	 * 
	 * @param tree the node whose children need to be expanded
	 * @return the utility value of the node with the highest minimum utility
	 */
	private double findMax(GameTree tree) {
		// First, check if this node is a leaf node (i.e. the game is over)
		// using Tree#state#isTerminal().  If so, simply return the utility of
		// this state.
		
		// If this node is not a leaf, then we need to expand all of its
		// children and find the one with the highest minimum utility value.
		// Start with the lowest possible number, Double#NEGATIVE_INFINITY and
		// work your way up from there.
		double max = 0;
		// You can check if a node has more children that have not yet been
		// explored using GameTree#hasNextChild().
		
		// You can get the next unexplored child node with GameTree#getNextChild().
		
		// Find the lowest possible utility value the child node can have.
		
		// Update 'max' based on this new information.  'max' should always hold the
		// largest value we have discovered so far.
		
		// Return the highest utility value of all the children nodes.
		return max;
	}
	
	/**
	 * Given a {@link GameTree} node, expand its children (if any) to find the
	 * node with the lowest maximum utility value.
	 * 
	 * @param tree the node whose children need to be expanded
	 * @return the utility value of the node with the lowest maximum utility
	 */
	private double findMin(GameTree tree) {
		// This method is simply the opposite of #findMax.
		double min = 0;
		return min;
	}
}
