package com.xingevents.marsrover.controller;

import com.xingevents.marsrover.model.Plateau;
import com.xingevents.marsrover.model.Rover;

public interface RoverController {

    public void move();
    public void printPosition();
    public void turnLeft();
    public void turnRight();
    public boolean isRoverAbleToMove();
    public void executeCommands(String movingInstructions);
}
