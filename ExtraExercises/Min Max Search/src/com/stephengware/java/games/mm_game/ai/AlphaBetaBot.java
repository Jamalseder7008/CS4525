package com.stephengware.java.games.mm_game.ai;

import com.stephengware.java.games.mm_game.state.Player;
import com.stephengware.java.games.mm_game.state.State;

/**
 * This bot performs just as well as {@link MinMaxBot} but expands
 * significantly fewer nodes by intelligently pruning the tree.
 * 
 * @author Stephen G. Ware
 */
public class AlphaBetaBot implements Bot {

	@Override
	public Decision chooseMove(State state) {
		GameTree root = new GameTree(state);
		double value;
		if(state.getCurrentPlayer() == Player.X)
			value = findMax(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		else
			value = findMin(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
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
	 * @param alpha the highest utility value discovered so far in this branch of the tree (i.e. best for X)
	 * @param beta the lowest utility value discovered so far in this branch of the tree (i.e. best for O)
	 * @return the utility value of the node with the highest minimum utility
	 */
	private double findMax(GameTree tree, double alpha, double beta) {
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
		
		// The parameter 'beta' holds the lowest utility value that has been
		// discovered so far in this branch of the game tree.  We are currently
		// looking for the child with the highest value, but if we find something
		// that is greater than or equal to alpha, there is no reason to bother
		// checking more children nodes because a better move must already exist
		// somewhere else that has already been explored.
		
		// Update alpha to be the lowest value discovered so far.
		
		return max;
	}
	
	/**
	 * Given a {@link GameTree} node, expand its children (if any) to find the
	 * node with the lowest maximum utility value.
	 * 
	 * @param tree the node whose children need to be expanded
	 * @param alpha the highest utility value discovered so far in this branch of the tree (i.e. best for X)
	 * @param beta the lowest utility value discovered so far in this branch of the tree (i.e. best for O)
	 * @return the utility value of the node with the lowest maximum utility
	 */
	private double findMin(GameTree tree, double alpha, double beta) {
		// This method is simply the opposite of #findMax.
		double min = 0;
		// The parameter 'alpha' holds the highest utility value that has been
		// discovered so far in this branch of the game tree.  We are currently
		// looking for the child with the lowest value, but if we find something
		// that is less than or equal to alpha, there is no reason to bother checking
		// more children nodes because a better move must already exist somewhere
		// else that has already been explored.

		// Update beta to be the lowest value discovered so far.
		
		return min;
	}
}
