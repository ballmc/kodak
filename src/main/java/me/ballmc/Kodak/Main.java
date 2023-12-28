package me.ballmc.Kodak;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import net.weavemc.loader.api.event.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import me.ballmc.Kodak.command.KodakCommand;

public class Main implements ModInitializer {
    public static boolean enabled = true;

    public static void setEnabled(boolean value) {
        enabled = value;
        EnumChatFormatting statusColor = enabled ? EnumChatFormatting.GREEN : EnumChatFormatting.RED;
        String message = String.format("%Kodak%s has been %s%s%s.",
        EnumChatFormatting.BLUE, EnumChatFormatting.RESET,
        statusColor, (enabled ? "enabled" : "disabled"), EnumChatFormatting.RESET);
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }

    @Override
    public void preInit() {
        System.out.println("Initializing Kodak!");
        CommandBus.register(new KodakCommand());
    }
}