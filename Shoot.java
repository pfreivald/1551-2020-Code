/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
//import frc.robot.subsystems.*;

public class Shoot extends CommandBase {
  //private Shoot_Motor shoot_motor;
  double rpm = 0;
    private final Joystick rightJoystick = new Joystick(Constants.RIGHTJOYSTICK_ID);
   
    public Shoot(double rpm) {
      addRequirements(RobotContainer.shoot_Motor);
      this.rpm = rpm;
      
      // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      RobotContainer.shoot_Motor.setRampRate(true);
      System.out.println("===================");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//        RobotContainer.shooter.set(ControlMode.PercentOutput, 0.57);
         RobotContainer.shoot_Motor.set(ControlMode.Velocity,rpm /10 /60 * Constants.SHOOTER_PULSES_PER_ROTATION);
      System.out.println("shooter," + rpm + "," + RobotContainer.shoot_Motor.getRPM());

      if (RobotContainer.shoot_Motor.getRPM() > 1500){
          RobotContainer.shoot_Motor.setRampRate(false);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      RobotContainer.shoot_Motor.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return rightJoystick.getRawButtonReleased(1);
      }
}
