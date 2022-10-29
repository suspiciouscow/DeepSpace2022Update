package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.commands.CommandBase2412;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class CargoShipSequence extends CommandBase2412 {
    public CargoShipSequence() {
        // addSequential(new DeployRails());

        new SequentialCommandGroup(
            new DeployRails(),
            new GoToLevel(2, false),
            new ParallelCommandGroup(new ClimbLiftJoystick()));
        // addSequentialGroup(new GoToLevel(2, false));
        // addParallelGroup(new ClimbLiftJoystick());
    }
}