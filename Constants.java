/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	public static final int LEFTJOYSTICK_ID = 2;
	public static final int RIGHTJOYSTICK_ID = 1;
	public static final int JOYSTICK3_ID = 0;
	

	public static final int LEFT_MOTOR_1 = 12;
	public static final int LEFT_MOTOR_2 = 13;
	public static final int RIGHT_MOTOR_1 = 14;
	public static final int RIGHT_MOTOR_2 = 15;
	public static final int CPM_MOTOR_ID = 9;
	public static final int FEEDER_MOTOR_ID = 8;
	public static final int SHOOT_MOTOR_1_ID = 1;
	public static final int SHOOT_MOTOR_2_ID = 0;
	public static final int ADJUSTMENT_MOTOR_ID = 11;
	public static final int INTAKE_MOTOR_ID = 10;
	public static final int WINCH_MOTOR_1_ID = 2;
	public static final int WINCH_MOTOR_2_ID = 3;
	public static final int CONTROL_PANEL_MOTOR_ID = 9;

	public static final double SHOOT_SPEED = .75;
	public static final double SEEK_SPEED = .5;
	public static final double DEADBAND_RANGE = .1;
	public static final double ADJUST_SPEED = .7;
	public static final double FEEDER_SPEED = .75;
	public static final double FEEDER_STOPPED = 0;
	public static final double INTAKE_SPEED = 1;
	public static final double SWEEPER_INTAKE_SPEED = -1;
	public static final double ROTATE_SPEED = .6;

	public static final int PCM_ID = 0;
	public static final int INTAKE_SOLENOID_IN = 0;
	public static final int INTAKE_SOLENOID_OUT = 1;
	public static final int LIFT_SOLENOID_IN = 3;
	public static final int LIFT_SOLENOID_OUT = 2;
	public static final int MANIPULATOR_SOLENOID_IN = 5;
	public static final int MANIPULATOR_SOLENOID_OUT = 4;
	public static final int WINCH_SOLENOID_IN = 7;
	public static final int WINCH_SOLENOID_OUT = 6;
	
	public static final int JOYSTICK3_BUTTON_7 = 7;
	public static final int LEFT_TRIGGER_BUTTON_ID = 1;
	public static final int JOYSTICK3_BUTTON_8 = 8;
	
	public static final double SHOOTER_P = 0.6;
	public static final double SHOOTER_I = 0;
	public static final double SHOOTER_D = 3;
	public static final double SHOOTER_F = 0.047;
	public static final double RPM_VALUE = 6000;
	public static final int SHOOTER_PULSES_PER_ROTATION = 1024;
	
	
	
	
}
