/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */

public class Limelight extends SubsystemBase {
	private static NetworkTableInstance table = null;
	private static Limelight instance;
	private static Object mutex = new Object();

	public static Limelight getInstance() {
		//System.out.println("Limelight getInstnce");
		Limelight result = instance;
		if (result == null)
			;
		{
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new Limelight();
			}
		}
		return result;
	}

	double[] data, angles;
	boolean isHighRes = false;
	private NetworkTable smartDashboard;
	public PipelinePreset mCurrentPipeline;
	private static final PipelinePreset kDefaultPreset = PipelinePreset.k2dVision;
	private static final int kDefaultPipeline = 1;
	NetworkTable netTable = NetworkTableInstance.getDefault().getTable("limelight");
	// NetworkTableEntry tx = netTable.getEntry("tx");

	// double x = tx.getDouble(0.0);

	// private static final VisionTarget TopScore = VisionTarget.getTopScor();

	public Limelight() {
		//System.out.println("public Limelight");
		// this.table = NetworkTableInstance.getDefault().getTable("limelight");
		this.setPipeline(kDefaultPreset);
		smartDashboard = NetworkTableInstance.getDefault().getTable("SmartDashboard");
		smartDashboard.getEntry("Desired Vision Pipleine").setNumber(kDefaultPipeline);
		smartDashboard.addEntryListener("Desired Vision Pipeline", (smartDashboard, key, entry, value, flabs) -> {
			setPipeline((int) value.getDouble());
			System.out.println("Value changed! it's now " + (int) value.getDouble());
		}, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

		netTable.getEntry("stream").setNumber(2);

		
	}
	public static enum LightMode {
			eOn, eOff, eBlink
		}

	public void setLedMode(LightMode mode) {
	getValue("ledMode").setNumber(mode.ordinal());
		}

	public double aimbot() {
		//System.out.println("aimbot");
		float kp = -1f;
		float minCommand = .05f;
		float steeringAdjust = 0.5f;

		float tx = (float) NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
		float headingError = -tx;
	
		if (tx > 1) {
			steeringAdjust = kp * headingError - minCommand;
		} else if (tx < 1) {
			steeringAdjust = kp * headingError + minCommand;
		}
		return steeringAdjust;
	}

	public double[] getData() {
		//System.out.println("getData");
		NetworkTableEntry tx = netTable.getEntry("tx");

		double[] data = new double[1];

		data[0] = tx.getDouble(0);
		return data;
	}

	public enum PipelinePreset {
		kDefault(2), k2dVision(1), k3dVision(0);

		private int id;

		private static PipelinePreset[] values = null;

		public static PipelinePreset fromID(int i) {
			if (PipelinePreset.values() == null) {
				PipelinePreset.values = PipelinePreset.values();
			}
			return PipelinePreset.values[i];
		}

		private PipelinePreset(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	/**
	 * Set the pipeline of the limelight
	 */
	public void setPipeline(PipelinePreset req_) {
		System.out.println("setPipeline void preset req_");
		netTable.getEntry("pipeline").setNumber(req_.getId());
		this.mCurrentPipeline = req_;
		if (req_.name().contains("3d")) {
			this.isHighRes = true;
		} else {
			this.isHighRes = false;
		}
	}

	public void setPipeline(int req_) {
		System.out.println("setPipeline int");
		if (req_ > PipelinePreset.values().length - 1)
			return;
		PipelinePreset _req_ = PipelinePreset.values()[req_];
		this.mCurrentPipeline = _req_;
		setPipeline(_req_);
	}

	public int getPipeline() {
		System.out.println("getPipeline");
		return netTable.getEntry("pipeline").getNumber(0).intValue();
	}

	/**
	 * Get the area of the tracked target as a percentage from 0% to 100%
	 * 
	 * @return area as percentage of total area
	 */
	public double getTargetArea() {
		//System.out.println("getTargetArea");
		return (netTable.getEntry("ta")).getDouble(0);
	}

	/**
	 * Get the dx from crosshair to tracked target
	 * 
	 * @return skew from -90 to 0 degrees
	 */
	public double getTargetSkew() {
		//System.out.println("getTargetSkew");
		return (netTable.getEntry("ts")).getDouble(0);
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("GetTargetArea", getTargetArea());
		SmartDashboard.putNumber("GetTargetSkew", getTargetSkew());
		SmartDashboard.putNumber("aimbot", aimbot());
		// This method will be called once per scheduler run
	}

	private static NetworkTableEntry getValue(String key) {
		if (table == null) {
			table = NetworkTableInstance.getDefault();
		}

		return table.getTable("limelight").getEntry(key);
	}

}
