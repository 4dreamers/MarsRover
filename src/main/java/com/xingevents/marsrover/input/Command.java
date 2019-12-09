package com.xingevents.marsrover.input;

import com.xingevents.marsrover.controller.RoverController;
import com.xingevents.marsrover.controller.RoverControllerImpl;
import com.xingevents.marsrover.model.Plateau;
import com.xingevents.marsrover.model.Rover;

import java.util.Scanner;

public class Command {

    public static Plateau plateau = null;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int plateauUpperCornerX = scanner.nextInt();
        int plateauUpperCornerY = scanner.nextInt();
        plateau = new Plateau(plateauUpperCornerX,
                              plateauUpperCornerY);
        while(true){
            int roverPositionX = scanner.nextInt();
            int roverPositionY = scanner.nextInt();
            char roverCompassPosition = scanner.next().charAt(0);
            Rover rover = new Rover(roverPositionX,
                                    roverPositionY,
                                    Character.toString(roverCompassPosition));
            String movingInstructions = scanner.next();
            RoverController roverController = new RoverControllerImpl(plateau, rover);
            roverController.executeCommands(movingInstructions);
        }

    }
}
