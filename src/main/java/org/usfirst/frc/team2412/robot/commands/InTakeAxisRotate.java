package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;

public class InTakeAxisRotate extends CommandBase {
	public InTakeAxisRotate() {
		requires(inTakeUpDown);
	}
	
	//The Initialize command initializes the counter in the above subsystem then starts the motor moving.
	//It then tests the counter value in the isFinished() method waiting for it to count the limit switch changing.
	//When it does, the arm stops.
	//By using a hardware counter, a switch that might close then open very quickly can still be caught by the program.

	public void execute() {
		System.out.println("Rotating intake axis...");
		inTakeUpDown.InTakeAxisRotate(Robot.m_oi.coDriverArduinoButtons, OI.MANUAL_AXIS);
	}

	@Override
	protected boolean isFinished() {
		// return inTakeUpDown.limitSwitchDown();
		return false;
	}

	public void end() {
		inTakeUpDown.InTakeStop();
	}
}