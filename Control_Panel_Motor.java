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

public class Control_Panel_Motor extends SubsystemBase {
  double rotate_speed = Constants.ROTATE_SPEED;
  TalonSRX m_control_panel_motor = new TalonSRX(Constants.CONTROL_PANEL_MOTOR_ID);
  /**
   * Creates a new Control_Panel_Motor.
   */
  public Control_Panel_Motor() {
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void Rotate(double rotate_speed) {
  m_control_panel_motor.set(ControlMode.PercentOutput, rotate_speed);
  }
}
