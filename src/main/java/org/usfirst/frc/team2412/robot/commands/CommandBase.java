package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.ClimbPneumaticsSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbRollerSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeCargoSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeHatchSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeUpDownSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	public static InTakeUpDownSubsystem InTakeUpDown = new InTakeUpDownSubsystem();
	public static InTakeCargoSubsystem InTakeCargo = new InTakeCargoSubsystem();
	public static InTakeHatchSubsystem InTakeHatch = new InTakeHatchSubsystem();
	public static ClimbPneumaticsSubsystem ClimbPneumatics = new ClimbPneumaticsSubsystem();
	public static ClimbRollerSubsystem ClimbRoller = new ClimbRollerSubsystem();
}