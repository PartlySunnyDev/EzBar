package me.partlysunny.ezbar.version;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaperNMSBarHandler implements VersionBarHandler {

    private final String versionString;

    public PaperNMSBarHandler(String versionString) {
        this.versionString = versionString;
    }


    @Override
    public void sendTitle(Component title, Component subtitle, Duration fadeIn, Duration stay, Duration fadeOut, Player p) {
        p.sendTitlePart(TitlePart.TITLE, title);
        p.sendTitlePart(TitlePart.SUBTITLE, subtitle);
        p.sendTitlePart(TitlePart.TIMES, Title.Times.times(fadeIn, stay, fadeOut));
    }

    @Override
    public net.kyori.adventure.bossbar.BossBar createBossBar(Component title, net.kyori.adventure.bossbar.BossBar.Color color, net.kyori.adventure.bossbar.BossBar.Overlay style, net.kyori.adventure.bossbar.BossBar.Flag... flags) {
        return net.kyori.adventure.bossbar.BossBar.bossBar(title, 1.0f, color, style, Set.of(flags));
    }

    @Override
    public void sendActionBar(Component message, Player p) {
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

    private Class<?> getVersionClass(String className) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + versionString + "." + className);
    }
}
