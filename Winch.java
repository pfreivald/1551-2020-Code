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
import frc.robot.subsystems.Winch_Motors;

public class Winch extends CommandBase {
  Pneumatics pneumatics = new Pneumatics();
  public final DoubleSolenoid winch_solenoid = new DoubleSolenoid(Constants.WINCH_SOLENOID_IN, Constants.WINCH_SOLENOID_OUT);
  private final Winch_Motors winch_motors;
  Joystick joystick3 = new Joystick(Constants.JOYSTICK3_ID);

  public Winch(Winch_Motors winch_motors, Pneumatics pneumatics) {
    this.winch_motors = winch_motors;
   addRequirements(winch_motors);
   addRequirements(pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    
    do {  
      double stick = joystick3.getRawAxis(1);
  winch_motors.winch(stick);
    winch_solenoid.set(DoubleSolenoid.Value.kForward);
  }  while (joystick3.getRawButton(3)); { 
    winch_solenoid.set(DoubleSolenoid.Value.kReverse);
  }
  
  

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    winch_motors.winch(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return joystick3.getRawButtonReleased(3);
  }
}
