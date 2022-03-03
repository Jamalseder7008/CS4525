package com.stephengware.java.games.chess.bot;
import java.util.Iterator;
// import java.io.Console;
import com.stephengware.java.games.chess.state.*;

public class Utility {


    public static double materialCalculator(State child){

		double Utility = 0;
        
        if (child.check == true){
            if (child.player == Player.WHITE){
                Utility -= .20;
            }
            else{
                Utility += .20; 
            }
            Iterator<State> iterator = child.next().iterator();
            while(!child.searchLimitReached() && iterator.hasNext()){
                //update nextChild
                State thisChild = iterator.next();
                double thisUtility = materialCalculator(thisChild);
                if (child.player == Player.WHITE){
                    if(thisUtility >= Utility){
                        Utility = thisUtility;
                    }
                }
                else if (child.player == Player.BLACK){
                    if(thisUtility <= Utility){
                        Utility = thisUtility;
                    }
                }
                
            }
        }
        if (child.over){ //checks for checkmate..
            if (child.previous.player == Player.WHITE){
                Utility += 1;
            }
            else {
                Utility -= 1;
            }
        }
        for (Piece piece : child.board){
		
            if (piece.getClass() == Pawn.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility += 0.01;
		
                } else{
		
                    Utility -= 0.01;
		
                }
		
            } 
		
            else if (piece.getClass() == Knight.class){
                // if(child.turn == 1 || child.turn == 2){
                //     if (piece.player == Player.WHITE){
		
                //         Utility += 0.20;
            
                //     } else{
            
                //         Utility -= 0.20;
            
                //     }
                // }
		
                if (piece.player == Player.WHITE){
		
                    Utility += 0.03;
		
                } else{
		
                    Utility -= 0.03;
		
                }
		
            }
		
            else if (piece.getClass() == Bishop.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility += 0.03;
		
                } else{
		
                    Utility -= 0.03;
		
                }
		
            }
		
            else if (piece.getClass() == Rook.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility += 0.05;
		
                } else{
		
                    Utility -= 0.05;
		
                }
		
            }
		
            else if (piece.getClass() == Queen.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility += 0.09;
		
                } else{
		
                    Utility -= 0.09;
		
                }
		
            }
		
            else if (piece.getClass() == King.class){
		
                if (piece.player == Player.WHITE){
		
                    Utility += 0.20;
		
                } else{
		
                    Utility -= 0.20;
		
                }
		
            }
		
        }
        
		
        return Utility;
	
    }

}
