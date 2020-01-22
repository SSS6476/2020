/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotAtlas;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ShooterSubsystem extends Subsystem {
  /**
   * Creates a new shooterSubsystem.
   */
 public WPI_VictorSPX shooterController = new WPI_VictorSPX(RobotAtlas.shooterMotor);

 public void shoot()
 {
   shooterController.set(1);
 }
 public void stop()
 {
   shooterController.set(0);
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
