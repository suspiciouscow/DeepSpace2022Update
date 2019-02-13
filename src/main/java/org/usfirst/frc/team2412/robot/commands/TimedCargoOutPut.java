package org.usfirst.frc.team2412.robot.commands;

public class TimedCargoOutPut extends OutputCargo {
	
private long startTime;

protected void initialize() {
	startTime = System.nanoTime();
}
	
	@Override
	protected boolean isFinished() {
		double elapsedTime = (System.nanoTime() - startTime)/ 1E9;
		return elapsedTime > 1;
	}	
}