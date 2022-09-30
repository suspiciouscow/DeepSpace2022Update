package org.usfirst.frc.team2412.robot.commands;

public class PistonsIn extends CommandBase2412 {
	public PistonsIn() {
		requires(pistonMove);
	}

	public void execute() {
		pistonMove.pistonUp();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
