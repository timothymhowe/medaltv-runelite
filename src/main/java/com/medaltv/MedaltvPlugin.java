package com.medaltv;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import net.runelite.api.Varbits;
import net.runelite.api.gameval.VarbitID;


@Slf4j
@PluginDescriptor(
        name = "Medaltv"
)
public class MedaltvPlugin extends Plugin {

    private static final int WILDERNESS_VARBIT_ID = 6549;

    @Inject
    private Client client;

    @Inject
    private MedaltvConfig config;

    private boolean wasInWildy = false;

    @Override
    protected void startUp() throws Exception
    {
        log.debug("Medaltv Plugin, ready for launch!");
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.debug("Medaltv Plugin shutting down. ");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example plugin:  Sup,  " + config.dropValue(), null);
        }
    }

    @Subscribe
    public void onVarbitChanged(VarbitChanged e) {

        if (e.getVarbitId() == WILDERNESS_VARBIT_ID) {
            log.info("Varbit changed:" + e.getVarbitId());

            boolean nowInWildy = e.getValue() > 0;
            if (isInWildy()) {
                client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "WELCOME TO THE WILDY. " + e.getValue(), null);

            }

        }
    }

    private boolean isInWildy(){
        return client.getVarbitValue(WILDERNESS_VARBIT_ID) > 0;
    }

    @Provides
    MedaltvConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(MedaltvConfig.class);
    }
}
