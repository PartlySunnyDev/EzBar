package me.partlysunny.ezbar.version;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public interface VersionBarHandler {

    void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut, Player p);

    void sendActionBar(String message, Player p);

    BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags);

}
