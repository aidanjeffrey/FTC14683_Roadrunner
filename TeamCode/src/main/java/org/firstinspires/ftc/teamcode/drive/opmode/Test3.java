package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name = "Neat Auto") // This sets the name
public class Test3 extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); // gives the parameters of the robot


        Trajectory Forward = drive.trajectoryBuilder(new Pose2d(-0.00, -0.00, Math.toRadians(90.00))) // Forward is the name of this trajectory, the new pose is the starting location of the trajectory 0 ,0 ,90 degrees is the center of the field pointed up
                .forward(20)
                .build();
        Trajectory Right = drive.trajectoryBuilder(Forward.end()) // Forward is the name of this trajectory, the new pose is the starting location of the trajectory 0 ,0 ,90 degrees is the center of the field pointed up
                .forward(20)
                .build();

        drive.setPoseEstimate(Forward.start()); //Forward.start() is the pose we set up in the Forward trajectory


        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(Forward);
        drive.followTrajectory(Right);

    }
}