package net.maxigames.usefulcommands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Supersummon implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("Usage: /supersummon <entity> [amount]");
            return true;
        }

        Player player = (Player) sender;
        String entityName = args[0].toUpperCase();

        EntityType type;
        try {
            type = EntityType.valueOf(entityName);
        } catch (IllegalArgumentException e) {
            player.sendMessage("Invalid entity type: " + args[0]);
            return true;
        }

        int count = 1;
        if (args.length >= 2) {
            try {
                count = Integer.parseInt(args[1]);
                if (count < 1 || count > 10000000) {
                    player.sendMessage("Amount must be between 1 and a lot.");
                    return true;
                }
            } catch (NumberFormatException e) {
                player.sendMessage("Invalid number: " + args[1]);
                return true;
            }
        }

        Location loc = player.getLocation();
        for (int i = 0; i < count; i++) {
            player.getWorld().spawnEntity(loc, type);
        }

        player.sendMessage("Summoned " + count + " " + type.name().toLowerCase() + "(s).");
        return true;
    }
}
