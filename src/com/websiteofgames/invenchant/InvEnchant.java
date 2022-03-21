package com.websiteofgames.invenchant;

import com.websiteofgames.invenchant.bstats.Metrics;
import com.websiteofgames.invenchant.commands.setInvEnchant;
import com.websiteofgames.invenchant.commands.setInvEnchantTabCompleter;
import com.websiteofgames.invenchant.events.EBookOverEnchantableItem;
import org.bukkit.plugin.java.JavaPlugin;

public class InvEnchant extends JavaPlugin {
    private static InvEnchant plugin;

    public static InvEnchant getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        if (getConfig().get("invenchant") == null) {
            getConfig().set("invenchant", "true");
        }


            // All you have to do is adding the following two lines in your onEnable method.
            // You can find the plugin ids of your plugins on the page https://bstats.org/what-is-my-plugin-id
            int pluginId = 14679; // <-- Replace with the id of your plugin!
            Metrics metrics = new Metrics(this, pluginId);

            // Optional: Add custom charts
            metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));


        plugin = this;
        getServer().getPluginManager().registerEvents(new EBookOverEnchantableItem(), this);
getCommand("setinvenchant").setExecutor(new setInvEnchant());
    getCommand("setinvenchant").setTabCompleter(new setInvEnchantTabCompleter());

    }
    public void onDisable(){
        this.saveConfig();


    }


}
