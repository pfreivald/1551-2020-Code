/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Feeder_Motor;

public class Feed extends CommandBase {
  private Feeder_Motor feeder_motor;
  private Joystick rightJoystick = new Joystick(Constants.RIGHTJOYSTICK_ID);
  /**
   * Creates a new Feed.
   */
  public Feed(Feeder_Motor feeder_motor) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.feeder_motor = feeder_motor;
    addRequirements(feeder_motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.shoot_Motor.getRPM() >= Constants.RPM_VALUE) {
    feeder_motor.Run_Feeder_Motor(Constants.FEEDER_SPEED);
    }
    else if (RobotContainer.shoot_Motor.getRPM() < Constants.RPM_VALUE) {
      feeder_motor.Run_Feeder_Motor(Constants.FEEDER_STOPPED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    feeder_motor.Run_Feeder_Motor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rightJoystick.getRawButtonReleased(1);
  }
}
