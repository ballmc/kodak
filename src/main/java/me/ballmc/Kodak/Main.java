package me.ballmc.Kodak;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;

import me.ballmc.Kodak.command.KodakCommand;


public class Main implements ModInitializer {
    @Override
    public void preInit() {
        System.out.println("Initializing Kodak!");
        Kodak kodak = Kodak.getInstance();
        kodak.initialize(System.getProperty("user.home") + "/.weave/mods");
        CommandBus.register(new KodakCommand());
    }
}