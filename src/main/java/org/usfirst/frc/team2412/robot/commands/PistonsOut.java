package org.usfirst.frc.team2412.robot.commands;

public class PistonsOut extends CommandBase2412 {
public PistonsOut()
{
	addRequirements(pistonMove);
}
public void execute()
{
	pistonMove.pistonDown();
}
@Override public boolean isFinished()
{
	return true;
}
}
