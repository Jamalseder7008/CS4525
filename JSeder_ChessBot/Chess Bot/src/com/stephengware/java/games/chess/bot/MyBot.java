package com.stephengware.java.games.chess.bot;

// import java.io.Console;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import com.stephengware.java.games.chess.state.Player;
import com.stephengware.java.games.chess.state.State;

/**
 * A chess bot which selects its next move at random.
 * 
 * @author Stephen G. Ware
 */


 /*
if(piece.getClass() == Pawn.class){ 
 //turns out piece was a Pawn! 

else if(piece.getClass() == Knight.class){ 
 //turns out piece was a Knight! 

 */

public class MyBot extends Bot {

	/** A random number generator */
	public double value;
	public double golf;
	
	
	/**
	 * Constructs a new chess bot named "My Chess Bot" and whose random  number
	 * generator (see {@link java.util.Random}) begins with a seed of 0.
	 */
	public MyBot() {
		super("JSeder");
		
	}

	@Override
	protected State chooseMove(State root) {
		// This list will hold all the children nodes of the root.
		ArrayList<Result> children = new ArrayList<Result>();
		// Generate all the children nodes of the root (that is, all the
		// possible next states of the game.  Make sure that we do not exceed
		// the number of GameTree nodes that we are allowed to generate.
		Iterator<State> iterator = root.next().iterator();
		
		while(!root.searchLimitReached() && iterator.hasNext()){
			//update nextChild
			State thisChild = iterator.next();
			double thisUtility = Utility.materialCalculator(thisChild);
			Result node = new Result(thisChild, thisUtility);
            children.add(node);
		}
        this.value = Utility.materialCalculator(root);

		//append the value to the root and make a new head
        Result head = new Result(root, value);
		
		int charlie = head.state.turn+1; //depth_limit
		Player delta = head.state.player;
        if(head.state.player == Player.WHITE){
            this.value = AlphaBetaBot.findMax(head, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, charlie, delta);
        } else{
            this.value = AlphaBetaBot.findMin(head, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, charlie, delta);
        }
		// for (Result child: children){
		// 	if (root.turn == 0){
		// 		if(root.)
		// 		Iterable<State> quickCheckmate = (child.state.next(child.state.board.getPieceAt(4, 2)));
				
		// 	}
		// }
		// if (root.turn <= 1){
		// 	State Opener = CustomMoves.openingMove(root);
		// 	if( Opener != root ){
		// 		return Opener;
		// 	}
		// }
		//Collections.reverse(children);
		for (Result child: children){
			if(child.utility == this.value){
				
					// if (child.state.turn == 1 || child.state.turn == 2){
					//move middle pawn and disperse knights forward
					// }
					if(child.state.movesUntilDraw > 1 ){
						return child.state;
					}
					
				}
			}
		
		// for (Result child: children){
		// 	int echo = child.state.turn+1; //depth_limit
		// 	Player foxtrot = child.state.player;
		// 	if(child.state.player == Player.WHITE){
		// 		this.golf  = AlphaBetaBot.findMax(head, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, echo, foxtrot);
		// 	} else{
		// 		this.golf = AlphaBetaBot.findMin(head, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, echo, foxtrot);
		// 	}
		// 	if (child.state.player == Player.WHITE){
		// 		if (this.golf >= this.value){
		// 			return child.state;
		// 		}
		// 	}
		// 	if(child.state.player == Player.BLACK){
		// 		if(this.golf <= this.value){
		// 			return child.state;
		// 		}
		// 	}
		// }
		
		
		
		// for (Result child: children){
		// 	if (child.state.player == Player.WHITE){
		// 		if(child.utility == this.value){
		// 			return child.state;
		// 		}

		// 	}
		// 	else {
		// 		if(child.utility == this.value){
		// 			return child.state;
		// 		}
		// 	}
		// 
		//}
		int rnd = new Random().nextInt(children.size());

		return children.get(rnd).state;
		
		// Find a way to calculate material score of each child node
		// higher material score is a higher probability of success 
		// Choose child with max(material_score) aka Greedy Bot
		
		
	}
}


