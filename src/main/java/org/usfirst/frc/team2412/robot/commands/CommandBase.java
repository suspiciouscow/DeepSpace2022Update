package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.ClimbLiftSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbPneumaticsSubsystem;
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
	
	public static InTakeUpDownSubsystem inTakeUpDown = new InTakeUpDownSubsystem();
	public static InTakeCargoSubsystem inTakeCargo = new InTakeCargoSubsystem();
	public static InTakeHatchSubsystem inTakeHatch = new InTakeHatchSubsystem();
	public static ClimbPneumaticsSubsystem climbPneumatics = new ClimbPneumaticsSubsystem();
	public static ClimbRollerSubsystem climbRoller = new ClimbRollerSubsystem();
	public static ClimbLiftSubsystem climbLift = new ClimbLiftSubsystem();
}