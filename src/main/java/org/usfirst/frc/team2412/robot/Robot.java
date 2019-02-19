package org.usfirst.frc.team2412.robot;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2412.robot.commands.CommandBase;
import org.usfirst.frc.team2412.robot.commands.LiftBottomReset;
import org.usfirst.frc.team2412.robot.commands.LiftTopReset;
// import org.usfirst.frc.team2412.robot.sensors.I2CUpdatableAddress.NACKException;
// import org.usfirst.frc.team2412.robot.sensors.VL53L0X;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	public static OI m_oi;

	CommandBase base = new CommandBase();

	public static long startTime = 0;

	// public static DigitalOutput LED;

	// private VL53L0X lidar;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		RobotMap.liftMotors[1].follow(RobotMap.liftMotors[0]);
		Thread visionThread = new Thread(() -> {
			System.out.println("In thread");
			UsbCamera camera = new UsbCamera("Microsoft Lifecam", "/dev/video0");
			CameraServer.getInstance().addCamera(camera);
			camera.setResolution(160, 120);
			camera.setFPS(60);
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("UsbCamera", 160, 120);

			Mat mat = new Mat();

			while (!Thread.interrupted()) {
				if (cvSink.grabFrame(mat) == 0) {
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				Core.flip(mat,mat,Core.ROTATE_180);
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
		Scheduler.getInstance().run();

		// if (RobotMap.liftBottomSwitch.get() && !liftBottomResetHeld) {
		// 	liftBottomReset.execute();
		// 	liftBottomResetHeld = true;
		// } else if (!RobotMap.liftBottomSwitch.get()) {
		// 	liftBottomResetHeld = false;
		// }

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
		
		
		PowerDistributionPanel powerPanel = RobotMap.powerPanel;
		
		double[] ids = new double[15];
		double[] power = new double[15];
		
		for(int i = 0; i<15; i++) {
			ids[i] = i+1;
			power[i] = powerPanel.getCurrent(i);
		}
		
		
		SmartDashboard.putNumberArray("Amps", power);
		SmartDashboard.putNumberArray("IDs", ids);
	}

	@Override
	public void teleopPeriodic() {
		controlledPeriodic();
	}

	@Override
	public void autonomousPeriodic() {
		controlledPeriodic();
	}

}
