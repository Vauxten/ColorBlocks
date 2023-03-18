package org.untitleda.colorblocks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.untitleda.colorblocks.commands.colorblocks;
import org.untitleda.colorblocks.commands.newgame;

import java.util.Arrays;

public class ColorBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabled ColorBlocks");
        this.getCommand("colorblocks").setExecutor(new colorblocks());
        this.getCommand("newgame").setExecutor(new newgame());

        new BukkitRunnable() {
            int countdown = 10;

            @Override
            public void run() {
                if (countdown == 0) {
                    cancel();
                    return;
                }

                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getLocation().getBlock().getType() == Material.YELLOW_WOOL) {
                        player.sendMessage(ChatColor.GREEN + "Task Completed.");
                    }
                    Bukkit.broadcastMessage("Countdown: " + countdown);
                    countdown--;
                    if (countdown == 0) {
                        if(player.getLocation().getBlock().getType() != Material.YELLOW_WOOL) {
                            player.sendMessage(ChatColor.DARK_RED + "Failed task: stand on yellow wool ");
                        }
                    }
                }
            }
        };
    }
    public void onDisable () {
        getLogger().info("Disabled ColorBlocks");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "save-all");
    }

    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

}