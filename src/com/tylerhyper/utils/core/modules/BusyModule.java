package com.tylerhyper.utils.core.modules;

import com.tylerhyper.utils.core.modules.TatsuCraftModule;
import java.util.ArrayList;
import java.util.List;
import com.tylerhyper.utils.core.TatsuCraftCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BusyModule extends TatsuCraftModule implements Listener
{
    public BusyModule(TatsuCraftCore plugin) 
    {
        super(plugin);
    }
    
    static List<String> busyAdmins = new ArrayList<>();
    
    public static void toggleBusyPlayer(Player player)
    {
        if (busyAdmins.contains(player.getName()))
        {
            busyAdmins.remove(player.getName());
            player.sendMessage(ChatColor.GREEN + "You have toggled busy status off.");
            player.chat("/ne clear " + player.getName());
        }
        else
        {
            busyAdmins.add(player.getName());
            player.sendMessage(ChatColor.GREEN + "You have toggled busy status on.");
            player.chat("/ne prefix " + player.getName() + " &7");
        }
    }
    
    public static boolean isBusy(Player player)
    {
        if (busyAdmins.contains(player.getName()))
        {
            return true;
        }
        
        return false;
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        busyAdmins.remove(event.getPlayer().getName());
    }
    
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        final String[] words = event.getMessage().split(" ");
        for (final String word : words)
        {
            Player player = Bukkit.getServer().getPlayer(word);
            
            if (player == null)
            {
                return;
            }
            
            if (BusyModule.isBusy(player))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "The admin " + player.getName() + " is busy. If you were trying to get his/her attention, please try again later.");
            }
        }
    }
    
    @EventHandler
    public void commandEvent(PlayerCommandPreprocessEvent event)
    {
        final String[] words = event.getMessage().split(" ");
        for (final String word : words)
        {
            final Player player = server.getPlayer(word);
            if (player == null)
            {
                continue;
            }
            
            if (BusyModule.isBusy(player))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "The admin " + player.getName() + " is busy. If you were trying to get his/her attention, please try again later.");
            }
        }
    }
}