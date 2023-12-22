package me.ballmc.Kodak;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import net.weavemc.loader.api.event.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;

import me.ballmc.Kodak.command.TestCommand;
import me.ballmc.Kodak.listener.RenderGameOverlayListener;

public class Main implements ModInitializer {
    @Override
    public void preInit() {
        System.out.println("Initializing Kodak!");

        CommandBus.register(new TestCommand());
    }
}