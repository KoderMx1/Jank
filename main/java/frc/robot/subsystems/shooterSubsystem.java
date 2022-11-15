package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.Constants.DriveConstants;

public class shooterSubsystem {
    
    private final CANSparkMax m_shooter = new CANSparkMax(Constants.DriveConstants.kShooterPort, MotorType.kBrushless);

    public shooterSubsystem(){

    }

    public void shoot(){

        m_shooter.set(1);

    }

    public void stop(){

        m_shooter.set(0);

    }

    public void manual(double speed){

        m_shooter.set(speed);

    }

}
