package org.usfirst.frc.team2412.robot.commands;

public class PistonsIn extends CommandBase2412 {
	public PistonsIn() {
		addRequirements(pistonMove);
	}

	public void execute() {
		pistonMove.pistonUp();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
