package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RetractRailsSequence extends CommandGroup {
    public RetractRailsSequence() {
        addSequential(new OpenLatch());
        addSequential(new WaitCommand(1));
        addSequential(new RetractRails());
    }
}