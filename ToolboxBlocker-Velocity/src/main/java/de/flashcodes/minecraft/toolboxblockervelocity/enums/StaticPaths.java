package de.flashcodes.minecraft.toolboxblockervelocity.enums;

public enum StaticPaths {

    CONFIG_FILE("/config.yml");

    private final String path;
    StaticPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
