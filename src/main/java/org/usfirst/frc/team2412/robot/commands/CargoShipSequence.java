package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CargoShipSequence extends CommandGroup {
    public CargoShipSequence() {
        // addSequential(new DeployRails());
        addSequential(new GoToLevel(2, false));
        addParallel(new ClimbLiftJoystick());
    }
}