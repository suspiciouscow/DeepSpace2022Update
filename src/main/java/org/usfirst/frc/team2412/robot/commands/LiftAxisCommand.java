package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;

public class LiftAxisCommand extends CommandBase {

	public LiftAxisCommand() {
		requires(liftSubsystem);
	}
	 
	public void execute() {
		// liftSubsystem.liftAxisPID(Robot.m_oi.coDriverArduinoButtons.getRawAxis(OI.MANUAL_AXIS), 0, 1, 0.2, false);
		liftSubsystem.liftAxis(Robot.m_oi.coDriverArduinoButtons.getRawAxis(OI.MANUAL_AXIS));
	}

	protected void end() {
		liftSubsystem.liftStop();
	}
}
