package net.maxigames.usefulcommands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShortenedGamemodes implements CommandExecutor {
    private final GameMode gm;

    public ShortenedGamemodes(GameMode gm) {
        this.gm = gm;
    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only.");
            return true;
        }

        Player player = (Player) sender;
        player.setGameMode(gm);
        player.sendMessage("Set gamemode to " + gm.name());
        return true;
    }
}
