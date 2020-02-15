/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Feeder_Motor;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shoot_Motor;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Shoot_Motor_Command_Group extends SequentialCommandGroup {
  /**
   * Creates a new Shoot_Motor_Command_Group.
   */
  public Shoot_Motor_Command_Group(DriveTrain driveTrain, Limelight limelight, Shoot_Motor shoot_Motor, Feeder_Motor feeder_motor) {
    // Add your commands in the super() call. Add the deadline first.
    super(
        // first run shooter without feeder and rotate at hte same time. first one done
        // wins, which should be rotate.
        new SequentialCommandGroup(new ParallelRaceGroup(new RotateToTarget(driveTrain, limelight), new Shoot(Constants.RPM_VALUE)), new ParallelRaceGroup(new Shoot(Constants.RPM_VALUE), new Feed(feeder_motor)), new ShooterStop(shoot_Motor))
    );
        
        
        // next shoot with running feeder motor as well
        
        
    
  }
}
