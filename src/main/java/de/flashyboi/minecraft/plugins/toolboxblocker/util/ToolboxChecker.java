package de.flashyboi.minecraft.plugins.toolboxblocker.util;

import de.flashyboi.minecraft.plugins.toolboxblocker.staticvar.StaticLists;
import org.geysermc.floodgate.util.DeviceOs;
import org.geysermc.geyser.session.auth.BedrockClientData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolboxChecker {
    public static boolean hasToolbox(BedrockClientData clientData) {
        String modelName;
        if (clientData.getDeviceModel() != null) {
            modelName = clientData.getDeviceModel();
            return hasIllegalDeviceModel(modelName);
        }
        return false;
    }

    private static boolean hasIllegalDeviceModel(String modelName) {
        Pattern pattern = Pattern.compile("^([^\s]+)");
        Matcher matcher = pattern.matcher(modelName);
        matcher.find();
        modelName = modelName.substring(matcher.start(), matcher.end());
        if (modelName.toLowerCase().equals(modelName)) {
            return true;
        }
        for (int i = 0; i < StaticLists.FORBIDDEN_MODELNAMES.size(); i++) {
            if (modelName.equals(StaticLists.FORBIDDEN_MODELNAMES.get(i))) {
                return true;
            }
        }
    return false;
    }
}
