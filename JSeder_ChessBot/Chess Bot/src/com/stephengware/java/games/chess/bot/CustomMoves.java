package com.stephengware.java.games.chess.bot;
import java.util.Iterator;
import com.stephengware.java.games.chess.state.*;

public class CustomMoves {
    public static State openingMove(State root){
        if(root.turn == 0){
            if (root.player == Player.WHITE){
                Piece AlphaPawn = root.board.getPieceAt(
                        root.board.getKing(root.player).file,
                        root.board.getKing(root.player).rank+1
                        );
                if(root.board.contains(AlphaPawn))
                {
                    Iterator<State> iterator = root.next(AlphaPawn).iterator();
                    while(!root.searchLimitReached() && iterator.hasNext()){
                        State child = (iterator.next());
                        return child;
                    }
                    
                }
            }
            else if(root.player == Player.BLACK){
                Piece AlphaPawn = root.board.getPieceAt(
                        root.board.getKing(root.player).file,
                        root.board.getKing(root.player).rank-1
                        );
                if(root.board.contains(AlphaPawn))
                {
                    Iterator<State> iterator = root.next(AlphaPawn).iterator();
                    while(!root.searchLimitReached() && iterator.hasNext()){
                        State child = iterator.next();
                        return child;
                        }
                    }
                    
                }
            }
        return root;
            
        }
        
            //gets pawn in front of king
        
}


