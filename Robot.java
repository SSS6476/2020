/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ForkliftSubsystem;
import frc.robot.subsystems.DriveSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  public static ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  public static ForkliftSubsystem forkliftSubsystem = new ForkliftSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public Joystick logitech;

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    logitech = new Joystick(RobotAtlas.joystickPort);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    drive();
  }
   
    public void drive(){
      //throttle remapped to 0 to 1 instead of -1 to 1 //
    double throttle = 1-((logitech.getThrottle()+1)/2);
    double move = -logitech.getY()*throttle;
    double turn = logitech.getX()*throttle;
      // remove creep by creating a deadzone of + and - 0.1 for joystick axes //
    if(Math.abs(move)<0.1){
      move = 0;
    }
    if (Math.abs(turn)<0.1){
      turn = 0;
    driveSubsystem.teleopDrive(move, turn);
      // Joystick Madness //
    if (logitech.getRawButton(1))
      {
      shooterSubsystem.shoot();
      }  
      else if (logitech.getRawButton(11))
      {
      intakeSubsystem.load();  
      }
      else if (logitech.getRawButton(12))
      {
      intakeSubsystem.unload();  
      }
      else if (logitech.getRawButton(2))
      {
      elevatorSubsystem.up();  
      }
      else if (logitech.getRawButton(3))
      {
      elevatorSubsystem.down();
      }
      else if (logitech.getRawButton(6))
      {
      forkliftSubsystem.raise();  
      }
      else if (logitech.getRawButton(4))
      {
      forkliftSubsystem.lower();  
      }

    }
    }

  

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
