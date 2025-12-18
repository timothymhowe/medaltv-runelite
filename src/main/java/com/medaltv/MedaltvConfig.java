package com.medaltv;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("medaltv")
public interface MedaltvConfig extends Config {
    @ConfigItem(
            keyName = "dropValue",
            name = "Drop Capture Value",
            description = "The minimum drop value to record"
    )
    default String dropValue()
    {
        return "2500000";
    }


}
