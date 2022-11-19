package de.flashcodes.minecraft.toolboxblockervelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import de.flashcodes.minecraft.toolboxblockervelocity.config.ConfigManager;
import de.flashcodes.minecraft.toolboxblockervelocity.config.ConfigVersionManager;
import de.flashcodes.minecraft.toolboxblockervelocity.events.PlayerLogin;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Plugin(
        id = "toolboxblocker-velocity",
        name = "ToolboxBlocker Velocity",
        version = "0.0.0-SNAPSHOT",
        description = "Velocity Version of ToolboxBlocker",
        url = "https://flash-codes.de/",
        authors = {"flash_btw"}
)
public class ToolboxBlockerVelocity {

    private final Logger logger;
    private final ProxyServer server;
    private final Path dataDirectory;
    @Inject
    public ToolboxBlockerVelocity(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) throws IOException {
        server.getEventManager().register(this, new PlayerLogin());
        logger.info("ToolboxBlocker-Velocity Version blabla started!");
        initializeConfig(dataDirectory, "config.yml");
        ConfigManager.setDataDirectory(dataDirectory);
        ConfigManager.setLogger(logger);
        ConfigManager.setServer(server);
        ConfigManager.testStuff();
    }

    /**
     * Initializes a config file
     *
     * @param targetPath where the file should get initialized.
     * @param fileName how the file is named
     *
     * @return <code>true</code> when config got initialized <br>
     *         <code>false</code> when config already exists or something went wrong
     *
     *
     * @since 0.0.1-SNAPSHOT
     */

    public boolean initializeConfig(Path targetPath, String fileName) throws IOException {
        Path configPath = Path.of(targetPath.toString(), fileName);
        if (!(Files.exists(configPath))) {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
            if (is != null) {
                Files.copy(is, configPath);
                return true;
            }
        }
        return false;
    } //TODO: DEAL WITH IO EXCEPTION
}