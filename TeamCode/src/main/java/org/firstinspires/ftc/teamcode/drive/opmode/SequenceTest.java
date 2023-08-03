package org.firstinspires.ftc.teamcode.drive.opmode;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
@Autonomous(name = "LWC Sequence") // This sets the name
public class SequenceTest extends LinearOpMode {
    private Servo servo1;
    @Override
    public void runOpMode() {
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo1.scaleRange(0, 1);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); // gives the parameters of the robot

        TrajectorySequence LWC = drive.trajectorySequenceBuilder(new Pose2d(-0.00, -0.00, Math.toRadians(90.00))) // Forward is the name of this trajectory, the new pose is the starting location of the trajectory 0 ,0 ,90 degrees is the center of the field pointed up
                .addDisplacementMarker(() -> { servo1.setPosition(.5); }) //put pen down
                .strafeLeft(10)
                .forward(10) //L is done
                .addDisplacementMarker(() -> { servo1.setPosition(0); }) //raise pen
                .strafeRight(10) // move over to start W
                .addDisplacementMarker(() -> { servo1.setPosition(.5); }) //put pen down
                .lineTo(new Vector2d(17.279-10,0))
                .lineTo(new Vector2d(19.868-10,9.659))
                .lineTo(new Vector2d(23.383-10,0))
                .lineTo(new Vector2d(30.663-10,10)) // W is done
                .addDisplacementMarker(() -> { servo1.setPosition(0); }) // raise pen
                .lineTo(new Vector2d(43-10,14)) // move to start C
                .addDisplacementMarker(() -> { servo1.setPosition(.5); }) //put pen down
                .lineTo(new Vector2d(38-10,14))
                .lineTo(new Vector2d(35-10,12))
                .lineTo(new Vector2d(33-10,8))
                .lineTo(new Vector2d(33-10,4))
                .lineTo(new Vector2d(34-10,0))
                .lineTo(new Vector2d(40-10,0))
                .lineTo(new Vector2d(45-10,1)) //C done
                .addDisplacementMarker(() -> { servo1.setPosition(0); }) //raise pen
                .build();

        drive.setPoseEstimate(LWC.start()); //Forward.start() is the pose we set up in the Forward trajectory
        waitForStart();
        if(isStopRequested()) return;

        drive.followTrajectorySequence(LWC);


    }
}