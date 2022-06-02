package de.flashyboi.minecraft.plugins.toolboxblocker;

import de.flashyboi.minecraft.plugins.toolboxblocker.config.ConfigVersionManager;
import de.flashyboi.minecraft.plugins.toolboxblocker.events.PlayerHandshake;
import de.flashyboi.minecraft.plugins.toolboxblocker.util.DiscordWebhook;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.geysermc.floodgate.util.DeviceOs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.logging.Logger;

public final class ToolboxBlocker extends Plugin {
    public static Configuration config;
    public static Plugin plugin;
    public Logger log = this.getLogger();

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PlayerHandshake());
        initiateConfig();
        ConfigVersionManager configVersionManager = new ConfigVersionManager(this);
        configVersionManager.checkVersion(config);

        PlayerHandshake.sendEmbed(true, "noone", UUID.randomUUID(), "something", DeviceOs.IOS);
        DiscordWebhook.sendCommand("{\n" +
                "  \"content\": null,\n" +
                "  \"embeds\": [\n" +
                "    {\n" +
                "      \"color\": null,\n" +
                "      \"author\": {\n" +
                "        \"name\": \"dasdsa\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"attachments\": []\n" +
                "}", config.get("Webhook-URL").toString());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initiateConfig() {
        try {
            File dataFolder = this.getDataFolder();
            File configFile = new File(dataFolder, "config.yml");
            Path configFilePath = configFile.toPath();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            if (!configFile.exists()) {
                InputStream inputStream = this.getResourceAsStream("config.yml");
                Files.copy(inputStream, configFilePath);
            }
            ConfigurationProvider configProvider = ConfigurationProvider.getProvider(YamlConfiguration.class);
            config = configProvider.load(configFile);

        } catch (IOException | NullPointerException ioe) {
            ioe.printStackTrace();
        }
    }
}

/* TODO: Use config stuff */
