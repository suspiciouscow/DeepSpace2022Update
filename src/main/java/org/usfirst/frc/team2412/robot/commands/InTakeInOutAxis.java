package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;

public class InTakeInOutAxis extends CommandBase {
	public InTakeInOutAxis() {
		requires(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.InTakeCargoAxis(Robot.m_oi.coDriver, OI.MANUAL_AXIS);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
