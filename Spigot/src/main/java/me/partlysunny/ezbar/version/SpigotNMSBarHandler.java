package me.partlysunny.ezbar.version;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpigotNMSBarHandler implements VersionBarHandler {

    private final String versionString;

    public SpigotNMSBarHandler(String versionString) {
        this.versionString = versionString;
    }


    @Override
    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut, Player p) {
        p.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    @Override
    public void sendActionBar(String message, Player p) {
        try {
            Object craftPlayer = getVersionClass("entity.CraftPlayer").cast(p);
            Object chatPacket = getVersionClass("PacketPlayOutChat")
                    .getConstructor(getVersionClass("IChatBaseComponent"), byte.class)
                    .newInstance(
                            getVersionClass("IChatBaseComponent")
                                    .getDeclaredClasses()[0]
                                    .getMethod("a", String.class)
                                    .invoke(null, "{\"text\":\"" + message + "\"}"),
                            (byte) 2
                    );
            craftPlayer.getClass().getMethod("sendPacket", getVersionClass("PacketPlayOutChat")).invoke(craftPlayer, chatPacket);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            Logger bukkitLogger = Bukkit.getLogger();
            bukkitLogger.log(Level.SEVERE, "A fatal error occurred while loading version specific code!");
            bukkitLogger.log(Level.SEVERE, "Is this version supported?");
        }
    }

    @Override
    public BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags) {
        return Bukkit.createBossBar(title, color, style, flags);
    }

    private Class<?> getVersionClass(String className) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + versionString + "." + className);
    }
}
