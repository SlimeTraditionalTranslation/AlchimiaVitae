package me.apeiros.alchimiavitae;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.metrics.bukkit.Metrics;

import me.apeiros.alchimiavitae.setup.Setup;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.mini2Dx.gettext.GetText;
import org.mini2Dx.gettext.PoFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * Main class
 */
public class AlchimiaVitae extends AbstractAddon {

    private static AlchimiaVitae instance;

    public AlchimiaVitae() {
        super("SlimeTraditionalTranslation", "AlchimiaVitae", "master", "options.auto-update");
    }

    @Override
    public void enable() {
        // Set instance
        instance = this;

        GetText.setLocale(Locale.TRADITIONAL_CHINESE);
        InputStream inputStream = getClass().getResourceAsStream("/translations/zh_tw.po");
        if (inputStream == null) {
            getLogger().severe("錯誤！無法找到翻譯檔案，請回報給翻譯者。");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else {
            getLogger().info("載入繁體翻譯檔案...");
            try {
                PoFile poFile = new PoFile(Locale.TRADITIONAL_CHINESE, inputStream);
                GetText.add(poFile);
            } catch (ParseCancellationException | IOException e) {
                getLogger().severe("錯誤！讀取翻譯時發生錯誤，請回報給翻譯者：" + e.getMessage());
                getServer().getPluginManager().disablePlugin(this);
                return;
            }
        }

        // Set up items and listeners
        Setup.setup(this);

        // bStats
        new Metrics(this, 15139);
    }

    @Override
    public void disable() {
        // Set instance to null
        instance = null;
    }

    public static AlchimiaVitae i() {
        return instance;
    }

}
