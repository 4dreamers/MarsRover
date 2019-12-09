package com.xingevents.marsrover.controller;

import com.xingevents.marsrover.model.Plateau;
import com.xingevents.marsrover.model.Rover;
import com.xingevents.marsrover.utils.IConstants;

public class RoverControllerImpl implements RoverController {

    private Plateau plateau;
    private Rover rover;

    public RoverControllerImpl(Plateau plateau, Rover rover) throws Exception {

        this.plateau =plateau;
        this.rover = rover;
    }

    @Override
    public void move() {
        switch (this.rover.getCompassPosition()) {
            case IConstants.NORTH:
                this.rover.setPositionY(this.rover.getPositionY() + 1);
                break;
            case IConstants.EAST:
                this.rover.setPositionX(this.rover.getPositionX() + 1);
                break;
            case IConstants.SOUTH:
                this.rover.setPositionY(this.rover.getPositionY() - 1);
                break;
            case IConstants.WEST:
                this.rover.setPositionX(this.rover.getPositionX() -1);
                break;
        }
    }

    @Override
    public void printPosition(){
        System.out.println(this.rover.getPositionX() +
                     " " + this.rover.getPositionY() +
                     " " + this.rover.getCompassPosition());
    }

    @Override
    public void turnLeft() {

        switch (this.rover.getCompassPosition()) {
            case IConstants.NORTH:
                this.rover.setCompassPosition(IConstants.WEST);
                break;
            case IConstants.EAST:
                this.rover.setCompassPosition(IConstants.NORTH);
                break;
            case IConstants.SOUTH:
                this.rover.setCompassPosition(IConstants.EAST);
                break;
            case IConstants.WEST:
                this.rover.setCompassPosition((IConstants.SOUTH));
                break;
        }
    }

    @Override
    public void turnRight() {

        switch (this.rover.getCompassPosition()) {
            case IConstants.NORTH:
                this.rover.setCompassPosition(IConstants.EAST);
                break;
            case IConstants.EAST:
                this.rover.setCompassPosition(IConstants.SOUTH);
                break;
            case IConstants.SOUTH:
                this.rover.setCompassPosition(IConstants.WEST);
                break;
            case IConstants.WEST:
                this.rover.setCompassPosition((IConstants.NORTH));
                break;
        }
    }

    public void executeCommands(String commands){
        for (int idx = 0; idx < commands.length(); idx++ ){
            processCommand(commands.charAt(idx));
        }
        printPosition();
    }

    public void processCommand(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            if(isRoverAbleToMove()) {
                move();
            }else{
                throw new ArrayIndexOutOfBoundsException(
                        "Rover will go out of bounds with this move. Execution Aborted");
            }
        } else {
            throw new IllegalArgumentException("This type of command " + command +
                    " can't be processed by the Rover. Execution Aborted!");
        }

    }

    @Override
    public boolean isRoverAbleToMove(){

        boolean moveAllowed = false;
        if(IConstants.NORTH.equals(this.rover.getCompassPosition())
                && (this.rover.getPositionY() + 1) <= this.plateau.getUpperYCorner())
            moveAllowed = true;
        if(IConstants.EAST.equals(this.rover.getCompassPosition())
                && (this.rover.getPositionX() + 1) <= this.plateau.getUpperXCorner())
            moveAllowed = true;
        if(IConstants.SOUTH.equals(this.rover.getCompassPosition())
                && (this.rover.getPositionY() - 1) >= this.plateau.getLowerYCorner())
            moveAllowed = true;
        if(IConstants.WEST.equals(this.rover.getCompassPosition())
                && (this.rover.getPositionX() - 1) >= this.plateau.getLowerXCorner())
            moveAllowed = true;

        return moveAllowed;
    }


}
