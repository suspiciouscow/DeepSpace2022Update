package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class DeployRailsSequence extends SequentialCommandGroup {
    public DeployRailsSequence() {
        addCommands(
            new SequentialCommandGroup(
                new DeployRails(),
                new ParallelCommandGroup(
                    new ClimbRollerAxis(),
                    new ClimbLiftJoystick())));

        // addSequential(new DeployRails());
        // addParallel(new ClimbRollerAxis());
        // addParallel(new ClimbLiftJoystick());
    }
}