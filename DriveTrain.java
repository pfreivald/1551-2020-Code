/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  //TalonSRX m_frontLeft= new TalonSRX(Constants.LEFT_MOTOR_1);
  //TalonSRX m_rearLeft= new TalonSRX(Constants.LEFT_MOTOR_2);
  //SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  //TalonSRX m_frontRight= new TalonSRX(Constants.RIGHT_MOTOR_1);
  //TalonSRX m_rearRight= new TalonSRX(Constants.RIGHT_MOTOR_2);
  //SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

  private final SpeedController m_leftMotorGroup = new SpeedControllerGroup(new WPI_TalonFX(Constants.LEFT_MOTOR_1), new WPI_TalonFX(Constants.LEFT_MOTOR_2));
  private final SpeedController m_rightMotorGroup = new SpeedControllerGroup(new WPI_TalonFX(Constants.RIGHT_MOTOR_1), new WPI_TalonFX(Constants.RIGHT_MOTOR_2));
  
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);

  public DriveTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double leftspeed, double rightspeed) {
    m_drive.tankDrive(leftspeed,rightspeed);
    SmartDashboard.putNumber("leftspeed", leftspeed);
    SmartDashboard.putNumber("rightspeed", rightspeed);
}

public void log(){

}
}
