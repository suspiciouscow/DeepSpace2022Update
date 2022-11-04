package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.subsystems.InTakeUpDownSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoToIntakeAngle extends CommandBase2412 {
	private double angleSetpoint = 0;
	
	public GoToIntakeAngle(double angle) {
		addRequirements(inTakeUpDown);
		angleSetpoint = angle;
	}

	public void initialize() {
		inTakeUpDown.setInputRange(0, InTakeUpDownSubsystem.MAX_ERROR);
		inTakeUpDown.setOutputRange(InTakeUpDownSubsystem.MIN_SPEED, InTakeUpDownSubsystem.MAX_SPEED);
		inTakeUpDown.setSetpoint(angleSetpoint);
		inTakeUpDown.setAbsoluteTolerance(1); // Tolerate 1 degree of error. May need to calibrate.
		
		inTakeUpDown.enable();
	}

	public void execute() {
		if(RobotMap.DEBUG_MODE) {
			SmartDashboard.putNumber("Angle setpoint", angleSetpoint);
			SmartDashboard.putNumber("Current angle", inTakeUpDown.returnPIDInput());
			SmartDashboard.putNumber("Calculated motor speed", inTakeUpDown.getController());
			System.out.println("Intake rotating to " + angleSetpoint + " degree(s)");
			System.out.println("Current angle: " + inTakeUpDown.returnPIDInput() + " degree(s)");
			System.out.println("Calculated motor speed: " + inTakeUpDown.getController().getMeasurement());
		}
	}

	public void end() {
		inTakeUpDown.disable();
	}

	@Override
	public boolean isFinished() {
		return false;
		// return inTakeUpDown.onTarget();
	}
}
