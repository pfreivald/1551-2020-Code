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

public class Intake_Motor extends SubsystemBase {
  double intake_speed = Constants.INTAKE_SPEED;
  TalonSRX m_intake_Motor = new TalonSRX(Constants.INTAKE_MOTOR_ID);
    /**
   * Creates a new Intake_Motor.
   */
  public Intake_Motor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Run_Intake_Motor(double intake_speed){
    m_intake_Motor.set(ControlMode.PercentOutput, intake_speed);
  }
}
