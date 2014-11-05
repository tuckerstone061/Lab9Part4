/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author tucker.stone061
 */
public class Wolf extends Animal {

    // instance variables

    private boolean haveSeenBunny = false;
    private boolean canSeeBunnyNow = false;
    private int distanceToBunny;
    private int directionToBunny;
    private int currentDirection;
    
    /**
     * Constructs a wolf in the given model, at the given position
     * in the field.
     *
     * @param model  the model that controls this wolf.
     * @param row    the row of the field containing this wolf.
     * @param column the column of the field containing this wolf.
     */
    public Wolf(Model model, int row, int column) {
        super(model, row, column);
        currentDirection = Model.random(Model.MIN_DIRECTION,
                                        Model.MAX_DIRECTION);
    }
    
    /**
     * Controls the movement of the wolf.
     *
     * @return the direction in which the wolf wishes to move.
     */
     int decideMove() {
    
        // look all around for bunny
        canSeeBunnyNow = false;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.BUNNY) {
                canSeeBunnyNow = haveSeenBunny = true;
                directionToBunny = i;
                distanceToBunny = distance(i);
            }
        }
        
        // if bunny has been seen recently (not necessarily this time),
        // move toward its last known position
        if (haveSeenBunny) {
            if (distanceToBunny > 0) {
                distanceToBunny--;
                return directionToBunny;
            }
            else { // bunny was here--where did it go?
                haveSeenBunny = false;
                currentDirection = Model.random(Model.MIN_DIRECTION,
                                                Model.MAX_DIRECTION);
            }
        }
        
        // either haven't seen bunny, or lost track of bunny
        // continue with current direction, maybe dodging bushes
        if (canMove(currentDirection))
            return currentDirection;
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
        }
        // stuck! cannot move
        return Model.STAY;
    }
            
}

