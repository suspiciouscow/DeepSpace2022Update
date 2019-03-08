package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class ShiftOtherGearCommand extends CommandBase {
	
	public ShiftOtherGearCommand() {
		requires(driveShifters);
	}
	
	@Override
	protected void execute() {
		System.out.println("Shifting to other gear...");
		if(RobotMap.CLIMB_MODE) {
			System.out.println("Not shifting to other gear in climb mode");
			// driveShifters.shiftHighGear(); // Don't allow shifting in climb mode for now.
		} else {
			driveShifters.shiftLowGear();
			System.out.println("Shifting into low gear, not in climb mode");
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
