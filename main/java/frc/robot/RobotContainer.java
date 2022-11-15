// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Conveyor;
import frc.robot.commands.belt;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.shooterSubsystem;
import frc.robot.commands.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  
  Joystick m_driverController = new Joystick(0);
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final Conveyor m_conveyor = new Conveyor();
  private final shooterSubsystem m_shooterSubsystem = new shooterSubsystem();

  private final belt m_belt = new belt(m_conveyor, m_driverController);
  private final shooter m_shooter = new shooter(m_shooterSubsystem, m_driverController);

  JoystickButton button1 = new JoystickButton(m_driverController, 1);
  JoystickButton button2 = new JoystickButton(m_driverController, 2);
  JoystickButton button3 = new JoystickButton(m_driverController, 3);
  JoystickButton button4 = new JoystickButton(m_driverController, 4);
  JoystickButton button5 = new JoystickButton(m_driverController, 5);
 
  JoystickButton button6 = new JoystickButton(m_driverController, 6);
  JoystickButton button7 = new JoystickButton(m_driverController, 7);
  JoystickButton button8 = new JoystickButton(m_driverController, 8);
  JoystickButton button9 = new JoystickButton(m_driverController, 9);
  JoystickButton button10 = new JoystickButton(m_driverController, 10);

  public RobotContainer() {

    configureButtonBindings();

    m_robotDrive.setDefaultCommand(

        new RunCommand(
                () -> m_robotDrive.arcadeDrive(
                        -m_driverController.getRawAxis(1), m_driverController.getRawAxis(0)),
                m_robotDrive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link PS4Controller}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {

    button1.whenPressed(m_belt);
    button2.whenPressed(m_shooter);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // no auto
    return new InstantCommand();
  }
}
