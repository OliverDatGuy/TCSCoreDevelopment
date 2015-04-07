
package org.TatsuCraft.Core.Modules;

import org.TatsuCraft.Core.TC_Utils;
import org.TatsuCraft.Core.TatsuCraftCore;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat extends TatsuCraftModule
{
    public AdminChat(TatsuCraftCore plugin) 
    {
        super(plugin);
    }
    
    public static void chat(CommandSender sender, String message)
    {
        for (Player p : Bukkit.getOnlinePlayers())
        {
            if (TC_Utils.ADMINS.contains(sender.getName()))
            {
                p.sendMessage("§f[§aStaff Chat§f] §7" + sender.getName() + " §a§b>>  §f" + message);
            }
        }
    }
}