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

public class Intake_Up_Down extends CommandBase {
  Pneumatics pneumatics = new Pneumatics();
  public final DoubleSolenoid intake_solenoid = new DoubleSolenoid(Constants.INTAKE_SOLENOID_IN, Constants.INTAKE_SOLENOID_OUT);
  private final Joystick leftJoystick = new Joystick(Constants.LEFTJOYSTICK_ID);
  /**
   * Creates a new Intake_Up_Down.
   */
  public Intake_Up_Down(Pneumatics pneumatics) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DoubleSolenoid.Value val = intake_solenoid.get();
    if(val == DoubleSolenoid.Value.kForward) {
      intake_solenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      intake_solenoid.set(DoubleSolenoid.Value.kForward);
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
    return leftJoystick.getRawButtonReleased(5);
    }
}
