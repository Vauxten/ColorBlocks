package org.untitleda.colorblocks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class colorblocks implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.BLUE + "Co" + ChatColor.RED + "lor" + ChatColor.YELLOW, " block" + ChatColor.LIGHT_PURPLE + "s");
        sender.sendMessage(ChatColor.WHITE + "Made by Vauxten.");
        return true;
    }
}