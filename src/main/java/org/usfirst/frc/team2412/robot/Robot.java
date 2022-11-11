package org.usfirst.frc.team2412.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2412.robot.commands.CommandBase2412;
import org.usfirst.frc.team2412.robot.commands.HoldCargo;
import org.usfirst.frc.team2412.robot.commands.LiftBottomReset;
import org.usfirst.frc.team2412.robot.commands.LiftTopReset;

import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	public static OI m_oi;

	CommandBase2412 base = new CommandBase2412();

	public static long startTime = 0;

	public HoldCargo holdCargo = null;

	// public static DigitalOutput LED;

	// private VL53L0X lidar;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		// RobotMap.liftMotors[1].follow(RobotMap.liftMotors[0]);
		Thread visionThread = new Thread(() -> {
			System.out.println("In thread");
			UsbCamera camera = new UsbCamera("Microsoft Lifecam", "/dev/video0");
			CameraServer.addCamera(camera);
			camera.setResolution(160, 120);
			camera.setFPS(30);
			CvSink cvSink = CameraServer.getVideo();
			CvSource outputStream = CameraServer.putVideo("UsbCamera", 160, 120);

			Mat mat = new Mat();

			while (!Thread.interrupted()) {
				if (cvSink.grabFrame(mat) == 0) {
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				// Core.flip(mat,mat,Core.ROTATE_180);
				Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY);
				outputStream.putFrame(mat);
			}
		});
		visionThread.setDaemon(true);
		visionThread.start();
		// LED = new DigitalOutput(0);
		// LED.set(false);

		/*try {
			lidar = new VL53L0X(0);
			System.out.println("Initializing...");
			boolean success = lidar.init(true);
			System.out.println(success);
		} catch (NACKException e) {
			e.printStackTrace();
		}*/
	}

	LiftBottomReset liftBottomReset = new LiftBottomReset();
	boolean liftBottomResetHeld = false;
	LiftTopReset liftTopReset = new LiftTopReset();
	boolean liftTopResetHeld = false;

	// Called periodically in sandstorm or teleop.
	public void controlledPeriodic() {
		CommandScheduler.getInstance().run();

		RobotMap.SAFE_MODE = !m_oi.stick.getRawButton(4);

		
		if (RobotMap.liftBottomSwitch.get() && !liftBottomResetHeld) {
			liftBottomReset.execute();
			liftBottomResetHeld = true;
		} else if (!RobotMap.liftBottomSwitch.get()) {
			liftBottomResetHeld = false;
		}

		// if (RobotMap.liftTopSwitch.get() && !liftTopResetHeld) {
		// 	liftTopReset.execute();
		// 	liftTopResetHeld = true;
		// } else if (!RobotMap.liftTopSwitch.get()) {
		// 	liftTopResetHeld = false;
		// }

		/*
		try {
			System.out.println("Range: " + lidar.readRangeSingleMillimeters());
			// byte[] data = new byte[1];
			// lidar.read(0xC0, 1, data);
			// System.out.println("Data: " + Byte.toString(data[0], 16));
			// byte[] expected = new byte[1];
			// expected[0] = (byte) 0xEE;
			// System.out.println("Verified? " + lidar.verifySensor(0xC0, 1, expected));
		} catch (NACKException e) {
			e.printStackTrace();
		}*/
		
		
		PowerDistribution powerPanel = RobotMap.powerPanel;
		powerPanel.clearStickyFaults();   
		
		double[] ids = new double[15];
		double[] power = new double[15];
		
		
		
		SmartDashboard.putNumberArray("Amps", power);
		SmartDashboard.putNumberArray("IDs", ids);
		System.out.println("Motor Speed: "+ RobotMap.liftMotors[0].getEncoder().getVelocity());
	}
	
	@Override
	public void teleopInit() {
		RobotMap.CLIMB_MODE = false;
	}

	@Override
	public void teleopPeriodic() {
		controlledPeriodic();
	}

	@Override
	public void autonomousInit() {
		holdCargo = new HoldCargo();
		// holdCargo.start();
		holdCargo.schedule();
		RobotMap.CLIMB_MODE = false;
	}

	@Override
	public void autonomousPeriodic() {
		controlledPeriodic();
	}

	@Override
	public void disabledInit() {
		if(holdCargo != null) {
			holdCargo.cancel();
			holdCargo = null;
		}
		CommandBase2412.inTakeUpDown.disable();
	}

}
