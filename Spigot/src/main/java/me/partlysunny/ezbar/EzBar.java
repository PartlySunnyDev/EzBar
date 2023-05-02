package me.partlysunny.ezbar;

import me.partlysunny.ezbar.version.SpigotModernBarHandler;
import me.partlysunny.ezbar.version.SpigotNMSBarHandler;
import me.partlysunny.ezbar.version.VersionBarHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class EzBar {

    private static EzBar INSTANCE;

    public static EzBar getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("EzBar is not initialized!");
        }
        return INSTANCE;
    }

    public static void init(JavaPlugin plugin) {
        if (INSTANCE != null) {
            throw new IllegalStateException("EzBar is already initialized!");
        }
        INSTANCE = new EzBar(plugin);
    }

    private final JavaPlugin plugin;
    private final VersionBarHandler versionBarHandler;

    private EzBar(JavaPlugin plugin) {
        this.plugin = plugin;
        if (ServerVersion.isHigherOrEqual(ServerVersion.v1_17_R1)) {
            versionBarHandler = new SpigotModernBarHandler();
        } else {
            versionBarHandler = new SpigotNMSBarHandler(ServerVersion.getServerVersion().name());
        }
    }

    public JavaPlugin plugin() {
        return plugin;
    }

    public VersionBarHandler versionBarHandler() {
        return versionBarHandler;
    }
}
