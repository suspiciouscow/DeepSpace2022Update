package org.usfirst.frc.team2412.robot.commands;
import org.usfirst.frc.team2412.robot.subsystems.ClimbRollerSubsystem;

public class ClimbRollerForward extends CommandBase2412 {

	public ClimbRollerForward() {
		addRequirements(climbRoller);
	}

	public void execute() {
		climbRoller.ClimbRollerForward();
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	public void end() {
		climbRoller.ClimbRollerStop();
	}
}