package me.ballmc.Kodak.command;

import net.weavemc.loader.api.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import me.ballmc.Kodak.Kodak;
import me.ballmc.Kodak.Config;

public class KodakCommand extends Command {
    public KodakCommand() {
        super("kodak");
    }

    Kodak kodak = Kodak.getInstance();
    Config config = kodak.getConfig();

    private void setEnabled(boolean value) {
        config.KodakEnabled = value;
        kodak.saveConfig();
        EnumChatFormatting statusColor = config.KodakEnabled ? EnumChatFormatting.GREEN : EnumChatFormatting.RED;
        String message = EnumChatFormatting.BLUE + "Kodak" + EnumChatFormatting.RESET +
                " has been " + statusColor + (config.KodakEnabled ? "enabled" : "disabled") + EnumChatFormatting.RESET + ".";
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }

    private void setDistance(double value) {
        config.KodakDistance = value;
        kodak.saveConfig();
        String message = EnumChatFormatting.BLUE + "Kodak" + EnumChatFormatting.RESET +
                " distance has been set to " + EnumChatFormatting.GREEN + config.KodakDistance + EnumChatFormatting.RESET + ".";
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }

    @Override
    public void handle(String[] args) {
        Kodak kodak = Kodak.getInstance();
        if (args.length == 0) {
            setEnabled(kodak.getConfig().KodakEnabled = !kodak.getConfig().KodakEnabled);
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Kodak usage: /kodak (toggles on and off), /kodak distance <distance> (default: 4), /kodak reset (resets camera distance to default)"));
            }
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reset")) {
                setDistance(4.0D);
            }
        }

        if (args.length >= 2) {
            if (args[0].equalsIgnoreCase("distance")) {
                try {
                    if (config.KodakDistance < 1 || config.KodakDistance > 10) {
                        setDistance(4.0D);
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Distance must be between 1 and 10! Kodak distance has been reset to default."));
                    } 
                    setDistance(Double.parseDouble(args[1]));
                } catch (NumberFormatException e) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid distance value! Please provide a valid number between 1 and 10."));
                }
            }
        }
    }
}
