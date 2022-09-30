package org.usfirst.frc.team2412.robot.commands;

public class GoToHeight extends CommandBase2412 {

	private static final double MAX_ERROR = 4;

	private double height;

	public GoToHeight(double height) {
		this.height = height;
		requires(liftSubsystem);
	}

	protected boolean isFinished() {
		double error = liftSubsystem.getError();
		System.out.println("Error: " + error);
		return error < MAX_ERROR;
	}

	protected void execute() {
		liftSubsystem.goToInch(height);
	}
}
