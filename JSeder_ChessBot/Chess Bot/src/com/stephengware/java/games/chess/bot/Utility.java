package com.stephengware.java.games.chess.bot;
import java.util.Iterator;
// import java.io.Console;
import com.stephengware.java.games.chess.state.*;

public class Utility {

    //check the current Utility of a move

    public static double check(State child){
        double value = 0;
        if (child.check == true){
            if (child.player == Player.WHITE){
                value -= .20;
            }
            else{
                value += .20; 
            }
            Iterator<State> iterator = child.next().iterator();
            while(!child.searchLimitReached() && iterator.hasNext()){
                //update nextChild
                State thisChild = iterator.next();
                double thisUtility = materialCalculator(thisChild);
                if (child.player == Player.WHITE){
                    if(thisUtility >= value){
                        value = thisUtility;
                    }
                }
                else if (child.player == Player.BLACK){
                    if(thisUtility <= value){
                        value = thisUtility;
                    }
                }
                
            }
        }
        return value;
    }

    public static double materialCalculator(State child){

        double value = 0;
		double whiteBishops = 0;
        double blackBishops = 0;
        

        if (child.check == true){
            if (child.player == Player.WHITE){
                value -= 1;
            }
            else{
                value += 1; 
            }
        
        }
        if (child.over){ //checks for checkmate..
            if (child.previous.player == Player.WHITE){
                value += Double.POSITIVE_INFINITY;
            }
            else {
                value += Double.NEGATIVE_INFINITY;
            }
        }
        // Utility = forker(child);
        for (Piece piece : child.board){
		
            if (piece.getClass() == Pawn.class){
		
                if (piece.player == Player.WHITE){
                    // if(!child.board.hasMoved(piece)){
                    //     value += .5;
                    // }
                    if(child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += 1;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else{
                        value += .5;
                    }
                    // if(piece.rank > 1){
                    //     value -= (piece.rank/8);
                    // }
		
                    
		
                }
                 else{
                    // if(!child.board.hasMoved(piece)){
                    //     value -= .5;
                    // }
                    if(child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value -= 1;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else{
                        value -= .5;
                    }
                    
                    // if(piece.rank < 6){
                    //     value += (1-piece.rank/8);
                    // }
		
                }
		
            } 
		
            else if (piece.getClass() == Knight.class){
                
		
                if (piece.player == Player.WHITE){
                    value += 3;
                    if(piece.rank > 1 && piece.rank <= 6 && piece.file > 1 && piece.file < 6){
                        value += 0.5;
                    }

                    if(child.turn > 10 && child.turn < 20){
                        value += 3;
                    }
                    if(child.turn > 20){
                        value += 3;
                    }
                    
		
                } else{
		
                    value -= 3;
                    if(piece.rank > 1 && piece.rank < 6 && piece.file > 1 && piece.file < 6){
                        value -= 0.5;
                    }
                    if(child.turn > 10 && child.turn < 20){
                        value -= 3;
                    }
                    if(child.turn > 20){
                        value -= 3;
                    }
		
                }
		
            }
		
            else if (piece.getClass() == Bishop.class){
		
                if (piece.player == Player.WHITE){
		
                    value += 3;
                    whiteBishops += 1;
		
                } else{
		
                    value -= 3;
                    blackBishops += 1;
		
                }
		
            }
		
            else if (piece.getClass() == Rook.class){
		
                if (piece.player == Player.WHITE){
		
                    value += 5;
		
                } else{
		
                    value -= 5;
		
                }
		
            }
		
            else if (piece.getClass() == Queen.class){
		
                if (piece.player == Player.WHITE){
		
                    value += 9;
		
                } else{
		
                    value -= 9;
		
                }
		
            }
		
            else if (piece.getClass() == King.class){
		
                if (piece.player == Player.WHITE){
                    // if (child.board.hasMoved(piece)){
                    //     Utility += .20;
                    // }
                    // else{
                    //     Utility += 0.30;
                    // }
                    if(!child.board.hasMoved(piece)){
                        value += 30;
                    }
                    else{
                        value += 20;
                    }
                    
		
                } else{

                    // if (child.board.hasMoved(piece)){
                    //     Utility -= .20;
                    // }
                    // else{
                    //     Utility -= 0.30;
                    // }
                    if(!child.board.hasMoved(piece)){
                        value -= 30;
                    }
                    else{
                        value -= 20;
                    }
                }
		
            }
		
        }
        if(child.movesUntilDraw < 2){
            if(child.player == Player.WHITE){
                value -= 30;
            }
            else{
                value += 30;  
            }
           
        }
        
        if(whiteBishops == 2){
            value += 1;
        }
        if(blackBishops == 2){
            value -= 1;
        }
        return (value);
	
    }



}
