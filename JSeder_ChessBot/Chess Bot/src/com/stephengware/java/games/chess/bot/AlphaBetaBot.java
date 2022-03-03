package com.stephengware.java.games.chess.bot;
// import java.io.Console;
import java.util.Iterator;

import com.stephengware.java.games.chess.state.Player;
// import com.stephengware.java.games.chess.state.Player;
import com.stephengware.java.games.chess.state.State;

public class AlphaBetaBot{

    public static double findMax(Result root, double alpha, double beta, int charlie, Player delta) {
		// First, check if this node is a leaf node (i.e. the game is over)
		// using Tree#state#isTerminal().  If so, simply return the utility of
		// this state.
		if(charlie == root.state.turn){
			return Utility.materialCalculator(root.state);
		}
		// if(root.state.over){
		// 	return Utility.materialCalculator(root.state);
		// }
		if((delta == root.state.player.other() && charlie-1 == root.state.turn)) {
			return Utility.materialCalculator(root.state);
		}
		
		// If this node is not a leaf, then we need to expand all of its
		// children and find the one with the highest minimum utility value.
		// Start with the lowest possible number, Double#NEGATIVE_INFINITY and
		// work your way up from there.
		double max = Double.NEGATIVE_INFINITY;

        //gets children nodes
        Iterator<State> iterator = root.state.next().iterator();
		//A child node has been breached
		

		// You can check if a node has more children that have not yet been
		// explored using GameTree#hasNextChild().
		while(!root.state.searchLimitReached() && iterator.hasNext()){
			// You can get the next unexplored child node with GameTree#getNextChild().
			State child = iterator.next();
            Result childu = new Result(child, Utility.materialCalculator(child));
			
			// Find the lowest possible utility value the child node can have.
			childu.utility = findMin(childu, alpha, beta, charlie, delta);

			
			// Update 'max' based on this new information.  'max' should always hold the
			// largest value we have discovered so far.
			
			max = max(max, childu.utility);

            if (max >= beta){
                return max;
            }
            alpha = max(alpha, max);
		}
	
		// Return the highest utility value of all the children nodes.
		return max;
	}

    public static double findMin(Result root, double alpha, double beta, int charlie, Player delta) {
		// First, check if this node is a leaf node (i.e. the game is over)
		// isTerminal().  If so, simply return the utility of
		// this state.
		
		if(charlie == root.state.turn || (delta == root.state.player.other() && charlie-1 == root.state.turn)) { 
			//first turn will be 0 so skip
			return Utility.materialCalculator(root.state);
		}
		// If this node is not a leaf, then we need to expand all of its
		// children and find the one with the highest minimum utility value.
		// Start with the lowest possible number, Double#NEGATIVE_INFINITY and
		// work your way up from there.
		double min = Double.POSITIVE_INFINITY;
		
        //gets children nodes
        Iterator<State> iterator = root.state.next().iterator();
		//A depth of children has been breached.
		
		// You can check if a node has more children that have not yet been
		// explored using iterator.hasNext().
		while(!root.state.searchLimitReached() && iterator.hasNext()){
			// You can get the next unexplored child node with GameTree#getNextChild().
			State child = iterator.next();
            Result childu = new Result(child, Utility.materialCalculator(child));
			
			// Find the highest possible utility value the child node can have.
			childu.utility = findMax(childu, alpha, beta, charlie, delta);
			
			// Update 'min' based on this new information.  'min' should always hold the
			// smallest value we have discovered so far.
			
			min = min(min, childu.utility);

            if(min <= alpha){
                return min;
            }
            beta = min(beta, min);
		}
		// Return the lowest utility value of all the children nodes.
		return min;
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
