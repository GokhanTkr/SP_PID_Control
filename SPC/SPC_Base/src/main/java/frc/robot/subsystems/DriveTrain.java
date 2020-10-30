package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.SPC;

public class DriveTrain extends SubsystemBase{
    SPC SPC = new SPC();

    PWMVictorSPX shooterMotorLeft = new PWMVictorSPX(Constants.shooterLeftMotorPort);
    PWMVictorSPX shooterMotorRight = new PWMVictorSPX(Constants.shooterRightMotorPort);

    public SpeedControllerGroup shooterMotors = new SpeedControllerGroup(shooterMotorLeft, shooterMotorRight);


     public Encoder shooterEncoder = new Encoder(0, 1);

     public double getEncoderReading() {
        
        return shooterEncoder.getDistancePerPulse();
    }


    public void periodic() {
        getEncoderReading();
    }

}