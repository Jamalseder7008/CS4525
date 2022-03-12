package com.stephengware.java.games.chess.bot;

// import java.io.Console;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import com.stephengware.java.games.chess.state.Piece;
import com.stephengware.java.games.chess.state.Player;
import com.stephengware.java.games.chess.state.Queen;
import com.stephengware.java.games.chess.state.State;

/**
 * A chess bot which selects its next move at random.
 * 
 * @author Stephen G. Ware
 */


public class MyBot extends Bot {

	
	public double value;
	public double golf;
	private Result bestChild;
	
	
	/**
	 * Constructs a new chess bot named "My Chess Bot" and whose random  number
	 * generator (see {@link java.util.Random}) begins with a seed of 0.
	 */
	public MyBot() {
		super("JSeder");
		
	}

	@Override
	protected State chooseMove(State root) {
		// ArrayList<State> children = new ArrayList<State>();
		// //This list will hold all the children nodes of the root.
		// Iterator<State> iterator = root.next().iterator();
		// //A child node has been breached
		

	
		// while(!root.searchLimitReached() && iterator.hasNext()){
		// 	// You can get the next unexplored child node with GameTree#getNextChild().
		// 	State child = iterator.next();
		// 	children.add(child);
		// }

        Result head = new Result(root, Utility.materialCalculator(root));
		//starting player of the algorithm
		Player myTurn = head.state.player;
        if(head.state.player == Player.WHITE){
			int depthLimit = head.state.turn+2;
            this.bestChild = AlphaBetaBot.findMax(head, new Result(head.state,Double.NEGATIVE_INFINITY), new Result(head.state,Double.POSITIVE_INFINITY), depthLimit, myTurn);
			// System.out.println(this.bestChild.state.toString());
			// System.out.println(this.bestChild.utility);
		} 
		else{
			int depthLimit = head.state.turn+2;
            this.bestChild = AlphaBetaBot.findMin(head, new Result(head.state,Double.NEGATIVE_INFINITY), new Result(head.state,Double.POSITIVE_INFINITY), depthLimit, myTurn);
        }

		Double utility = this.bestChild.utility;
		State key = this.bestChild.state;
		String board = this.bestChild.state.board.toString();
		System.out.println(board);
		System.out.println(utility);
		Boolean hasMoreParents = true;
		while(hasMoreParents){
			if(key.previous == root){
				hasMoreParents = false;
				break;
			}
			key = key.previous;
			
		}
		System.out.println("\n");
		System.out.println(key.board.toString());
		// Double util = Utility.materialCalculator(key);
		// if(key.over && !key.check){
		// 	for(State child: children){
		// 		if(root.player == Player.WHITE){
		// 			if (key != child && Utility.materialCalculator(child) >= util){
		// 				return child;
		// 			}
		// 		}
		// 		else{
		// 			if (key != child && Utility.materialCalculator(child) <= util){
		// 				return child;
		// 			}
		// 		}
				
		// 	}
		// }
		
		return key;
		
		
	}
}


