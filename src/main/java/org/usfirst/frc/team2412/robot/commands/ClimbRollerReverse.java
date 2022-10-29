package org.usfirst.frc.team2412.robot.commands;
import org.usfirst.frc.team2412.robot.subsystems.ClimbRollerSubsystem;

public class ClimbRollerReverse extends CommandBase2412 {

	private final ClimbRollerSubsystem climbRollerSubsystem;

	public ClimbRollerReverse() {
		addRequirements(climbRoller);
	}

	public void execute() {
		climbRoller.ClimbRollerReverese();
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	public void end() {
		climbRoller.ClimbRollerStop();
	}
}