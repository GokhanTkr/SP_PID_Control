
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.SPCCommand;

public class RobotContainer {
  SPCCommand SPCCommand = new SPCCommand();

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
  }


  public Command getAutonomousCommand(){
  
    
    
    return SPCCommand;
  }

}
