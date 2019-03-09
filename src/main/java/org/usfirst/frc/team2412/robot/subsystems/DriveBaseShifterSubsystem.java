package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.commands.ShiftDefaultGearCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBaseShifterSubsystem extends Subsystem {
	// private Solenoid shifter = RobotMap.shifter;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShiftDefaultGearCommand());
	}
	//For shifting into high gear
	public void shiftHighGear() {
		// shifter.set(false);
	}
	//For shifting into low gear
	public void shiftLowGear() {
		// shifter.set(true);
	}
}
