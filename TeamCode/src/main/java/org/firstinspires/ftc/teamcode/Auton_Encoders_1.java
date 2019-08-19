package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
    // autonomous program that drives bot forward a set distance, stops then
// backs up to the starting point using encoders to measure the distance.
// This example assumes there is one encoder, attached to the left motor.

    @Autonomous(name="Auton_Encoders_1", group="LinearOpmode")
//@Disabled
    public class Auton_Encoders_1 extends LinearOpMode {

        private DcMotor Motor1 = null;
        private DcMotor Motor2 = null;

        @Override
        public void runOpMode() throws InterruptedException {
            {
                Motor1 = hardwareMap.dcMotor.get("Motor1");
                Motor2 = hardwareMap.dcMotor.get("Motor2");

                Motor1.setDirection(DcMotor.Direction.REVERSE);

                // reset encoder count kept by left motor.
                Motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                Motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                // set left motor to run to target encoder position and stop with brakes on.
                Motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                telemetry.addData("Mode", "waiting");
                telemetry.update();

                // wait for start button.

                waitForStart();

                telemetry.addData("Mode", "running");
                telemetry.update();

                // set motors to run to 5000 encoder counts.

                Motor1.setTargetPosition(5000);
                Motor2.setTargetPosition(5000);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(0.25);
                Motor2.setPower(0.25);

                // turn 90 degrees
                Motor1.setTargetPosition(500);
                Motor2.setTargetPosition(500);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(-0.25);
                Motor2.setPower(0.25);

                //move forward
                Motor1.setTargetPosition(5000);
                Motor2.setTargetPosition(5000);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(0.25);
                Motor2.setPower(0.25);

                //turn 90 degrees
                Motor1.setTargetPosition(500);
                Motor2.setTargetPosition(500);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(-0.25);
                Motor2.setPower(0.25);

                // move forward
                Motor1.setTargetPosition(5000);
                Motor2.setTargetPosition(5000);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(0.25);
                Motor2.setPower(0.25);

                //turn 90 degrees
                Motor1.setTargetPosition(500);
                Motor2.setTargetPosition(500);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(-0.25);
                Motor2.setPower(0.25);

                // move forward
                Motor1.setTargetPosition(5000);
                Motor2.setTargetPosition(5000);

                // set both motors to 25% power. Movement will start.

                Motor1.setPower(0.25);
                Motor2.setPower(0.25);

                // wait while opmode is active and both motors is busy running to position.

                while (opModeIsActive() && Motor1.isBusy() && Motor2.isBusy()) {
                    telemetry.addData("encoder-fwd", Motor2.getCurrentPosition() + "  busy=" + Motor1.isBusy());
                    telemetry.update();
                    idle();
                }

                // set motor power to zero to turn off motors. The motors stop on their own but
                // power is still applied so we turn off the power.

                Motor1.setPower(0.0);
                Motor2.setPower(0.0);

                // wait 5 sec so you can observe the final encoder position.

                resetStartTime();

                while (opModeIsActive() && getRuntime() < 5) {
                    telemetry.addData("Position Motor1", Motor1.getCurrentPosition() + "Position Motor2", Motor2.getCurrentPosition());
                    telemetry.update();
                    idle();
                }


            }
        }
    }


