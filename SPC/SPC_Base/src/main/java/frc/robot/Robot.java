

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.SPCCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SPC;


public class Robot extends TimedRobot {
  private RobotContainer container;
  public DriveTrain drive;
  private SPCCommand SPCCommand;
  SPC SPC;




  @Override
  public void robotInit() {
    container = new RobotContainer();
    SPCCommand = container.SPCCommand;
    drive = SPCCommand.drive;
    SPC = new SPC();


  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
    
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }


  @Override
  public void autonomousInit() {
    
   
  }


  @Override
  public void autonomousPeriodic() {
    container.getAutonomousCommand().schedule();
    
    

    
  }

  @Override
  public void teleopInit() {

  }


  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }


  @Override
  public void testPeriodic() {
  }
}
