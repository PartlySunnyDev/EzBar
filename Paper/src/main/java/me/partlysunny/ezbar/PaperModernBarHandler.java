package me.partlysunny.ezbar;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.Set;

public class PaperModernBarHandler implements VersionBarHandler {
    @Override
    public void sendTitle(Component title, Component subtitle, Duration fadeIn, Duration stay, Duration fadeOut, Player p) {
        p.sendTitlePart(TitlePart.TITLE, title);
        p.sendTitlePart(TitlePart.SUBTITLE, subtitle);
        p.sendTitlePart(TitlePart.TIMES, Title.Times.times(fadeIn, stay, fadeOut));
    }

    @Override
    public void sendActionBar(Component message, Player p) {
        p.sendActionBar(message);
    }

    @Override
    public BossBar createBossBar(Component title, BossBar.Color color, BossBar.Overlay style, BossBar.Flag... flags) {
        return BossBar.bossBar(title, 1.0f, color, style, Set.of(flags));
    }


}
