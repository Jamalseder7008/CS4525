package com.stephengware.java.games.chess.bot;

public class ExtraCode {
    //move all my commented out code here so my code looks readable in my other files..

    //Alphabetabot class
            //gets children nodes
        // Iterator<State> iterator = root.state.next().iterator();
		//A child node has been breached
		

		// You can check if a node has more children that have not yet been
		// explored using GameTree#hasNextChild().
	// 	while(!root.state.searchLimitReached() && iterator.hasNext()){
	// 		// You can get the next unexplored child node with GameTree#getNextChild().
	// 		State child = iterator.next();
    //         Result childu = new Result(child, Utility.materialCalculator(child));
			

	// 		// Find the lowest possible utility value the child node can have.
	// 		childu.utility = findMin(childu, alpha, beta, charlie, delta);

			
	// 		// Update 'max' based on this new information.  'max' should always hold the
	// 		// largest value we have discovered so far.
			
	// 		max = max(max, childu.utility);

    //         if (max >= beta){
    //             return max;
    //         }
    //         alpha = max(alpha, max);
	// 	}
	
	// 	// Return the highest utility value of all the children nodes.
	// 	return max;
	// }




    //utility class
    //     public static double forker(State child){
//         double value = 0;
//         if(check(child) != 0){
            
//             Iterator<State> iterator = child.next().iterator();
//             while(!child.searchLimitReached() && iterator.hasNext()){
//                 //update nextChild
//                 State thisChild = iterator.next();
//                 double child_value = materialCalculator(child);
//                 Result afterCheck = new Result(thisChild, child_value);
//                 int charlie = afterCheck.state.turn+1; //depth_limit
// 		        Player delta = afterCheck.state.player;
//                 if(child.player == Player.WHITE){
//                     value = AlphaBetaBot.findMax(afterCheck, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, charlie, delta, omega);
//                 }
//                 else{
//                     value = AlphaBetaBot.findMin(afterCheck, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, charlie, delta);
//                 }
            
//             }

//         }
//         return value;
// }
    // public static double checkmate(State child){
    //     Piece thisKing = child.board.getKing(child.player);
    //         if (child.player == Player.WHITE){

    //         } 
        
    //     for (Piece piece: child.board){
            
    //     }
    // }

    // Iterator<State> iterator = child.next().iterator();
            // while(!child.searchLimitReached() && iterator.hasNext()){
            //     //update nextChild
            //     State thisChild = iterator.next();
            //     double thisUtility = materialCalculator(thisChild);
            //     if (child.player == Player.WHITE){
            //         if(thisUtility >= Utility){
            //             Utility = thisUtility;
            //         }
            //     }
            //     else if (child.player == Player.BLACK){
            //         if(thisUtility <= Utility){
            //             Utility = thisUtility;
            //         }
            //     }
                
            //}


                // Iterator<State> iterator = child.next().iterator();
            // while(!child.searchLimitReached() && iterator.hasNext()){
            //     //update nextChild
            //     State thisChild = iterator.next();
            //     double thisUtility = materialCalculator(thisChild);
            //     if (child.player == Player.WHITE){
            //         if(thisUtility >= Utility){
            //             Utility = thisUtility;
            //         }
            //     }
            //     else if (child.player == Player.BLACK){
            //         if(thisUtility <= Utility){
            //             Utility = thisUtility;
            //         }
            //     }
                
            //}

            // private static int aStar(Location l1, Location l2, Location l3){
//     int x = Math.abs(l2.getX() - l1.getX());
//     int y = Math.abs(l2.getY() - l1.getY());
    
//     return x+y;
// }

// for (Piece queen : root.state.board){
		// 	if(queen.player == root.state.player){
		// 		if(queen.getClass() == Queen.class){
		// 			Iterator<State> queensMoves = root.state.next(queen).iterator();
		// 			while(!root.state.searchLimitReached() && queensMoves.hasNext()){
		// 				// You can get the next unexplored child node with GameTree#getNextChild().
		// 				State child = queensMoves.next();
		// 				Result childu = new Result(child, Utility.materialCalculator(child, omega));
						
			
		// 				// Find the lowest possible utility value the child node can have.
		// 				childu = findMin(childu, alpha, beta, charlie, delta, omega);
			
						
		// 				// Update 'max' based on this new information.  'max' should always hold the
		// 				// largest value we have discovered so far.
						
		// 				max = max(max, childu.utility);
			
		// 				if (max > beta){
		// 					return new Result(childu.state, max);
		// 				}
		// 				alpha = max(alpha, max);
		// 			}
				
		// 			// Return the highest utility value of all the children nodes.
					
		// 		}
		// 	}
		// }

        //gets children nodes
        //Iterator<State> iterator = root.state.next().iterator();
		//A depth of children has been breached.
		// for (Piece queen : root.state.board){
		// 	if(queen.player == root.state.player){
		// 		if(queen.getClass() == Queen.class){
		// 			Iterator<State> queensMoves = root.state.next(queen).iterator();
		// 			while(!root.state.searchLimitReached() && queensMoves.hasNext()){
		// 				// You can get the next unexplored child node with GameTree#getNextChild().
		// 				State child = queensMoves.next();
						
		// 				Result childu = new Result(child, Utility.materialCalculator(child, omega));
						
		// 				// Find the highest possible utility value the child node can have.
		// 				childu = findMax(childu, alpha, beta, charlie, delta, omega);
						
		// 				// Update 'min' based on this new information.  'min' should always hold the
		// 				// smallest value we have discovered so far.
						
		// 				min = min(min, childu.utility);
	
		// 				if(min < alpha){
		// 					return new Result(childu.state, min);
		// 				}
		// 				beta = min(beta, min);
		// 			}
		// 			// Return the lowest utility value of all the children nodes.
					
				
		// 		}
		// 	}
		// }
		
		
		// if (root.turn <= 1){
		// 	State Opener = CustomMoves.openingMove(root);
		// 	if( Opener != root ){
		// 		return Opener;
		// 	}
		// }
		//Collections.reverse(children);
		// for (Result child: children){
		// 	if(child.utility == this.value){
				
		// 			// if (child.state.turn == 1 || child.state.turn == 2){
		// 			//move middle pawn and disperse knights forward
		// 			// }
		// 			if(!child.state.board.hasMoved(child.state.board.getKing(child.state.player))){
		// 				if(child.state.movesUntilDraw > 1 ){
		// 					for(Piece piece: child.state.board){
		// 						if(piece.getClass() == Queen.class){
		// 							// if(!Target.isBeingAttacked(child.state, piece)){
		// 								return child.state;
		// 							//}
		// 						}
									
		// 					}
							
		// 					return child.state;
		// 				}
		// 			}
					
					
		// 		}
		// }
		// for (Result child: children){
		// 	if(child.utility == this.value){
					
		// 		// if (child.state.turn == 1 || child.state.turn == 2){
		// 		//move middle pawn and disperse knights forward
		// 		// }
				
		// 			if(child.state.movesUntilDraw > 1 ){
		// 				return child.state;
		// 			}
				
				
				
		// 			}
		// 		}
		
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
		// int rnd = new Random().nextInt(children.size());

		// return children.get(rnd).state;
		
		// Find a way to calculate material score of each child node
		// higher material score is a higher probability of success 
		// Choose child with max(material_score) aka Greedy Bot
		
			//Iterator<State> iterator = root.next().iterator();
		
		// while(!root.searchLimitReached() && iterator.hasNext()){
		// 	//update nextChild
		// 	State thisChild = iterator.next();
		// 	double thisUtility = Utility.materialCalculator(thisChild, omega);
		// 	Result node = new Result(thisChild, thisUtility);
        //     children.add(thisChild);
		// 	if(thisChild.over == true && thisChild.movesUntilDraw != 0){
		// 		return thisChild;
		// 	}
		// }

}
