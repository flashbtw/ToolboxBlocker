package de.flashcodes.minecraft.toolboxblockervelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
        id = "toolboxblocker-velocity",
        name = "ToolboxBlocker Velocity",
        version = "0.0.0-SNAPSHOT",
        description = "Velocity Version of ToolboxBlocker",
        url = "https://flash-codes.de/",
        authors = {"flash_btw"}
)
public class ToolboxBlockerVelocity {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}

//TODO: Set up Velocity Proxy.