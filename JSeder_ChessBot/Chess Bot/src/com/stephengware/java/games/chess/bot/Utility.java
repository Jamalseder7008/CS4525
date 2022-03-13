package com.stephengware.java.games.chess.bot;
// import java.io.Console;
import com.stephengware.java.games.chess.state.*;

public class Utility {

    //check the current Utility of a move

    public static double materialCalculator(State child){

        double value = 0;
		double whiteBishops = 0;
        double blackBishops = 0;
        double minorPiecesWhite = 0;
        double minorPiecesBlack = 0;
        double whitePawns = 0;
        double blackPawns = 0;
        
        double majorPiecesWhite = 0;
        double majorPiecesBlack = 0;
        

        if (child.check == true){
            if (child.player == Player.WHITE){
                value -= .1;
            }
            else{
                value += .1; 
            }
        
        }
        if (child.over){ //checks for checkmate..
            if(child.check){
                if(child.player == Player.WHITE){
                    value -= Double.POSITIVE_INFINITY;
                }
                else{
                    value += Double.POSITIVE_INFINITY;
                }
                //this means checkmate for the current player
            }
            else{
                if(child.board.countPieces(child.player)-2 > child.board.countPieces(child.player.other())){
                    if(child.player == Player.WHITE){
                        value -= 100;
                    }
                    else{
                        value += 100;
                    }
                }
                else{
                    if(child.player == Player.WHITE){
                        value -= 100;
                    }
                    else{
                        value += 100;
                    }
                }
                
                //this means stalemate
            }
            
        }
        // Utility = forker(child);
        for (Piece piece : child.board){
		
            if (piece.getClass() == Pawn.class){
		
                if (piece.player == Player.WHITE){
                    // if(!child.board.hasMoved(piece)){
                    //     value += .5;
                    // }
                    value += .01*(piece.rank-1);
                    if(child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass())){
                        value += .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass())){
                        value += .5;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value += .5;
                    }
                    else if(child.board.pieceAt(0, piece.rank+1, piece.player, piece.getClass()) || child.board.pieceAt(7, piece.rank, piece.player, piece.getClass())){
                        value += .125;
                    }
                    
                    else{
                        value += .25;
                    }
                    // if(piece.rank > 1){
                    //     value -= (piece.rank/8);
                    // }
		
                    
		
                }
                 else{
                    // if(!child.board.hasMoved(piece)){
                    //     value -= .5;
                    // }
                    value -= .01*(6-piece.rank);
                    if(child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass()) && 
                            child.board.pieceAt(piece.file-1, piece.rank-1, piece.player, piece.getClass())){
                        value -= .75;
                    }
                    else if(child.board.pieceAt(piece.file-1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .5;
                    }
                    else if(child.board.pieceAt(piece.file+1, piece.rank+1, piece.player, piece.getClass())){
                        value -= .5;
                    }
                    else if(child.board.pieceAt(0, piece.rank+1, piece.player, piece.getClass()) || child.board.pieceAt(7, piece.rank, piece.player, piece.getClass())){
                        value -= .125;
                    }
                    else{
                        value -= .25;
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
                        value += 2;
                    }
                    if(child.turn > 20){
                        value += 2;
                    }
                    minorPiecesWhite += 1;
                    
		
                } else{
		
                    value -= 3;
                    if(piece.rank > 1 && piece.rank < 6 && piece.file > 1 && piece.file < 6){
                        value -= 0.5;
                    }
                    if(child.turn > 10 && child.turn < 20){
                        value -= 2;
                    }
                    if(child.turn > 20){
                        value -= 2;
                    }
                    minorPiecesBlack += 1;
		
                }
		
            }
		
            else if (piece.getClass() == Bishop.class){
		
                if (piece.player == Player.WHITE){
		
                    value += 3;
                    whiteBishops += 1;
                    minorPiecesWhite += 1;
		
                } else{
		
                    value -= 3;
                    blackBishops += 1;
                    minorPiecesBlack += 1;
		
                }
		
            }
		
            else if (piece.getClass() == Rook.class){
		
                if (piece.player == Player.WHITE){
                    boolean emptyFile = true;
                    value += 5;
                    // if(child.board.countPieces() < 22){
                    //     value += 3;
                    // }
                    for(int i = 0; i < 8; i++){
                        if(child.board.pieceAt(piece.file, piece.rank+i)){
                            emptyFile = false;
                        }
                    }
                    if(emptyFile == true){
                        value += 1;
                    }
                    majorPiecesWhite += 1;
                    
		
                } else{
                    boolean emptyFile = true;
                    value -= 5;
                    // if(child.board.countPieces() < 22){
                    //     value -= 3;
                    // }
                    for(int i = 0; i < 8; i++){
                        if(child.board.pieceAt(piece.file, piece.rank+i)){
                            emptyFile = false;
                        }
                    }
                    if(emptyFile == true){
                        value -= 1;
                    }
                    majorPiecesBlack += 1;
		
                }
		
            }
		
            else if (piece.getClass() == Queen.class){
		
                if (piece.player == Player.WHITE){
		
                    value += 10;
                    if(child.turn > 11){
                        value += 3;
                    }
                    majorPiecesWhite +=1;
		
                } else{
		
                    value -= 10;
                    if(child.turn > 11){
                        value -= 3;
                    }
                    majorPiecesBlack += 1;
		
                }
		
            }
		
            else if (piece.getClass() == King.class){
		
                if (piece.player == Player.WHITE){
                    
                    if(!child.board.hasMoved(piece)){
                        value += 1;
                    }
                    if(!child.board.pieceAt(piece.file, 0, Player.WHITE, piece.getClass())){
                        value -= 1;
                    }
                    
                    value += 20;
                    
                    
		
                } else{

                    if(!child.board.hasMoved(piece)){
                        value -= 1;
                    }
                    if(!child.board.pieceAt(piece.file, 0, Player.BLACK, piece.getClass())){
                        value += 1;
                    }
                   
                    value -= 20;
                    
                }
		
            }
		
        }
        
        if(whiteBishops == 2){
            value += 1;
        }
        if(blackBishops == 2){
            value -= 1;
        }
        // if(child.player == Player.WHITE && majorPiecesWhite > majorPiecesBlack){
        //     value += 1;
        // }
        // else if(child.player == Player.BLACK && majorPiecesBlack > majorPiecesWhite){
        //     value -= 1;
        // }
        // if(child.player == Player.WHITE && minorPiecesWhite > minorPiecesBlack){
        //     value += 1;
        // }
        // else if(child.player == Player.BLACK && minorPiecesBlack > minorPiecesWhite){
        //     value -= 1;
        // }


        return (value);
	
    }



}
