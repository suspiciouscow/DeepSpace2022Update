package org.usfirst.frc.team2412.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {

	public static int[] liftMotorIndexes = { 0, 1 };

	public static CANSparkMax[] liftMotors = { new CANSparkMax(liftMotorIndexes[0], MotorType.kBrushless),
			new CANSparkMax(liftMotorIndexes[1], MotorType.kBrushless) };

	public static DigitalInput liftBottomSwitch = new DigitalInput(0);
	public static DigitalInput liftTopSwitch = new DigitalInput(1);

	public static DoubleSolenoid brakeSolenoid = new DoubleSolenoid(1, 0);
}
