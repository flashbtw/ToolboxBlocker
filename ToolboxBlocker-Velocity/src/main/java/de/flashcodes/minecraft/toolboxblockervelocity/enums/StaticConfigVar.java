package de.flashcodes.minecraft.toolboxblockervelocity.enums;

public enum StaticConfigVar {

    CONFIG_VERSION_PATH("version"),
    WEBHOOK_URL_PATH("Webhook-URL"),
    SEND_EMBED_PATH("Logging.send-embed"),
    LOG_TO_TXT_PATH("Logging.log-to-txt"),
    TOOLBOX_KICK_MESSAGE_PATH("Messages.toolbox-kick-message");
    private final String path;

    StaticConfigVar(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
