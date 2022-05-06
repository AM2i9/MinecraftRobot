package frc.robot;

import io.graversen.minecraft.rcon.commands.base.ICommand;

public class GetLeverStateCommand implements ICommand {

    private int num;

    GetLeverStateCommand(int num) {
        this.num = num;
    }

    @Override
    public String command() {
        return "scoreboard players get " + num + " levers";
    }
}
