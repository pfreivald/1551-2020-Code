/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Winch_Motors extends SubsystemBase {
  private final SpeedController winch_MotorsGroup = new SpeedControllerGroup(new WPI_TalonFX(Constants.WINCH_MOTOR_1_ID), new WPI_TalonFX(Constants.WINCH_MOTOR_2_ID));
  
  

  public Winch_Motors() {

    
  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void winch(double stick){
    winch_MotorsGroup.set(stick);
  }
}
