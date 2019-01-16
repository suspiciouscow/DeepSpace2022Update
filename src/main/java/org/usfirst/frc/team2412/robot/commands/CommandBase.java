package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {

	static LiftSubsystem liftSubsystem = new LiftSubsystem();
		
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
