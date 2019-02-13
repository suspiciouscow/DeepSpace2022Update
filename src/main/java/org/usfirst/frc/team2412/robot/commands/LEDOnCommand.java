package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class LEDOnCommand extends CommandBase {

	@Override
	protected void initialize() {
		Robot.startTime = System.nanoTime();
		Robot.LED.set(true);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}