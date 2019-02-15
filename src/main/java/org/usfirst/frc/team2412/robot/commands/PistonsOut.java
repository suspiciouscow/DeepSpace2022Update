package org.usfirst.frc.team2412.robot.commands;

public class PistonsOut extends CommandBase {
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
