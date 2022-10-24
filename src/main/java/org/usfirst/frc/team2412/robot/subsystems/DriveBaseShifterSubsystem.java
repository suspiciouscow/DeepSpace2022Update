package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.commands.ShiftDefaultGearCommand;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBaseShifterSubsystem extends SubsystemBase {
	// private Solenoid shifter = RobotMap.shifter;

	public DriveBaseShifterSubsystem() {
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
