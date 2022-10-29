package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class TimeLatencyCommand extends SequentialCommandGroup {
	public TimeLatencyCommand() {
		// addSequential(new LEDOnCommand());
		new SequentialCommandGroup(new VisionGuidanceCommand());
	}
}