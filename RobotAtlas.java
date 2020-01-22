// the package command links this file to the other files for the 'single program' robot

package frc.robot;


// import commands ////////////////////////////////////////////////////////////////
// import reads in library files which contain routines and sub-routines so that //
// we do not have to write code from scratch //
// for example edu.wpi.first.buttons.Joystickbuttons //
// contains code so we can type in get_joystick_button //
// to read a value when a button is pressed instead of having to create //
// the thing from scratch ourselves //
/////////////////////////////////////////////////////////////////////////////////////

//We are calling this file RobotAtlas (an upgrade to RobotMap) to house all of our constants //
// so we can edit this file and only this file to change wiring ports //
public class RobotAtlas {

// Joystick //

public static int joystickPort = 0;

// Joystick Buttons //




// XBOX Controller //


// CAN //
public static int leftFrontMotor = 0;
public static int leftRearMotor = 1;
public static int rightFrontMotor = 2;
public static int rightRearMotor = 3;

public static int intakeMotor = 12;
public static int elevatorMotor = 13;
public static int shooterMotor = 14;
public static int forkliftMotor = 15;

//DIO Ports
public static int elevatorMotorBackLimitSwitch = 1;
public static int elevatorMotorForwardLimitSwitch = 2;
public static int forkliftMotorBackLimitSwitch = 3;
public static int forkliftMotorForwardLimitSwitch = 4;












}