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
import frc.robot.subsystems.Control_Panel_Motor;

public class Control_Panel_Rotate_1 extends CommandBase {
  private Control_Panel_Motor control_panel_motor;
  private final Joystick joystick3 = new Joystick(Constants.JOYSTICK3_ID);
  /**
   * Creates a new Control_Panel_Rotate_1.
   */
  public Control_Panel_Rotate_1(Control_Panel_Motor control_panel_motor) {
    this.control_panel_motor = control_panel_motor;
    addRequirements(control_panel_motor);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    control_panel_motor.Rotate(Constants.ROTATE_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    control_panel_motor.Rotate(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return joystick3.getRawButtonReleased(Constants.JOYSTICK3_BUTTON_7);
  }
}
