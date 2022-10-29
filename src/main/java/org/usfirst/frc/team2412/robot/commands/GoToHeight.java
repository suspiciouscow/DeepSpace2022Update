package org.usfirst.frc.team2412.robot.commands;

public class GoToHeight extends CommandBase2412 {

	private static final double MAX_ERROR = 4;

	private double height;

	public GoToHeight(double height) {
		this.height = height;
		addRequirements(liftSubsystem);
	}

	public boolean isFinished() {
		double error = liftSubsystem.getError();
		System.out.println("Error: " + error);
		return error < MAX_ERROR;
	}

	public void execute() {
		liftSubsystem.goToInch(height);
	}
}
