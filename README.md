# Minecraft Robot
An FRC robot that can be controlled from Minecraft.

## Hardware
The robot currently uses four PWM TalonSRXs for Mecanum drive, with the following connections

| Motor | PWN Pin |
|  ---  |   ---   |
| Front Left | 0 |
| Back Left | 1 |
| Front Right | 2 |
| Back Right | 3 |

## Setup

Open the `server` folder in the terminal, and run the `download.ps1` powershell script. This will download the Minecraft server jar.

Run the server using the following command in the same directory to start the server:
```zsh
java -jar server.jar nogui
```

Find the local IP address of the computer running the server. This can be done with the `ipconfig /all` command on Windows.

In `Robot.java`, change the IP address on line 20 to the IP you just found from your computer. This will tell the RIO to connect to your computer.

Deploy the code to the RIO. It may crash if the server is not running.

## Driving

Load up Minecraft. I decided to use 1.13.2, since that is the version which added some commands that make doing stuff with this easier. But it technically is possible to use versions all the way back to 1.9 if I wanted to, but use 1.13.2 for this one.

Connecting to the server should be as simple as typing in your computer's IP address, which if it's the same computer, would be `localhost`. If it's a seperate computer, use `ipconfig /all` (Windows) on the computer running the server to get it's IP address, and use that.

In the world, once connected, there will be 4 levers, each for a different X-Y direction (couldn't be bothered to do Z). The lever closest to the dragon head, or the green lever, is the forward direction of the robot. The two to the left and right of that stick, blue and red, are for strafing left and right. The final one, the yellow lever, you guessed it, is for the reverse direction of the robot.