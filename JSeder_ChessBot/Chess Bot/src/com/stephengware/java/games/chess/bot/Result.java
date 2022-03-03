package com.stephengware.java.games.chess.bot;

// import java.io.Console;
import com.stephengware.java.games.chess.state.State;

public class Result {

    public final State state;
    public double utility;
    
    public Result(State state, double utility) {
        this.state = state;
        this.utility = utility;
    }
    
    
}
