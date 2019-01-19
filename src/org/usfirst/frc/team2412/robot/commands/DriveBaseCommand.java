package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class DriveBaseCommand extends CommandBase {

	DriveBaseCommand(){
		requires(driveBaseSubsystem);
	}
	
	protected void execute() {
		driveBaseSubsystem.drive(RobotMap.stick);
	}
	
}
