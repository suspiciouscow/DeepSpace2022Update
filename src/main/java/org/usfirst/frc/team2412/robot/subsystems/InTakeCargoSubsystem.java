package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class InTakeCargoSubsystem extends Subsystem{

	private WPI_TalonSRX CargoMoter1 = RobotMap.CargoMoter1;
	@Override
	protected void initDefaultCommand() {
		//Ari is Awesome!`
		//Ari is actually going to program something
	
		
	}
	public void InTakeCargo() {CargoMoter1.set(-0.5);}
	public void OutputCargo() {CargoMoter1.set(0.5);}
}
