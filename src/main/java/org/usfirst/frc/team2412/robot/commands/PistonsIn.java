package org.usfirst.frc.team2412.robot.commands;

public class PistonsIn extends CommandBase {
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
