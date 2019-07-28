package jp.dora.awd;

import org.bukkit.entity.Player;

public class KickRunnable implements Runnable {
    Player p;

    KickRunnable(Player player) {
        p = player;
    }

    public final void run() {
        p.kickPlayer("§cこのサーバーでは、WorldDownloaderが禁止されています！");
    }

}
