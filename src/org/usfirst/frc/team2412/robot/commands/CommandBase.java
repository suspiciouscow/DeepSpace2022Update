package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CommandBase extends Command {

	public CommandBase() {
		// TODO Auto-generated constructor stub
	}

	public CommandBase(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public CommandBase(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public CommandBase(Subsystem subsystem) {
		super(subsystem);
		// TODO Auto-generated constructor stub
	}

	public CommandBase(String name, Subsystem subsystem) {
		super(name, subsystem);
		// TODO Auto-generated constructor stub
	}

	public CommandBase(double timeout, Subsystem subsystem) {
		super(timeout, subsystem);
		// TODO Auto-generated constructor stub
	}

	public CommandBase(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	public CommandBase(String name, double timeout, Subsystem subsystem) {
		super(name, timeout, subsystem);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
