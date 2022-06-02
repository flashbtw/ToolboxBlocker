package de.flashyboi.minecraft.plugins.toolboxblocker.config;

import de.flashyboi.minecraft.plugins.toolboxblocker.ToolboxBlocker;
import de.flashyboi.minecraft.plugins.toolboxblocker.staticvar.StaticConfigVars;
import net.md_5.bungee.config.Configuration;

public class ConfigVersionManager {
    public final ToolboxBlocker toolboxBlocker;
    public ConfigVersionManager(ToolboxBlocker pluginInstance) {
        toolboxBlocker = pluginInstance;
    }
    public void checkVersion(Configuration cfg) {
        if (!(cfg.getInt(StaticConfigVars.CONFIG_VERSION_PATH) == StaticConfigVars.CONFIG_VERSION)) {
            // Config Upgrade Logic Placeholder
            return;
        }
    }
}
