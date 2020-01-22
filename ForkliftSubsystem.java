/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotAtlas;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ForkliftSubsystem extends Subsystem 
{
  /**
   * Creates a new forkliftSubsystem.
   */
  public WPI_VictorSPX forkLiftController = new WPI_VictorSPX(RobotAtlas.forkliftMotor);

  public void raise()
  {
   forkLiftController.set(1); 
  }
  public void lower()
  {
    forkLiftController.set(-1);
  }
  public void stop()
  {
    forkLiftController.set(0);
  }
  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() 
  {
 
  }
}
