/* Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.*/
//import edu.wpi.first.wpilibj.interfaces.Gyro;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import edu.wpi.first.wpilibj.ADXRS450_Gyro;

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final WPI_TalonSRX LeftMotor1 = new WPI_TalonSRX(DriveConstants.kLeftMotor1Port);
  private final WPI_TalonSRX LeftMotor2 = new WPI_TalonSRX(DriveConstants.kLeftMotor2Port);
  private final WPI_TalonSRX RightMotor1 = new WPI_TalonSRX(DriveConstants.kRightMotor1Port);
  private final WPI_TalonSRX RightMotor2 = new WPI_TalonSRX(DriveConstants.kRightMotor2Port);

  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(
      LeftMotor1,
      LeftMotor2);
  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(
      RightMotor1,
      RightMotor2);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  private final Encoder m_leftEncoder = new Encoder(
      DriveConstants.kLeftEncoderPorts[0],
      DriveConstants.kLeftEncoderPorts[1],
      DriveConstants.kLeftEncoderReversed);

  private final Encoder m_rightEncoder = new Encoder(
      DriveConstants.kRightEncoderPorts[0],
      DriveConstants.kRightEncoderPorts[1],
      DriveConstants.kRightEncoderReversed);

  private final AHRS m_gyro = new AHRS(SerialPort.Port.kMXP);

  Ultrasonic ultrasonic = new Ultrasonic(8, 9);

  public DriveSubsystem() {

    m_rightMotors.setInverted(true);

    Ultrasonic.setAutomaticMode(true);

    m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
  }

  public double getRange() {
    return ultrasonic.getRangeInches();
  }

  /**
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }

  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  /**
   * @return the average of the two encoder readings
   */
  public double getAverageEncoderDistance() {
    return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
  }

  /**
   * @return the left drive encoder
   */
  public Encoder getLeftEncoder() {
    return m_leftEncoder;
  }

  /**
   * @return the right drive encoder
   */
  public Encoder getRightEncoder() {
    return m_rightEncoder;
  }

  /**
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }

  public void zeroHeading() {
    m_gyro.reset();
  }

  /**
   * @return the robot's heading in degrees, from 180 to 180
   */
  public double getHeading() {
    return Math.IEEEremainder(m_gyro.getAngle(), 360);
  }

  /**
   * @return The turn rate of the robot, in degrees per second
   */
  public double getTurnRate() {
    return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
}