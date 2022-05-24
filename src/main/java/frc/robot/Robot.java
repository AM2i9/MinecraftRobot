// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.time.Duration;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import io.graversen.minecraft.rcon.MinecraftRcon;
import io.graversen.minecraft.rcon.service.ConnectOptions;
import io.graversen.minecraft.rcon.service.MinecraftRconService;
import io.graversen.minecraft.rcon.service.RconDetails;

public class Robot extends TimedRobot {

  private final MinecraftRconService rconService = new MinecraftRconService(
    new RconDetails("localhost", 25575, "PASSWORD"),
    ConnectOptions.defaults()
  );
  private MinecraftRcon rcon;

  private boolean[] leverStates = new boolean[4];

  private PWMTalonSRX frontLeft;
  private PWMTalonSRX frontRight;
  private PWMTalonSRX backLeft;
  private PWMTalonSRX backRight;

  private MecanumDrive drive;

  private final double kSpeed = 0.5;

  @Override
  public void robotInit() {

    frontLeft = new PWMTalonSRX(0);
    frontRight = new PWMTalonSRX(2);
    backLeft = new PWMTalonSRX(1);
    backRight = new PWMTalonSRX(3);

    frontRight.setInverted(true);
    backRight.setInverted(true);

    drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    // Create Minecraft RCON connection
    //! currently throws error if server isn't running
    rconService.connectBlocking(Duration.ofSeconds(10));
    rcon = rconService.minecraftRcon().orElseThrow(IllegalStateException::new);
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    for (int i = 0; i < leverStates.length; i++) {
      leverStates[i] = rcon.sendSync(
        new GetLeverStateCommand(i)
      ).getResponseString().substring(10,11).equals("1");
    }

    double xSpeed = kSpeed * ((leverStates[1] ? -1 : 0) + (leverStates[2] ? 1 : 0));
    double ySpeed = kSpeed * ((leverStates[0] ? 1 : 0) + (leverStates[3] ? -1 : 0));

    drive.driveCartesian(ySpeed, xSpeed, 0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}
  @Override
  public void testPeriodic() {}
}
