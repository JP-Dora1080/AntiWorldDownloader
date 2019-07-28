package jp.dora.awd;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements PluginMessageListener {
    @Override
    public void onEnable() {
        getServer().getMessenger().registerIncomingPluginChannel(this, "WDL|INIT", this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "WDL|CONTROL");
    }

    @Override
    public void onDisable() {
        getServer().getMessenger().unregisterIncomingPluginChannel(this, "WDL|INIT");
        getServer().getMessenger().unregisterOutgoingPluginChannel(this, "WDL|CONTROL");
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] var) {
        if (channel.equals("WDL|INIT")) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, new KickRunnable(player), 2L);
        }
    }

}
