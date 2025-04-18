package net.maxigames.usefulcommands;

import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;

public final class Usefulcommands extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("heal").setExecutor(new HealCommand());
        getCommand("gm1").setExecutor(new ShortenedGamemodes(GameMode.CREATIVE));
        getCommand("gm0").setExecutor(new ShortenedGamemodes(GameMode.SURVIVAL));
        getCommand("gm2").setExecutor(new ShortenedGamemodes(GameMode.ADVENTURE));
        getCommand("gm3").setExecutor(new ShortenedGamemodes(GameMode.SPECTATOR));
        getCommand("supersummon").setExecutor(new Supersummon());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
