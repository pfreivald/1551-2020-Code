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

public class Adjust_Motor extends SubsystemBase {
  double adjust_speed = Constants.ADJUST_SPEED;
  TalonSRX m_adjust_motor = new TalonSRX(Constants.ADJUSTMENT_MOTOR_ID);
    /**
   * Creates a new Adjust_Motor.
   */
  public Adjust_Motor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Adjust(double adjust_speed) {
    m_adjust_motor.set(ControlMode.PercentOutput, adjust_speed);
  }
}
