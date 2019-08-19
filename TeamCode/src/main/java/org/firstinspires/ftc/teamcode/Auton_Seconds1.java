package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

// This program was created by Srilekha on 7/23/19. It has no errors.
    /**
     * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
     * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
     * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
     * class is instantiated on the Robot Controller and executed.
     *
     * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
     * It includes all the skeletal structure that all linear OpModes contain.
     *
     * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
     * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
     */

    @Autonomous(name="Auton_Seconds1", group="Linear Opmode")

    public class Auton_Seconds1 extends LinearOpMode {

        // Declare OpMode members.
        private DcMotor Motor1 = null;
        private DcMotor Motor2 = null;

        @Override
        public void runOpMode() throws InterruptedException {
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            // Initialize the hardware variables. Note that the strings used here as parameters
            // to 'get' must correspond to the names assigned during the robot configuration
            // step (using the FTC Robot Controller app on the phone).
            Motor1 = hardwareMap.get(DcMotor.class, "Motor1");
            Motor2 = hardwareMap.get(DcMotor.class, "Motor2");

            // Most robots need the motor on one side to be reversed to drive forward
            // Reverse the motor that runs backwards when connected directly to the battery
            Motor1.setDirection(DcMotor.Direction.FORWARD);
            Motor2.setDirection(DcMotor.Direction.REVERSE);

            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {

                if (opModeIsActive()) {
                    //moves forward for two seconds
                    Motor1.setPower(0.5);
                    Motor2.setPower(0.5);
                    sleep(2000); //wait for two seconds
                    Motor1.setPower(0);
                    Motor2.setPower(0);
                }
                //moves backwards for two seconds
                if (opModeIsActive()) {
                    Motor1.setPower(-0.5);
                    Motor2.setPower(-0.5);
                    sleep(2000); //wait for two seconds
                    Motor1.setPower(0);
                    Motor2.setPower(0);
                    break;
                }
            }
        }

    }

