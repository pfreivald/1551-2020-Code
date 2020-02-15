/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Pneumatics;

public class Control_Panel_Manipulator_Up_Down extends CommandBase {
  Pneumatics pneumatics = new Pneumatics();
  public final DoubleSolenoid manipulator_solenoid = new DoubleSolenoid(Constants.MANIPULATOR_SOLENOID_IN, Constants.MANIPULATOR_SOLENOID_OUT);
  private final Joystick joystick3 = new Joystick(Constants.JOYSTICK3_ID);

  /**
   * Creates a new Control_Panel_Manipulator_Up_Down.
   */
  public Control_Panel_Manipulator_Up_Down(Pneumatics pneumatics) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DoubleSolenoid.Value val = manipulator_solenoid.get();
    if(val == DoubleSolenoid.Value.kForward) {
      manipulator_solenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      manipulator_solenoid.set(DoubleSolenoid.Value.kForward);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return joystick3.getRawButtonReleased(4);
  }
}
