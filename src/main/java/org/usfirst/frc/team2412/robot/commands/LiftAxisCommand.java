package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class LiftAxisCommand extends CommandBase {

	public LiftAxisCommand() {
		requires(liftSubsystem);
	}
	
	public void execute() {
		liftSubsystem.liftAxis(Robot.m_oi.coDriver.getRawAxis(Robot.m_oi.liftAxisNumber), 0, 1, 0.2, false);
	}
}
