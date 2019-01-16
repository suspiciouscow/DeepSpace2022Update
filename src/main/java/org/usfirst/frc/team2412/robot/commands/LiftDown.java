package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftDown extends CommandBase {

	public LiftDown() {
		// TODO Auto-generated constructor stub
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
