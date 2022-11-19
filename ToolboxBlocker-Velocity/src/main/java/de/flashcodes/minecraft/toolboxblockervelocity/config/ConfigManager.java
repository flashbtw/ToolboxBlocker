package de.flashcodes.minecraft.toolboxblockervelocity.config;


import com.velocitypowered.api.proxy.ProxyServer;
import de.flashcodes.minecraft.toolboxblockervelocity.enums.StaticPaths;
import org.simpleyaml.configuration.file.YamlFile;
import org.slf4j.Logger;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;

public class ConfigManager {
    private final static ConfigManager configManager = new ConfigManager();

    private static ProxyServer server;
    private static Logger logger;
    private static Path dataDirectory;

    public static void setServer(ProxyServer s) {
        server = s;
    }

    public static void setLogger(Logger l) {
        logger = l;
    }

    public static void setDataDirectory(Path d) {
        dataDirectory = d;
    }

    public static void testStuff() throws IOException {
        YamlFile yamlFile = new YamlFile(dataDirectory + StaticPaths.CONFIG_FILE.getPath());
        yamlFile.load();
        System.out.println(yamlFile.get("Logging.log-to-txt"));
        System.out.println(yamlFile.get("Logging.send-embed"));
    }
}
