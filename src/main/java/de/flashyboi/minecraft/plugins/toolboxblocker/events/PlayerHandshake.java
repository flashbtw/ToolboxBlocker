package de.flashyboi.minecraft.plugins.toolboxblocker.events;

import de.flashyboi.minecraft.plugins.toolboxblocker.staticvar.StaticEmbeds;
import de.flashyboi.minecraft.plugins.toolboxblocker.util.DiscordWebhook;
import de.flashyboi.minecraft.plugins.toolboxblocker.util.ToolboxChecker;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.chat.ComponentSerializer;
import net.md_5.bungee.event.EventHandler;
import org.geysermc.floodgate.util.DeviceOs;
import org.geysermc.geyser.GeyserImpl;
import org.geysermc.geyser.session.auth.BedrockClientData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PlayerHandshake implements Listener {
    @EventHandler
    public void onPlayerHandshake(PostLoginEvent ple) {
        ProxiedPlayer player = ple.getPlayer();
        UUID playerUUID = player.getPendingConnection().getUniqueId();
        if (GeyserImpl.getInstance().connectionByUuid(playerUUID) != null) {
            String playerName = player.getName();
            BedrockClientData clientData = GeyserImpl.getInstance().connectionByUuid(playerUUID).getClientData();
            DeviceOs deviceOs = clientData.getDeviceOs();
            String modelName = clientData.getDeviceModel();
            boolean hasPlayerToolbox = ToolboxChecker.hasToolbox(deviceOs, clientData);
            MiniMessage miniMessage = MiniMessage.miniMessage();
            Component component = miniMessage.deserialize("<red> test </red>");
            String json = GsonComponentSerializer.gson().serializer().toJson(component);
            BaseComponent[] bc = ComponentSerializer.parse(json);
            if (hasPlayerToolbox) {
                player.disconnect(bc);
            }
            sendEmbed(hasPlayerToolbox, playerName, playerUUID, modelName, deviceOs);
            }

    }

    public static void sendEmbed(boolean hasPlayerToolbox, String playerName, UUID playerUUID, String modelName, DeviceOs deviceOs) {
        String toolboxFoundText;
        String color;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String time = LocalDateTime.now(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(0))).format(dateFormat);

        if(hasPlayerToolbox) {
            toolboxFoundText = StaticEmbeds.TOOLBOX_FOUND_TRUE;
            color = StaticEmbeds.EMBED_COLOR_TOOLBOX_FOUND_TRUE;
        } else {
            toolboxFoundText = StaticEmbeds.TOOLBOX_FOUND_FALSE;
            color = StaticEmbeds.EMBED_COLOR_TOOLBOX_FOUND_FALSE;
        }
        String formattedJson = String.format(StaticEmbeds.toolboxEmbed, toolboxFoundText, color, playerName, playerUUID, modelName, deviceOs, time, time);
        System.out.println(formattedJson);
        new Thread(() -> DiscordWebhook.sendCommand(formattedJson)).start();
    }
}
