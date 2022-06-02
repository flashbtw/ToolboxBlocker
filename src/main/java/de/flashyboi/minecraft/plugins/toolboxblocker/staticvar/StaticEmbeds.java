package de.flashyboi.minecraft.plugins.toolboxblocker.staticvar;

public final class StaticEmbeds {
    public static final String TOOLBOX_FOUND_TRUE = "Toolbox found";
    public static final String TOOLBOX_FOUND_FALSE = "no Toolbox found";
    public static final String EMBED_COLOR_TOOLBOX_FOUND_TRUE = "16711680";
    public static final String EMBED_COLOR_TOOLBOX_FOUND_FALSE = "123456";
    public static final String toolboxEmbed =
        "{" +
        "\n  \"content\": null," +
        "\n  \"embeds\": [" +
        "\n    {" +
        "\n      \"title\": \"Anti-Toolbox\"," +
        "\n      \"description\": \"%s\"," +
        "\n      \"url\": \"https://flash-codes.de\"," +
        "\n      \"color\": %s," +
        "\n      \"fields\": [" +
        "\n        {" +
        "\n          \"name\": \"Player:\"," +
        "\n          \"value\": \"%s\"," +
        "\n          \"inline\": true" +
        "\n        }," +
        "\n        {" +
        "\n          \"name\": \"PlayerUUID\"," +
        "\n          \"value\": \"%s\"," +
        "\n          \"inline\": true" +
        "\n        }," +
        "\n        {" +
        "\n          \"name\": \"ModelName:\"," +
        "\n          \"value\": \"%s\"," +
        "\n          \"inline\": true" +
        "\n        }," +
        "\n        {" +
        "\n          \"name\": \"DeviceOS:\"," +
        "\n          \"value\": \"%s\"," +
        "\n          \"inline\": true" +
        "\n        }," +
        "\n        {" +
        "\n          \"name\": \"Time\"," +
        "\n          \"value\": \"%s (UTC)\"," +
        "\n          \"inline\": true" +
        "\n        }" +
        "\n      ]," +
        "\n      \"author\": {" +
        "\n        \"name\": \"Flash's Anti-Toolbox Bot\"," +
        "\n        \"url\": \"https://flash-codes.de/\"" +
        "\n      }," +
        "\n      \"footer\": {" +
        "\n        \"text\": \"developed by flash_btw\"" +
        "\n      }," +
        "\n      \"timestamp\": \"%s\"" +
        "\n    }" +
        "\n  ]" +
        "\n}";

    public static final String START_EMBED =
        "{\n" +
        "  \"content\": null,\n" +
        "  \"embeds\": [\n" +
        "    {\n" +
        "      \"title\": \"ToolboxBlocker started!\",\n" +
        "      \"description\": \"Just informing you that ToolboxBlocker started successfully.\",\n" +
        "      \"color\": 4062976,\n" +
        "      \"author\": {\n" +
        "        \"name\": \"flash_btw\",\n" +
        "        \"url\": \"https://flash-codes.de/\"\n" +
        "      }\n" +
        "    }\n" +
        "  ],\n" +
        "  \"attachments\": []\n" +
        "}";
}
