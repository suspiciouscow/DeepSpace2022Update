package org.usfirst.frc.team2412.robot.commands;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionGuidanceCommand extends CommandBase {
    private static final int PORT = 1111;

    private DatagramSocket socket = null;
    private DatagramPacket packet;
    private byte[] receiveData = new byte[1024];

    private double angle = 0;
    private double distance = 0;
    private boolean doextake = false;
    private boolean targetsFound = false;

    // private boolean teleopHappened = false;

    private String protocol = "UDP";

    private NetworkTableInstance instance;
    private NetworkTable table;
    
    private NetworkTableEntry angleEntry;
    private NetworkTableEntry distanceEntry;
    private NetworkTableEntry doextakeEntry;
    private NetworkTableEntry targetsFoundEntry;

    public VisionGuidanceCommand() {
        requires(tempDriveBase);
    }

    @Override
    protected void initialize() {
        if(protocol.equals("NT")) {
            instance = NetworkTableInstance.getDefault();
            table = instance.getTable("datatable");

            angleEntry = table.getEntry("angle");
            distanceEntry = table.getEntry("distance");
            doextakeEntry = table.getEntry("doextake");
            targetsFoundEntry = table.getEntry("targetsFound");
        } else if(protocol.equals("UDP")) {
            try {
                socket = new DatagramSocket(PORT);
                socket.setSoTimeout(20);
            } catch(SocketException e) {
                System.err.println("Could not create socket: ");
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void execute() {
        if(protocol.equals("NT")) {
            angle = angleEntry.getDouble(0.0);
            distance = distanceEntry.getDouble(0.0);
            doextake = doextakeEntry.getBoolean(false);
            targetsFound = targetsFoundEntry.getBoolean(false);
        } else if(protocol.equals("UDP")) {
            try {
                packet = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("Receiving message...");
                socket.receive(packet);
                receiveData = packet.getData();
                String receiveString = (new String(receiveData)).trim();
                // System.out.println(receiveString.length());
                System.out.println(receiveString);
                
                // Parse the string into angle, distance, doextake, and targets found values.
                String[] visionData = receiveString.split(";");
                if(visionData.length != 4) {
                    throw new ParseException("Not the right number of values received!", visionData.length - 1);
                }
                
                 angle = Double.parseDouble(visionData[0]);
    //            distance = Double.parseDouble(visionData[1]);
                doextake = Boolean.parseBoolean(visionData[2]);
                targetsFound = Boolean.parseBoolean(visionData[3]);
                
                /*
                if(targetsFound) {
                    // angle = (Math.abs(angle) > 0.03) ? angle : 0;
                    tempDriveBase.drive(-0.4, angle);
                    System.out.println("Angle: " + angle);
                } else {
                    System.err.println("No targets found!");
                }
                */

                receiveData = new byte[1024]; // Clear the data.
            } catch(SocketTimeoutException e) {
                System.err.println("Timed out waiting for raspberry pi data.");
            } catch(Exception e) {
                System.out.println("exception happened");
            }
        }
        System.out.println("Angle: " + angle);
        System.out.println("Distance: " + distance);
        System.out.println("Doextake: " + doextake);
        System.out.println("Targets found: " + targetsFound);
    }

    @Override
    protected boolean isFinished() {
        return doextake;
    }

    @Override
    protected void end() {
        if(socket != null) {
            socket.close();
            System.out.println("Closing...");
        }
    }
}