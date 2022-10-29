package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftAxisCommand extends CommandBase2412 {

	public LiftAxisCommand() {
		addRequirements(liftSubsystem);
	}
	 
	public void execute() {
		// liftSubsystem.liftAxisPID(Robot.m_oi.coDriverArduinoButtons.getRawAxis(OI.MANUAL_AXIS), 0, 1, 0.2, false);
		liftSubsystem.liftAxis(Math.pow(Robot.m_oi.coDriverArduinoButtons.getRawAxis(OI.MANUAL_AXIS),3));
		SmartDashboard.putNumber("Lift position (rotations)", liftSubsystem.getPosition());
		System.out.println("Lifting with joystick axis...");
	}

	public void end() {
		liftSubsystem.liftStop();
	}
}
