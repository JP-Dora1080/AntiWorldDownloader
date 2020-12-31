package jp.dora.awd;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements PluginMessageListener {
    @Override
    public void onEnable() {
        getServer().getMessenger().registerIncomingPluginChannel(this, "wdl:init", this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "wdl:control");
    }

    @Override
    public void onDisable() {
        getServer().getMessenger().unregisterIncomingPluginChannel(this, "wdl:init");
        getServer().getMessenger().unregisterOutgoingPluginChannel(this, "wdl:control");
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] var) {
        if (channel.equals("wdl:init")) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, new KickRunnable(player), 2L);
        }
    }

}
