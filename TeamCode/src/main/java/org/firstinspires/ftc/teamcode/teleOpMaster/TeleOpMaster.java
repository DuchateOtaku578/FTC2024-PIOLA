package org.firstinspires.ftc.teamcode.teleOpMaster;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.configuracion.RobotConfigMaster_3;
import org.firstinspires.ftc.teamcode.domain.Chasis;


@TeleOp(name="TeleOpMaster", group="Pushbot")

public class TeleOpMaster extends LinearOpMode {

    @Override
    public void runOpMode() {
        RobotConfigMaster_3 robot = new RobotConfigMaster_3();
        robot.init(hardwareMap, telemetry);
        Chasis chasis = new Chasis(robot.enfrenteDer, robot.enfrenteIzq, robot.atrasDer, robot.atrasIzq);
        telemetry.update();
        final double velocidad = 0.5;
        double incremento = 0;
        boolean cambio = true;
        int pulsosElevador = 0;



        waitForStart();

        while (opModeIsActive()) {

            //pulsosElevador = (pulsosElevador >= 0) ? robot.motor.getCurrentPosition() : 0;

            incremento = (gamepad1.left_stick_button || gamepad1.right_stick_button) ? 1 : 0;

            telemetry.addData("Velocidad", (velocidad + incremento) * 100 + "%");


            telemetry.update();


            //Control de chasis

            if(gamepad1.left_stick_y > 0.5){

                chasis.moverseAtras(0.5 + incremento);

            }else if(gamepad1.left_stick_y < -0.5){

                chasis.moverseEnfrente(0.5 + incremento);

            }else if(gamepad1.left_stick_x > 0.5){

                chasis.moverseDerecha(0.5 + incremento);

            }else if(gamepad1.left_stick_x < -0.5){

                chasis.moverseIzquierda(0.5 + incremento);

            }else if(gamepad1.right_stick_x > 0.5){

                chasis.girarDerecha(0.5 + incremento);

            }else if(gamepad1.right_stick_x < -0.5){

                chasis.girarIzquierda(0.5 + incremento);
            }else
                chasis.parar();



        }

    }
}



