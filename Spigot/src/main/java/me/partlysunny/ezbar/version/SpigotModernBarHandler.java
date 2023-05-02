package me.partlysunny.ezbar.version;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class SpigotModernBarHandler implements VersionBarHandler {
    @Override
    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut, Player p) {
        p.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    @Override
    public void sendActionBar(String message, Player p) {
        p.spigot().sendMessage(p.getUniqueId(), new TextComponent(message));
    }

    @Override
    public BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags) {
        return Bukkit.createBossBar(title, color, style, flags);
    }
}
