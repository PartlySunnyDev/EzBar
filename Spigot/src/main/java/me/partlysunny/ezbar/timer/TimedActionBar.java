package me.partlysunny.ezbar.timer;

import me.partlysunny.ezbar.EzBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimedActionBar extends BukkitRunnable {

    public static void sendTimedActionBar(Player player, String message, double seconds) {
        new TimedActionBar(player, message, seconds).runTask(EzBar.getInstance().plugin());
    }

    private final long endTime;
    private final String message;
    private final Player player;

    private TimedActionBar(Player player, String message, double seconds) {
        this.player = player;
        this.message = message;
        this.endTime = System.currentTimeMillis() + (long) (seconds * 1000);
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() >= endTime) {
            EzBar.getInstance().versionBarHandler().sendActionBar("", player);
            cancel();
            return;
        }
        EzBar.getInstance().versionBarHandler().sendActionBar(message, player);
    }
}
