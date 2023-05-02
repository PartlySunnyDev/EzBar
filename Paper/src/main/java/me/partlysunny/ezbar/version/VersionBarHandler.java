package me.partlysunny.ezbar.version;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.entity.Player;

import java.time.Duration;

public interface VersionBarHandler {

    void sendTitle(Component title, Component subtitle, Duration fadeIn, Duration stay, Duration fadeOut, Player p);

    void sendActionBar(Component message, Player p);

    BossBar createBossBar(Component title, BossBar.Color color, BossBar.Overlay style, BossBar.Flag... flags);

}
