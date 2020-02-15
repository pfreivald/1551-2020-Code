/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should  
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer { 
 private final DriveTrain m_drivetrain = new DriveTrain();
 private final Pneumatics pneumatics = new Pneumatics();
 private final Adjust_Motor adjust_motor = new Adjust_Motor();
 private final Intake_Motor intake_Motor = new Intake_Motor();
 private final Winch_Motors winch_motors = new Winch_Motors();
 public final static Feeder_Motor feeder_motor = new Feeder_Motor();
 private final Control_Panel_Motor control_panel_motor = new Control_Panel_Motor();
 private final Joystick leftJoystick = new Joystick(Constants.LEFTJOYSTICK_ID);
  private final Joystick rightJoystick = new Joystick(Constants.RIGHTJOYSTICK_ID);
  private final Joystick joystick3 = new Joystick(Constants.JOYSTICK3_ID);

  private final TankDrive m_autoCommand = new TankDrive(null, null, m_drivetrain);
  private final Adjust_Shooter_Up adjust_shooter_up = new Adjust_Shooter_Up(adjust_motor);
  private final Intake_Up_Down intake_up_down = new Intake_Up_Down(pneumatics);
  private final Lift_Up_Down lift_up_down = new Lift_Up_Down(pneumatics);
  //private final Winch_Lock_Unlock winch_lock_unlock = new Winch_Lock_Unlock(pneumatics);
  private final Control_Panel_Manipulator_Up_Down control_panel_manipulator_up_down = new Control_Panel_Manipulator_Up_Down(
      pneumatics);
  private final Run_Intake run_Intake = new Run_Intake(intake_Motor);
  private final ShooterStop shooterStop = new ShooterStop(shoot_Motor);
  //private final Run_Intake_Out run_Intake_Out = new Run_Intake_Out(intake_Motor);
  private final Adjust_Shooter_Down adjust_shooter_down = new Adjust_Shooter_Down(adjust_motor);
   //public final Shoot m_shoot = new Shoot(null);
  public final Winch winch = new Winch(winch_motors, pneumatics);
  public final Limelight m_Limelight = new Limelight();
  public static final Shoot_Motor shoot_Motor = new Shoot_Motor();
  public final Control_Panel_Rotate_1 m_control_panel_rotate_1 = new Control_Panel_Rotate_1(control_panel_motor);
  public final Control_Panel_Rotate_2 m_control_panel_rotate_2 = new Control_Panel_Rotate_2(control_panel_motor);
 // public final Pneumatics pneumatics = new Pneumatics();
//+IF YOU DELETE THIS ^^^ I WILL STEAL YOUR KNEECAPS+
//public final DoubleSolenoid solenoid1 = new DoubleSolenoid(Constants.SOLENOID_IN_ID, Constants.SOLENOID_OUT_ID);
//public static final int kSolenoidButton = 2;
//public static final int kDoubleSolenoidForward = 2;
//public static final int kDoubleSolenoidReverse = 3;
  
  public class Limeiight {
    public static final double camera_height = 1; // units are in feet
    public static final double camera_angle = 0;
  } // degrees from horizon - positive is up, negative is dow

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    //pneumatics = new Pneumatics(PCM_CANID);
    m_drivetrain.setDefaultCommand(
        new TankDrive(() -> -leftJoystick.getRawAxis(Constants.LEFT_TRIGGER_BUTTON_ID), () -> -rightJoystick.getRawAxis(Constants.LEFT_TRIGGER_BUTTON_ID), m_drivetrain));
      
    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_drivetrain);

    SmartDashboard.putData(new RotateToTarget(m_drivetrain, m_Limelight));
    // call log method on all subsystems
    m_drivetrain.log();

    //solenoid1.set(rightJoystick.getRawButton(kSolenoidButton));

   
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton rightTriggerButton = new JoystickButton(rightJoystick, 1);
    final JoystickButton leftTriggerButton = new JoystickButton(leftJoystick,1);
    final JoystickButton leftButton5 = new JoystickButton(leftJoystick, 5);
    final JoystickButton joystick3Button5 = new JoystickButton(joystick3, 5);
    //final JoystickButton joystick3Button6 = new JoystickButton(joystick3, 6);
    final JoystickButton joystick3Button4 = new JoystickButton(joystick3,4);
    final JoystickButton joystick3Button12 = new JoystickButton(joystick3,12);
    final JoystickButton joystick3Button11 = new JoystickButton(joystick3, 11);
    final JoystickButton rightButton5 = new JoystickButton(rightJoystick, 5);
    final JoystickButton joystick3Button10 = new JoystickButton(joystick3, 10);
    final JoystickButton joystick3Button3 = new JoystickButton(joystick3, 3);
    final JoystickButton joystick3Button7 = new JoystickButton(joystick3,7);
    final JoystickButton joystick3Button8 = new JoystickButton(joystick3,8);
    //rightTriggerButton.toggleWhenPressed(new RotateToTarget(m_drivetrain, m_Limelight));
//rightThumbButton.whenPressed(new Fire_Solenoid1(pneumatics));    
rightTriggerButton.whileHeld(new Shoot_Motor_Command_Group(m_drivetrain, m_Limelight, shoot_Motor, feeder_motor));
leftTriggerButton.whenPressed(shooterStop);
joystick3Button12.whileHeld(adjust_shooter_up);
leftButton5.whenPressed(intake_up_down);
joystick3Button5.whenPressed(lift_up_down);
//joystick3Button3.whileHeld(new CG_RunWinchMotorAndLock(pneumatics, winch_motors));
joystick3Button4.whenPressed(control_panel_manipulator_up_down);
joystick3Button11.whileHeld(adjust_shooter_down);
rightButton5.whileHeld(run_Intake);
joystick3Button10.whileHeld(run_Intake);
joystick3Button7.whileHeld(m_control_panel_rotate_1);
joystick3Button8.whileHeld(m_control_panel_rotate_2);
joystick3Button3.whileHeld(winch);



    System.out.println("configurebuttonbindings");
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

}