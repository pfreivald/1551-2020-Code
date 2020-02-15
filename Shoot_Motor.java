/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shoot_Motor extends SubsystemBase {
  public TalonFX m_lead_motor;
  public TalonFX m_follow_motor;

  public Shoot_Motor() {
    m_lead_motor = new TalonFX(Constants.SHOOT_MOTOR_1_ID);
    m_follow_motor = new TalonFX(Constants.SHOOT_MOTOR_2_ID);
 // m_lead_motor.configFactoryDefault();
 // m_follow_motor.configFactoryDefault();

    m_follow_motor.follow(m_lead_motor);

    m_lead_motor.setNeutralMode(NeutralMode.Coast);

    m_lead_motor.enableVoltageCompensation(true);
    m_lead_motor.configVoltageCompSaturation(12.5);

    // shooter.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

    m_lead_motor.setInverted(true);
    m_follow_motor.setInverted(true);
    m_lead_motor.setSelectedSensorPosition(0);
    m_lead_motor.setSensorPhase(false);

   // setRampRate(true);

    m_lead_motor.config_kP(0, Constants.SHOOTER_P);
    m_lead_motor.config_kI(0, Constants.SHOOTER_I);
    m_lead_motor.config_kD(0, Constants.SHOOTER_D);
    m_lead_motor.config_kF(0, Constants.SHOOTER_F);
}

@Override
public void periodic() {
    // This method will be called once per scheduler run
}

/**
 * @return The RPM of the shooter wheel
 */
public double getRPM() {
    return (m_lead_motor.getSelectedSensorVelocity() * 10 * 60 / Constants.SHOOTER_PULSES_PER_ROTATION);
}

/**
 * Set the output of the shooter wheel
 * @param mode The control mode to use
 * @param value The value to set
 */
public void set(ControlMode mode, double value) {
    m_lead_motor.set(mode, value);
    // System.out.println(value);
}
public boolean isRunning()
{
    return m_lead_motor.getControlMode() == ControlMode.Velocity;

}

public void setRampRate(boolean enabled) {
    m_lead_motor.configClosedloopRamp(enabled ? 1.0 : 0);
}


  //public void Shoot(double shoot_speed, double feeder_speed) {
    //m_lead_motor.set(shoot_speed)
  //}
}
