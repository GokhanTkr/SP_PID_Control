package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SPC;
import frc.robot.subsystems.DriveTrain;

public class SPCCommand extends CommandBase {
    private final SPC SPC = frc.robot.subsystems.SPC.getInstance();
    public DriveTrain drive = new DriveTrain();

    public SPCCommand() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.SPC);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        SPC.SPCController(1.3, 0.01, 0.0005, 20, 30, drive.getEncoderReading(), 4, drive.shooterMotors);
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }

}