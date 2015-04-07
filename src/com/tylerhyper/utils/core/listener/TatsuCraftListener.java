package com.tylerhyper.utils.core.listener;

import com.tylerhyper.utils.core.TatsuCraftCore;
import static com.tylerhyper.utils.core.TatsuCraftCore.MODPREFIX;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TatsuCraftListener implements Listener {
    private final TatsuCraftCore plugin;

    public TatsuCraftListener(TatsuCraftCore instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (plugin.getConfig().getString("remove_join_listeners").equals("false")){
        plugin.getLogger().info(MODPREFIX + event.getPlayer().getName() + " has left the server.");
        }
        else {}
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (plugin.getConfig().getString("remove_join_listeners").equals("false")){
        plugin.getLogger().info(MODPREFIX + event.getPlayer().getName() + " has joined the server.");
        }
        else {}
    }
}
