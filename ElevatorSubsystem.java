/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotAtlas;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


// import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem
{
  /**
   * Creates a new elevatorSubsystem.
   */
  public WPI_VictorSPX elevatorController = new WPI_VictorSPX(RobotAtlas.elevatorMotor);

 
  public void up()
    {
    elevatorController.set(1);
    }
  public void down()
    {
    elevatorController.set(-1);
    }
  public void stop()
    {
    elevatorController.set(0);
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
