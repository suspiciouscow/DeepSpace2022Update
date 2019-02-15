package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;

public class VisionAndDriveCommand extends CommandGroup {
	public VisionAndDriveCommand() {
		addSequential(new VisionGuidanceCommand());
		addSequential(new PrintCommand("Quitting..."));
	}
}