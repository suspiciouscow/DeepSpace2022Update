package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.commands.ShiftLowGearCommand;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBaseShifterSubsystem extends Subsystem {
	private Solenoid shifter = RobotMap.shifter;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShiftLowGearCommand());
	}
	//For shifting into high gear
	public void shiftHighGear() {
		shifter.set(false);
	}
	//For shifting into low gear
	public void shiftLowGear() {
		shifter.set(true);
	}
}
