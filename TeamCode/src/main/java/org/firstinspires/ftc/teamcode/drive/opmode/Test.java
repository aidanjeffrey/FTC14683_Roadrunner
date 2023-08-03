package org.firstinspires.ftc.teamcode.drive.opmode;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
//importing all the required bits of code
@Autonomous(name = "LWC") //This is how you set the name

public class Test extends LinearOpMode {
    private Servo servo1;
    @Override
    public void runOpMode() {
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo1.scaleRange(0, 1);

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(90));
        drive.setPoseEstimate(startPose);

        Trajectory goLeft = drive.trajectoryBuilder(startPose)
                .strafeLeft(10)
                .build();
        Trajectory goForward = drive.trajectoryBuilder(goLeft.end())
                .forward(10)
                .build();
        Trajectory goRight = drive.trajectoryBuilder(goForward.end())
                .strafeRight(10)
                .build();
        Trajectory wDown1 = drive.trajectoryBuilder(goRight.end())
                .lineTo(new Vector2d(17.279-10,0))
                .build();
        Trajectory wUp1 = drive.trajectoryBuilder(wDown1.end())
                .lineTo(new Vector2d(19.868-10,9.659))
                .build();
        Trajectory wDown2 = drive.trajectoryBuilder(wUp1.end())
                .lineTo(new Vector2d(23.383-10,0))
                .build();
        Trajectory wUp2 = drive.trajectoryBuilder(wDown2.end())
                .lineTo(new Vector2d(30.663-10,10))
                .build();
        Trajectory cTop = drive.trajectoryBuilder(wUp2.end())
                .lineTo(new Vector2d(43-10,14))
                .build();
        Trajectory c2 = drive.trajectoryBuilder(cTop.end())
                .lineTo(new Vector2d(38-10,14))
                .build();
        Trajectory c3 = drive.trajectoryBuilder(c2.end())
                .lineTo(new Vector2d(35-10,12))
                .build();
        Trajectory c4 = drive.trajectoryBuilder(c3.end())
                .lineTo(new Vector2d(33-10,8))
                .build();
        Trajectory c5 = drive.trajectoryBuilder(c4.end())
                .lineTo(new Vector2d(33-10,4))
                .build();
        Trajectory c6 = drive.trajectoryBuilder(c5.end())
                .lineTo(new Vector2d(34-10,0))
                .build();
        Trajectory c7 = drive.trajectoryBuilder(c6.end())
                .lineTo(new Vector2d(40-10,0))
                .build();
        Trajectory c8 = drive.trajectoryBuilder(c7.end())
                .lineTo(new Vector2d(45-10,1))
                .build();

        waitForStart();

        if(isStopRequested()) return;

        servo1.setPosition(.5);
        drive.followTrajectory(goLeft);
        drive.followTrajectory(goForward);
        servo1.setPosition(0);
        drive.followTrajectory(goRight);
        servo1.setPosition(.5);
        drive.followTrajectory(wDown1);
        drive.followTrajectory(wUp1);
        drive.followTrajectory(wDown2);
        drive.followTrajectory(wUp2);
        servo1.setPosition(0);
        drive.followTrajectory(cTop);
        servo1.setPosition(.5);
        drive.followTrajectory(c2);
        drive.followTrajectory(c3);
        drive.followTrajectory(c4);
        drive.followTrajectory(c5);
        drive.followTrajectory(c6);
        drive.followTrajectory(c7);
        drive.followTrajectory(c8);
        servo1.setPosition(0);

    }
}