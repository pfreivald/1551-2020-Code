/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder_Motor extends SubsystemBase {
  double feeder_speed = Constants.FEEDER_SPEED;
  TalonSRX m_feeder_motor = new TalonSRX(Constants.FEEDER_MOTOR_ID);
    /**
   * Creates a new Intake_Motor.
   */
  public Feeder_Motor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Run_Feeder_Motor(double feeder_speed){
    m_feeder_motor.set(ControlMode.PercentOutput, feeder_speed);
  }
}
