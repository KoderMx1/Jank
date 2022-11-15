package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooterSubsystem;

public class shooter extends CommandBase{

    public shooterSubsystem shoot;
    public Joystick joystick = new Joystick(0);

    public shooter(shooterSubsystem shoot, Joystick joystick){

        this.joystick = joystick;
        this.shoot = shoot;

    }

    @Override
    public void initialize(){

        //System.out.println(joystick.getRawAxis(2));

    }

    @Override

    public void execute(){

        //System.out.println(joystick.getRawAxis(2));
        //shoot.manual(joystick.getRawAxis(2)/4);

        shoot.shoot();

    }

    public boolean isFinished(){

        return false;

    }

    public void end(boolean interupted){

        shoot.stop();

    }
}