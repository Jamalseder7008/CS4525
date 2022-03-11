package com.stephengware.java.games.chess.bot;

import java.util.Iterator;

import com.stephengware.java.games.chess.state.*;

public class Target {
    
    public static boolean isBeingAttacked(State child, Piece piece2){
        for (Piece piece: child.board){
            Iterator<State> iterator = child.next().iterator();
            
		    while(!child.searchLimitReached() && iterator.hasNext()){
			//update nextChild
			    State nextMove = iterator.next();
                if(!nextMove.board.contains(piece)){
                    if(piece.getClass() == Queen.class){
                        //top priority piece
                        return true;
                    }
                    else if(piece.getClass() == Rook.class){
                        //second highest priority
                        return true;
                    }
                    else if(piece.getClass() == Knight.class){
                        //third highest priority
                        return true;
                    }
                    else if(piece.getClass() == Bishop.class){
                        //fourth highest priority
                        return true;
                    }
                    else if(piece.getClass() == Pawn.class){
                        //lowest priority pieces..
                        return true;
                    }
                    //Someone is able to attack this piece. protect it and attempt to take a more valuable piece with it or protect it.
                }
			    
		}
            
        }

        return false;
    }
}
