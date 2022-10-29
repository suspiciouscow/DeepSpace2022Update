package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;

public class InTakeInOutAxis extends CommandBase2412 {
	public InTakeInOutAxis() {
		addRequirements(inTakeCargo);
	}

	public void execute() {
		System.out.println("Intake cargo axis");
		inTakeCargo.InTakeCargoAxis(Robot.m_oi.coDriverArduinoButtons, OI.MANUAL_AXIS);
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
