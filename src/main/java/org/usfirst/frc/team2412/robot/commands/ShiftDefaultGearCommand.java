package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

/**
 * Runs by default; shifts into high gear during the beginning of the match and into low gear if the rail deployment button has been pressed.
 */
public class ShiftDefaultGearCommand extends CommandBase {
	
	public ShiftDefaultGearCommand() {
		requires(driveShifters);
	}
	
	@Override
	protected void execute() {
		System.out.println("Shifting default gear");
		if(RobotMap.CLIMB_MODE) {
			driveShifters.shiftLowGear();
			System.out.println("Default: low gear in climb");
		} else {
			driveShifters.shiftHighGear();
			System.out.println("Default: high gear, not climbing");
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
