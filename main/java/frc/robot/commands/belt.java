package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;

public class belt extends CommandBase{

    public Conveyor intake;
    public Joystick joystick = new Joystick(0);

    public belt(Conveyor intake, Joystick joystick){

        this.joystick = joystick;
        this.intake = intake;

    }

    @Override
    public void initialize(){

        System.out.println(joystick.getRawAxis(2));

    }

    @Override

    public void execute(){

        System.out.println(joystick.getRawAxis(2));
        intake.manual(joystick.getRawAxis(2)/4);

    }

    public boolean isFinished(){

        return false;

    }

    public void end(boolean interupted){

        intake.stop();

    }
}