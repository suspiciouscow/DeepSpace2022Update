package org.usfirst.frc.team2412.robot.commands;

public class PistonsOut extends CommandBase2412 {
public PistonsOut()
{
	requires(pistonMove);
}
public void execute()
{
	pistonMove.pistonDown();
}
@Override protected boolean isFinished()
{
	return true;
}
}
