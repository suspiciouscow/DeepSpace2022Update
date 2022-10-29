package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;

public class VisionAndDriveCommand extends SequentialCommandGroup {
	public VisionAndDriveCommand() {

		addCommands(
			new VisionGuidanceCommand(), 
			new PrintCommand("Quitting..."));

		// addSequential(new VisionGuidanceCommand());
		// addSequential(new PrintCommand("Quitting..."));
	}
}