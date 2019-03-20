package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeployRailsSequence extends CommandGroup {
    public DeployRailsSequence() {
        // addSequential(new DeployRails());
        addSequential(new GoToLevel(2, false));
        addSequential(new GoToIntakeAngle(170));
        addParallel(new ClimbRollerAxis());
        addParallel(new ClimbLiftJoystick());
    }
}