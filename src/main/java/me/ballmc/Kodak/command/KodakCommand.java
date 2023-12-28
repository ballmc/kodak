package me.ballmc.Kodak.command;

import net.weavemc.loader.api.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import static me.ballmc.Kodak.Main.*;


public class KodakCommand extends Command {
    public KodakCommand() {
        super("kodak");
    }

    @Override
    public void handle(String[] args) {
        if (args.length != 0) {
            return;
        }

        setEnabled(!enabled);


        // if (args.length > 2) {
        //     return;
        // }
        
        // if (args.length == 0) {
        //     Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Kodak usage: /kodak rotations, /kodak cameraclip, /kodak extracameradistance <distance>"));
        // }

        // if (args.length == 1) {
        //     if (args[0].equalsIgnoreCase("rotations")) {
        //         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Rotations: " + Minecraft.getMinecraft().thePlayer.rotationYaw + ", " + Minecraft.getMinecraft().thePlayer.rotationPitch));
        //     }

        //     if (args[0].equalsIgnoreCase("cameraclip")) {
        //         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Camera Clip: " + Minecraft.getMinecraft().gameSettings.thirdPersonView));
        //     }
        // }

        // if (args.length == 2) {
        //     if (args[0].equalsIgnoreCase("extracameradistance")) {
        //         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Extra Camera Distance: " + args[1]));
        //     }
        // }
    }
}
