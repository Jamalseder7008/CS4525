package com.stephengware.java.games.chess.bot;
import com.stephengware.java.games.chess.state.*;
import com.stephengware.java.games.chess.state.State;
import java.util.Iterator;

public final class Helpers{ 

    // public double bestIndex;

    private double bestIndex;
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

        if (depth >= 1){

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
        find_max(root, 0);
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

   } 