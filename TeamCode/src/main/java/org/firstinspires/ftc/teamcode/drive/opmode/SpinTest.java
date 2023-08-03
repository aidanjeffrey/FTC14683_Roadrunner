package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name = "Spin Test") // This sets the name
public class SpinTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); // gives the parameters of the robot


        Trajectory LineTo = drive.trajectoryBuilder(new Pose2d(-0.00, -0.00, Math.toRadians(90.00))) // Forward is the name of this trajectory, the new pose is the starting location of the trajectory 0 ,0 ,90 degrees is the center of the field pointed up
                .lineToLinearHeading(new Pose2d(40, 40, Math.toRadians(0)))
                .build();
        Trajectory Left = drive.trajectoryBuilder(LineTo.end()) // Forward is the name of this trajectory, the new pose is the starting location of the trajectory 0 ,0 ,90 degrees is the center of the field pointed up
                .strafeLeft(20)
                .build();
        Trajectory SplineTo = drive.trajectoryBuilder(Left.end())
                .splineToLinearHeading(new Pose2d(0, 0, Math.toRadians(90)), Math.toRadians(90))
                .build();

        drive.setPoseEstimate(LineTo.start()); //Forward.start() is the pose we set up in the Forward trajectory


        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(LineTo);
        drive.followTrajectory(Left);
        drive.followTrajectory(SplineTo);

    }
}