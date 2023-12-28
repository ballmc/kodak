package me.ballmc.Kodak;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;

import me.ballmc.Kodak.command.KodakCommand;


public class Main implements ModInitializer {
    public static boolean KodakEnabled = true;
    public static Double KodakDistance = 4.0D;

    @Override
    public void preInit() {
        System.out.println("Initializing Kodak!");
        Kodak kodak = Kodak.getInstance();
        kodak.initialize(System.getProperty("user.home") + "/.weave/mods");
        CommandBus.register(new KodakCommand());
    }
}