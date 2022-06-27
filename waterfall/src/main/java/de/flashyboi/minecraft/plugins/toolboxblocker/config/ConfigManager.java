package de.flashyboi.minecraft.plugins.toolboxblocker.config;

import de.flashyboi.minecraft.plugins.toolboxblocker.ToolboxBlocker;

public class ConfigManager {
    public static <T>T getConfigValue(String path, T type) {
        return ToolboxBlocker.config.get(path, type);
    }
}
