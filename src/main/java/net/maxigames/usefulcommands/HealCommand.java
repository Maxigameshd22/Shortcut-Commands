package net.maxigames.usefulcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            // Heal self
            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);
            player.setSaturation(20f);
            player.sendMessage(ChatColor.GREEN + "You have been healed!");
        } else {
            // Heal another player (needs permission)
            if (!player.hasPermission("heal.others")) {
                player.sendMessage(ChatColor.RED + "You don't have permission to heal others.");
                return true;
            }

            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null || !target.isOnline()) {
                player.sendMessage(ChatColor.RED + "That player is not online.");
                return true;
            }

            target.setHealth(target.getMaxHealth());
            target.setFoodLevel(20);
            target.setSaturation(20f);
            target.sendMessage(ChatColor.GREEN + "You have been healed by " + player.getName() + "!");
            player.sendMessage(ChatColor.GREEN + "You healed " + target.getName() + ".");
        }

        return true;
    }
}
