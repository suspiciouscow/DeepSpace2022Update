package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftUp extends CommandBase {

	public LiftUp() {
		// TODO Auto-generated constructor stub
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
