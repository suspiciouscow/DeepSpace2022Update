package org.usfirst.frc.team2412.robot.commands;

public class DeployRails extends CommandBase {
	public DeployRails() {

		requires(climbPneumatics);
	}

	public void execute() {
		climbPneumatics.DeployRails();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
