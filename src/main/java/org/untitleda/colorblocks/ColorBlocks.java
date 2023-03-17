package org.untitleda.colorblocks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.untitleda.colorblocks.commands.colorblocks;

public class ColorBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabled ColorBlocks");
        this.getCommand("colorblocks").setExecutor(new colorblocks());
        this.getCommand("reload").setExecutor(new reload());
        getCommand("reload").setExecutor(this);

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

            public void onDisable () {
                getLogger().info("Disabled ColorBlocks");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "save-all");
            }
        };
    }
}