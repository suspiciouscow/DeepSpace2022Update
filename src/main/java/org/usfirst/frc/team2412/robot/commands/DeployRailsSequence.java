package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeployRailsSequence extends CommandGroup {
    public DeployRailsSequence() {
        addSequential(new DeployRails());
        addSequential(new ClimbRollerAxis());
        addSequential(new ClimbLiftJoystick());
    }
}