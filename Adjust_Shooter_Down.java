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
import frc.robot.subsystems.Adjust_Motor;

public class Adjust_Shooter_Down extends CommandBase {
  private Adjust_Motor adjust_motor;
  private final Joystick joystick3 = new Joystick(Constants.JOYSTICK3_ID);
  /**
   * Creates a new Adjust_Shooter_Down.
   */
  public Adjust_Shooter_Down(Adjust_Motor adjust_motor) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.adjust_motor = adjust_motor;
    addRequirements(adjust_motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    adjust_motor.Adjust(Constants.ADJUST_SPEED *-1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    adjust_motor.Adjust(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return joystick3.getRawButtonReleased(11);
  }
}
