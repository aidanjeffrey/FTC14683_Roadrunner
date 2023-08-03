package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name = "Grid")
public class Test2 extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);


        Trajectory Right = drive.trajectoryBuilder(new Pose2d(0, -0.00, Math.toRadians(90.00)))
                .strafeRight(20)
                .build();
        Trajectory Down = drive.trajectoryBuilder(Right.end())
                .back(5)
                .build();
        Trajectory Left = drive.trajectoryBuilder(Down.end())
                .strafeLeft(20)
                .build();
        Trajectory Down1 = drive.trajectoryBuilder(Left.end())
                .back(5)
                .build();
        Trajectory Right1 = drive.trajectoryBuilder(Down1.end())
                .strafeRight(20)
                .build();
        Trajectory Down2 = drive.trajectoryBuilder(Right1.end())
                .back(5)
                .build();
        Trajectory Left1 = drive.trajectoryBuilder(Down2.end())
                .strafeLeft(20)
                .build();
        Trajectory Down3 = drive.trajectoryBuilder(Left1.end())
                .back(5)
                .build();
        Trajectory Right2 = drive.trajectoryBuilder(Down3.end())
                .strafeRight(20)
                .build();
        drive.setPoseEstimate(Right.start());


        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(Right);
        drive.followTrajectory(Down);
        drive.followTrajectory(Left);
        drive.followTrajectory(Down1);
        drive.followTrajectory(Right1);
        drive.followTrajectory(Down2);
        drive.followTrajectory(Left1);
        drive.followTrajectory(Down3);
        drive.followTrajectory(Right2);
    }
}