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
import frc.robot.subsystems.Intake_Motor;

public class Run_Intake extends CommandBase {
  private Intake_Motor intake_Motor;
  private Joystick joystick3 = new Joystick(Constants.JOYSTICK3_ID);
  private Joystick rightJoystick = new Joystick(Constants.RIGHTJOYSTICK_ID);

  public Run_Intake(Intake_Motor intake_Motor) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake_Motor = intake_Motor;
    addRequirements(intake_Motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //intake_Motor.Run_Intake_Motor(Constants.INTAKE_SPEED);
      
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (rightJoystick.getRawButtonPressed(5)){
      intake_Motor.Run_Intake_Motor(Constants.INTAKE_SPEED);
    }
    else if (joystick3.getRawButtonPressed(10)){
      intake_Motor.Run_Intake_Motor(Constants.SWEEPER_INTAKE_SPEED);
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake_Motor.Run_Intake_Motor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  

  }
}
