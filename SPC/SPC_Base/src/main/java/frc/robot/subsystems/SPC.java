package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SPC extends SubsystemBase {


    Functions Func = new Functions();
    // Instance thing.
    private static SPC INSTANCE;
  
    public static SPC getInstance() {
    // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed

    if (INSTANCE == null) {
        // Lock to make thread safe 
        synchronized (SPC.class) {
            // check nullness again as multiple threads can reach above null check
            if (INSTANCE == null) {
                INSTANCE = new SPC();
            }
        }
    }
    return INSTANCE;
}
    
    // set error to the setpoint first.
    double currentV = 0;

    // adding the setpoint first.

    double desiredOutputs = 0;
    
    //creating an empty list for storing the datas.

    List<Double> desiredSpeeds = new ArrayList<>();
    List<Double> currentVlist  = new ArrayList<>();
    List<Double> errorList     = new ArrayList<>();

     //definition of the error value.
     double Error;

     //definition of the velocity error.
     double VelocityError;

     double setDesiredSpeeds;

     // :)
     double Proportional_Value;
     double Derivative_Value;
     double Integral_Value;

    
    
    public void SPCController(double Kp, double Kd, double Ki, double setpoint, double maxSpeed, double speedReadings, int controlHorizon,SpeedControllerGroup Controller){
        
        

        //creating a loop constants for controlHorizon.
        int loopControlConstant = 0;
        int secondLoopControlConstant = 0 ; 
        
        
        //saving the desired speed via controlHorizon.
        if (loopControlConstant <= controlHorizon){
            //save the error from returning setpoint repeately.
            Error = setpoint - currentV;
            errorList.add(Error);

            //set the proportional value.
            Proportional_Value = Kp * Error;
            //set the derivetive value.
            //in ch(0) there is no difference.
            if(loopControlConstant > 0){
                //get the difference between CH(n) and CH(n-1).
                Derivative_Value = Kd * (errorList.get(loopControlConstant) - errorList.get(loopControlConstant-1)/0.02);
            }

            // rate the desired speeds between 1 and -1 and sum.
            desiredOutputs += (Proportional_Value + Derivative_Value + Integral_Value) / maxSpeed;

            Integral_Value = Ki * (Func.variableIntegral(Error, 0.02,controlHorizon));
            

            // sum the currentV.
            //this will behave like an integral control.
            currentV += Proportional_Value + Derivative_Value + Integral_Value;

            
            //add the results to the lists.
            currentVlist.add(currentV);
            desiredSpeeds.add(desiredOutputs);

            
            

            loopControlConstant += 1;

        }

        //set the velocity error 0 first to make the error catching one step after the motor runs.

        VelocityError = 0;
             
        //Checking the accuracy of the motor responds and control them.

        
        if (secondLoopControlConstant <= controlHorizon){
    
            // get the desired speeds from previous loop.
            setDesiredSpeeds = desiredSpeeds.get(secondLoopControlConstant);

           

            // set the desired speed to the motor.
            Controller.set(setDesiredSpeeds + VelocityError);
            

             // take the velocity error.
             VelocityError = setDesiredSpeeds - (speedReadings/maxSpeed);

             secondLoopControlConstant += 1;
             
            
        }
        // clear the lists to open space for new loop.
        desiredSpeeds.clear();
        currentVlist.clear();
    }


    }
