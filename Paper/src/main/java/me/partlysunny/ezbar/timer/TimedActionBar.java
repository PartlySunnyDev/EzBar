package me.partlysunny.ezbar.timer;

import me.partlysunny.ezbar.EzBar;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimedActionBar extends BukkitRunnable {

    public static void sendTimedActionBar(Player player, Component message, double seconds) {
        new TimedActionBar(player, message, seconds).runTask(EzBar.getInstance().plugin());
    }

    private final long endTime;
    private final Component message;
    private final Player player;

    private TimedActionBar(Player player, Component message, double seconds) {
        this.player = player;
        this.message = message;
        this.endTime = System.currentTimeMillis() + (long) (seconds * 1000);
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() >= endTime) {
            EzBar.getInstance().versionBarHandler().sendActionBar(Component.empty(), player);
            cancel();
            return;
        }
        EzBar.getInstance().versionBarHandler().sendActionBar(message, player);
    }
}
