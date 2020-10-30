package frc.robot.subsystems;


public class Functions{

    double result = 0;
    double variableIntegral(double x, double dx, double n ){
        double integrate;
        
        double i;
        if (x == 0){
            integrate = 0;
        }
        integrate = (x*dx);
        

        for (i=0; i<=n;i++){
            result += integrate;
            
        }

        return result;
    }

}
