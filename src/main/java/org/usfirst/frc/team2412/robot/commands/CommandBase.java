package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.HatchIntake;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
public static HatchIntake pistonMove = new HatchIntake();
}

