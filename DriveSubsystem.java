/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotAtlas;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveSubsystem extends Subsystem {
  /**
   * Creates a new DriveSubsystem.
   */
  public WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(RobotAtlas.leftFrontMotor);
  public WPI_TalonSRX leftRearMotor = new WPI_TalonSRX(RobotAtlas.leftRearMotor);
  public WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RobotAtlas.rightFrontMotor);
  public WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(RobotAtlas.rightRearMotor);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

  public DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  public DriveSubsystem()
  {
    leftRearMotor.follow(leftFrontMotor);
    rightRearMotor.follow(rightFrontMotor);
  }

  public void teleopDrive(double move, double turn)
  {
    drive.arcadeDrive(move, turn);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub

  }
}
