package com.stephengware.java.games.chess.bot;
// import java.io.Console;
import java.util.Iterator;

import com.stephengware.java.games.chess.state.Player;
// import com.stephengware.java.games.chess.state.Player;
import com.stephengware.java.games.chess.state.State;

public class AlphaBetaBot{

	/**
	 * 
	 * Takes initial @param root which is of the Result class then takes 
	 * @param depthLimit is the depth limit of the amount of turns expected to view
	 * @param myTurn is the player whose turn it is to choose a move in the root of the main function
	 * 
	 *  */ 

    public static Result findMax(Result root, Result alpha, Result beta, int depthLimit, Player myTurn) {
		// First, check if this node is a leaf node (i.e. the game is over)
		// using Tree#state#isTerminal().  If so, simply return the utility of
		// this state.
		if( (root.state.over == true) || (depthLimit == root.state.turn &&  myTurn == root.state.player)) {
			return new Result(root.state, Utility.materialCalculator(root.state));
		}
		
		// If this node is not a leaf, then we need to expand all of its
		// children and find the one with the highest minimum utility value.
		// Start with the lowest possible number
		double max = Double.NEGATIVE_INFINITY;
		Result bestChild = root;

		Iterator<State> iterator = root.state.next().iterator();
		while(!root.state.searchLimitReached() && iterator.hasNext()){
			
			State child = iterator.next();
			Result childu = new Result(child, Utility.materialCalculator(child));
			
			// Find the lowest possible utility value the child node can have.
			childu = findMin(childu, alpha, beta, depthLimit, myTurn);
			// Update 'max' based on this new information.  'max' should always hold the
			// largest value we have discovered so far.
			if( childu.utility == max(max, childu.utility)){
				
				bestChild = childu;
			}
			max = max(max, childu.utility);
			

			if (max > beta.utility){
				return new Result(bestChild.state, max);
			}
			alpha = new Result(bestChild.state, max(alpha.utility, max));
		}

		return new Result(bestChild.state, max);
	}
	


    public static Result findMin(Result root, Result alpha, Result beta, int depthLimit, Player myTurn) {
		// First, check if this node is a leaf node (i.e. the game is over)
		// isTerminal().  If so, simply return the utility of
		// this state.
		
		if( (root.state.over == true) || (myTurn == root.state.player && depthLimit == root.state.turn)) { 
			//first turn will be 0 so skip
			return new Result(root.state,  Utility.materialCalculator(root.state));
		}
		// If this node is not a leaf, then we need to expand all of its
		// children and find the one with the highest minimum utility value.
		// Start with the lowest possible number, Double#NEGATIVE_INFINITY and
		// work your way up from there.
		double min = Double.POSITIVE_INFINITY;
		Result bestChild = root;
		// You can check if a node has more children that have not yet been
		// explored using iterator.hasNext().
	

		Iterator<State> iterator = root.state.next().iterator();
		while(!root.state.searchLimitReached() && iterator.hasNext()){
			// You can get the next unexplored child node with GameTree#getNextChild().
			State child = iterator.next();
			
			Result childu = new Result(child, Utility.materialCalculator(child));
			
			// Find the highest possible utility value the child node can have.
			childu = findMax(childu, alpha, beta, depthLimit, myTurn);
			
			// Update 'min' based on this new information.  'min' should always hold the
			// smallest value we have discovered so far.
			if( childu.utility == min(min, childu.utility)){
				bestChild = childu;
			}
			min = min(min, childu.utility);

			if(min < alpha.utility){
				return new Result(bestChild.state, min);
			}
			beta = new Result(bestChild.state, min(beta.utility, min));
		}
	
		return new Result(bestChild.state, min);
	}

    private static double max(double best, double child_value) {
        if (best > child_value){

            return best;

        }
		else{
			return child_value;
		}

    }
    private static double min(double best, double child_value) {
        if (best < child_value){

            return best;

        } else {
			return child_value;
		}
    }

}
