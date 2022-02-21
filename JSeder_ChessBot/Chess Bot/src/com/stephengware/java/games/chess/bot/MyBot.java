package com.stephengware.java.games.chess.bot;

// import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import com.stephengware.java.games.chess.bot.Helpers;
import com.stephengware.java.games.chess.bot.Bot;
import com.stephengware.java.games.chess.state.State;
import com.stephengware.java.games.chess.state.*;

/**
 * A chess bot which selects its next move at random.
 * 
 * @author Stephen G. Ware
 */


 /*
if(piece.getClass() == Pawn.class){ 
 //turns out piece was a Pawn! 
} 
else if(piece.getClass() == Knight.class){ 
 //turns out piece was a Knight! 
}
 */

 

public class MyBot extends Bot {

	/** A random number generator */
	private final Random random;
	
	
	/**
	 * Constructs a new chess bot named "My Chess Bot" and whose random  number
	 * generator (see {@link java.util.Random}) begins with a seed of 0.
	 */
	public MyBot() {
		super("JSeder");
		this.random = new Random(0);
	}

	public int bestIndex;

    public int materialCalculator(State child){

		int Utility = 0;
		
        for (Piece piece : child.board){
		
            if (piece.getClass() == Pawn.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility -= 1;
		
                } else{
		
                    Utility += 1;
		
                }
		
            } 
		
            else if (piece.getClass() == Knight.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility -= 4;
		
                } else{
		
                    Utility += 4;
		
                }
		
            }
		
            else if (piece.getClass() == Bishop.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility -= 3;
		
                } else{
		
                    Utility += 3;
		
                }
		
            }
		
            else if (piece.getClass() == Rook.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility -= 6;
		
                } else{
		
                    Utility += 6;
		
                }
		
            }
		
            else if (piece.getClass() == Queen.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility -= 8;
		
                } else{
		
                    Utility += 8;
		
                }
		
            }
		
            else if (piece.getClass() == King.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility -= 20;
		
                } else{
		
                    Utility += 20;
		
                }
		
            }
		
        }
		
        return Utility;
	
    }

    public double find_max(State root, double depth){

        if (depth >= 2){

            int Utility = materialCalculator(root);

            return Utility;

        }

        Iterator<State> iterator = root.next().iterator();
        
        //depth starts as 0
        depth += 1;
        //current value == 1

        int index = -1;
        
        double best = Double.NEGATIVE_INFINITY;

        while(!root.searchLimitReached() && iterator.hasNext()){
            
            index++;
            
            double child_value = find_min(iterator.next(), depth);
            
            best = max(best, child_value);
            
            if (best == child_value){
            
                this.bestIndex = index;
            
            } 

        }

        return best;
    }

    public double find_min(State root, double depth){

        if (root.over){

            int Utility = materialCalculator(root);

            return Utility;

        }
        Iterator<State> iterator = root.next().iterator();

        double best = Double.POSITIVE_INFINITY;
        
        while(!root.searchLimitReached() && iterator.hasNext()){

            double child_value = find_max(iterator.next(), depth);

            best = min(best, child_value);
        }
        
        return best;
    }

    public double min_max(State root){
        double best = find_max(root, 0);
        return this.bestIndex;
    }

    private double max(double best, double child_value) {
        if (best > child_value){

            return best;

        } return child_value;

    }
    private double min(double best, double child_value) {
        if (best < child_value){

            return best;

        } return child_value;

    }

	@Override
	protected State chooseMove(State root) {
		
		

		
		// This list will hold all the children nodes of the root.
		ArrayList<State> children = new ArrayList<>();
		// Generate all the children nodes of the root (that is, all the
		// possible next states of the game.  Make sure that we do not exceed
		// the number of GameTree nodes that we are allowed to generate.
		Iterator<State> iterator = root.next().iterator();
		//State bestChild;

		while(!root.searchLimitReached() && iterator.hasNext()){
			//update nextChild
			State thisChild = iterator.next();
			//update currUtility with materialCalc
			children.add(thisChild);
		}
		
		// Find a way to calculate material score of each child node
		// higher material score is a higher probability of success 
		// Choose child with max(material_score) aka Greedy Bot

		// Choose one of the children at random.
		return children.get(bestIndex);
	}
}
