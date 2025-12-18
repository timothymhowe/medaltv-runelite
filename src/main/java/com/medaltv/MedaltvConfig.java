package com.medaltv;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("medaltv")
public interface MedaltvConfig extends Config
{
    // ---- Sections ----

    @ConfigSection(
            name = "Wildy",
            description = "Triggers related to Wilderness / PKing",
            position = 0
    )
    String SECTION_WILDY = "wildy";

    @ConfigSection(
            name = "Bossing",
            description = "Triggers related to boss fights",
            position = 1
    )
    String SECTION_BOSSING = "bossing";

    @ConfigSection(
            name = "Drops",
            description = "Triggers related to loot drops / value thresholds",
            position = 2
    )
    String SECTION_DROPS = "drops";

    @ConfigSection(
            name = "LMS",
            description = "Triggers related to Last Man Standing",
            position = 3
    )
    String SECTION_LMS = "lms";

    // ---- Global (top-level) ----


    @ConfigItem(
            keyName = "debugLogging",
            name = "Debug logging",
            description = "Log extra information to the RuneLite console",
            position = -9
    )
    default boolean debugLogging()
    {
        return false;
    }

    // ---- Wildy ----

    @ConfigItem(
            keyName = "wildyEnterClip",
            name = "Clip on enter wilderness",
            description = "Trigger a clip when you enter the Wilderness",
            section = SECTION_WILDY,
            position = 0
    )
    default boolean wildyEnterClip()
    {
        return false;
    }

    @ConfigItem(
            keyName = "wildyCombatClip",
            name = "Clip on enter combat (Wilderness)",
            description = "Trigger a clip when you enter combat while in the Wilderness",
            section = SECTION_WILDY,
            position = 1
    )
    default boolean wildyCombatClip()
    {
        return true;
    }

    @ConfigItem(
            keyName = "wildyDeathClip",
            name = "Clip on death (Wilderness)",
            description = "Trigger a clip when you die in the Wilderness",
            section = SECTION_WILDY,
            position = 2
    )
    default boolean wildyDeathClip()
    {
        return true;
    }

    @ConfigItem(
            keyName = "wildyPkClip",
            name = "Clip on PK kill",
            description = "Trigger a clip when your current/last target dies",
            section = SECTION_WILDY,
            position = 3
    )
    default boolean wildyPkClip()
    {
        return true;
    }

    // ---- Bossing ----

    @ConfigItem(
            keyName = "bossKillClip",
            name = "Clip on boss kill",
            description = "Trigger a clip when a tracked boss is killed",
            section = SECTION_BOSSING,
            position = 0
    )
    default boolean bossKillClip()
    {
        return true;
    }

    @ConfigItem(
            keyName = "bossDeathClip",
            name = "Clip on death during bossing",
            description = "Trigger a clip when you die while bossing",
            section = SECTION_BOSSING,
            position = 1
    )
    default boolean bossDeathClip()
    {
        return false;
    }

    // ---- Drops ----

    @ConfigItem(
            keyName = "bigDropClip",
            name = "Clip on big drop",
            description = "Trigger a clip when a drop meets your threshold",
            section = SECTION_DROPS,
            position = 0
    )
    default boolean bigDropClip()
    {
        return true;
    }

    @ConfigItem(
            keyName = "dropValueThreshold",
            name = "Min. Drop value",
            description = "Minimum value (gp) required to trigger a drop clip",
            section = SECTION_DROPS,
            position = 1
    )
    default int dropValue()
    {
        return 1000000;
    }

    // ---- LMS ----

    @ConfigItem(
            keyName = "lmsRoundWinClip",
            name = "Clip on round win",
            description = "Trigger a clip when you win a fight/round in LMS",
            section = SECTION_LMS,
            position = 0
    )
    default boolean lmsRoundWinClip()
    {
        return true;
    }

    @ConfigItem(
            keyName = "lmsFinalWinClip",
            name = "Clip on match win",
            description = "Trigger a clip when you win the LMS match",
            section = SECTION_LMS,
            position = 1
    )
    default boolean lmsFinalWinClip()
    {
        return true;
    }
}
