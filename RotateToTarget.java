/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class RotateToTarget extends CommandBase {
  private final DriveTrain driveTrain;
  private final Limelight limelight;

  /*
   * Creates a new RotateToTarget.
   */
  public RotateToTarget(DriveTrain driveTrain, Limelight limelight) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.limelight = limelight;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    //limelight.setLedMode(LightMode.eOff);

   }

  public double rotateSpeed = Constants.SEEK_SPEED;
  public double deadband = Constants.DEADBAND_RANGE;

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double target = limelight.aimbot();
    //rotate left if aimbot is negative
    if(target < deadband * -1)
      driveTrain.drive(-1 * rotateSpeed, rotateSpeed);
    else if (target > deadband)
      driveTrain.drive(rotateSpeed,-1 * rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.drive(0, 0);
    //limelight.setLedMode(LightMode.eOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double target = limelight.aimbot();
    //if the target is negative, convert to a positive number.
    if(target < 0)
      target = target * -1;
    //return true if target is less than the deadband
    return target < deadband;
  }

  
}
