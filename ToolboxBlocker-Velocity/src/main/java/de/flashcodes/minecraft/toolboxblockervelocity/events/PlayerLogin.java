package de.flashcodes.minecraft.toolboxblockervelocity.events;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.LoginEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class PlayerLogin {

    @Subscribe(order = PostOrder.EARLY)
    public void onPlayerLogin(LoginEvent loginEvent) {
        System.out.println("S");
        MiniMessage mm = MiniMessage.miniMessage();
        Component component = mm.deserialize("<rainbow>Testing </rainbow><rainbow>Testing </rainbow><blue>123</blue>");
        loginEvent.getPlayer().sendMessage(component);
    }
}
