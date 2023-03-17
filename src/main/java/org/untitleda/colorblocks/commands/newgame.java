package org.untitleda.colorblocks.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class newgame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Inventory inv = Bukkit.createInventory(null, 9, "New Game");
            inv.addItem(new ItemStack(Material.GREEN_STAINED_GLASS_PANE)); //make item
        }
        else {
            sender.sendMessage(ChatColor.DARK_RED + "You must be a player to execute this command.");
            return true;
        }
        return true;
    }
}
