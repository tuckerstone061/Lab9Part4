/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author tucker.stone061
 */

public class Bunny extends Animal {
    
    private int currentDirection;
    
    int flop = -1;

    public Bunny(Model model, int row, int column) {
        super(model, row, column);
        currentDirection = random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
    }
    
    @Override
    int decideMove() {
        flop *=-1; // more diverse movement
        switch (flop) {
            case 1:
                for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
                    if (look(i) == Model.WOLF) { // f see wolf
                        if (distance(i) < 5) // if wolf is close
                            if (canMove(-i)) // if can move opposite wolf do it
                                currentDirection = Model.turn(currentDirection, -1);
                            else // else turn
                                currentDirection = Model.turn(currentDirection, 2);
                    }
                    else if (look(i) == Model.BUSH) { // if see bush
                        if (distance(i) < 2) // change dir
                            currentDirection = Model.random(Model.S, Model.NW);   
                    }
                    else if (look(i) == Model.EDGE) { // if see edge
                        if (distance(i) < 2) // change dir
                            currentDirection = Model.random(Model.N, Model.S);
                    }
                }
                break;
            case -1: 
                for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
                    if (look(i) == Model.WOLF) { // f see wolf
                        if (distance(i) < 5) // if wolf is close
                            if (canMove(-i)) // if can move opposite wolf do it
                                currentDirection = Model.turn(currentDirection, -2);
                            else // else turn
                                currentDirection = Model.turn(currentDirection, 2);
                    }
                    else if (look(i) == Model.BUSH) { // if see bush
                        if (distance(i) < 2) // change dir
                            currentDirection = Model.random(Model.N, Model.E);   
                    }
                    else if (look(i) == Model.EDGE) { // if see edge
                        if (distance(i) < 2) // change dir
                            currentDirection = Model.random(Model.SE, Model.NW);
                    }
                }
                break;
        }
        /*if (haveSeenWolf) {
            if (canMove(-directionToWolf)) {
                currentDirection = -directionToWolf;
                return currentDirection;
            }
        }*/
        
 
        
        
        
        if (canMove(currentDirection))
            return currentDirection;/*
        else if (canMove(Model.turn(currentDirection, 1)))
            return Model.turn(currentDirection, 1);
        else if (canMove(Model.turn(currentDirection, -1)))
            return Model.turn(currentDirection, -1);
        else {
            currentDirection = Model.random(Model.MIN_DIRECTION,
                                            Model.MAX_DIRECTION);
            for (int i = 0; i < 8; i++) {
                if (canMove(currentDirection))
                    return currentDirection;
                else
                    currentDirection = Model.turn(currentDirection, 1);
            }
        }*/
        return currentDirection *= -1;
    }
}



