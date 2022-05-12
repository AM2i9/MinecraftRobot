# Minecraft Robot
An FRC robot that can be controlled from Minecraft.
Currently theoretical, needs testing on an actual RoboRIO.

## Hardware
This is meant to run on an NI RoboRIO (to be tested to see if it can actually run a Minecraft server). The robot is programmed to be Mecanum drive, but different drive methods can be implemented pretty easily.

The robot uses four PWN TalonSRXs, with the following connections

| Motor | PWN Pin |
|  ---  |   ---   |
| Front Left | 0 |
| Back Left | 1 |
| Front Right | 2 |
| Back Right | 3 |

## Setup

Flash the RoboRIO to the latest image version.

Go to the `src/main/deploy` directory. Run the `download.ps1` script in that directory, which should download Java and the Minecraft server jar. Make sure that the downloaded items are in the `deploy` directory.

Once the code has deployed, the robot code may crash. This is fine, because the server isn't running yet. We can't run the server from the robot code (*yet*), so it is necessary to SSH into the RIO, navigate to the deploy folder, and run the `start.sh` script to start the server.

Once the server is running, restart the robot code from driverstation, and it should start and connect to the server.

## Driving

Load up Minecraft. I decided to use 1.13.2, since that is the version which added some commands that make doing stuff with this easier. But it technically is possible to use versions all the way back to 1.9, which may need to be used if the RIO isn't powerful enough.

Connecting to the server should be as simple as typing in the RIO's ip address, usually `10.TE.AM.2`, with `TE.AM` being the team number. The hostname of the rio with `.local` at the end should also work too.

In the world, once connected, there will be 4 levers, each for a different X-Y direction (couldn't be bothered to do Z). The lever closest to the dragon head, or the green lever, is the forward direction of the robot. The two to the left and right of that stick, blue and red, are for strafing left and right. The final one, the yellow lever, you guessed it, is for the reverse direction of the robot.