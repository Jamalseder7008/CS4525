package com.stephengware.java.games.chess.bot;

// import java.io.Console;
import com.stephengware.java.games.chess.state.State;

public class Result {

	
	// /** The parent node of this tree (i.e. the state before this state) */
	// public final GameTree parent;
	
	// /** This node's children nodes (i.e. all possible next states) */
	// public final ArrayList<GameTree> children = new ArrayList<>();
	
	// /** An iterator of the next possible moves to make */
	// private final Iterator<Move> nextMoves;
	
	// /** The utility value of this state (i.e. how desirable it is for the player) */
	// public double value = 0;
	
	// /**
	//  * Constructs a new game tree with some initial state as the root.
	//  * 
	//  * @param initial the initial state of the game
	//  */
	// public GameTree(State initial) {
	// 	this(null, initial, null);
	// }
	
	// protected GameTree(Move move, State state, GameTree parent) {
	// 	this.move = move;
	// 	this.state = state;
	// 	this.parent = parent;
	// 	this.nextMoves = state.getAvailableMoves().iterator();
	// }

    public final State state;
    public double utility;
    public final State parent;
	public final State killerMove;
    

    
    public Result(State state, double utility) {
        this.state = state;
        this.utility = utility;
        this.parent = state.previous;
		this.killerMove = state;
		
        
    }
    
    
}
