package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.commands.CommandBase2412;

public class CargoShipSequence extends CommandBase2412 {
    public CargoShipSequence() {
        // addSequential(new DeployRails());
        addSequentialGroup(new GoToLevel(2, false));
        addParallel(new ClimbLiftJoystick());
    }
}