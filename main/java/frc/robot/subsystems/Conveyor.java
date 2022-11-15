package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.Constants.DriveConstants;

public class Conveyor {
    
    private final WPI_TalonFX m_conveyor = new WPI_TalonFX(Constants.DriveConstants.kConveyorPort);

    public Conveyor(){

    }

    public void intake(){

        m_conveyor.set(-1);

    }

    public void stop(){

        m_conveyor.set(0);

    }

    public void manual(double speed){

        m_conveyor.set(speed);

    }

}
