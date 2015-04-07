package com.tylerhyper.utils.core.commands;

import com.tylerhyper.utils.core.TC_Messages;
import net.pravian.bukkitlib.util.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_promote extends BukkitCommand 
{
    @Override
    public boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
           OfflinePlayer player = PlayerUtils.getOfflinePlayer(args[0]);
        
        if (player == null)
        {
            sender.sendMessage(TC_Messages.NO_PLAYER);
            return true;
        }

        if (args[1].equalsIgnoreCase("developer"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " developer");
            player.setOp(true);
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Developer! Good Coding! Congrats :D");
            return true;

        }

        else if (args[1].equalsIgnoreCase("Admin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " admin");
            player.setOp(true);
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Jr. Mod, Congrats :D");
            return true;

        }
        if (args[1].equalsIgnoreCase("telnetadmin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " telnetadmin");  
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Moderator! Congrats :D");
            return true;

        }
        else if (args[1].equalsIgnoreCase("SeniorAdmin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " senioradmin");
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Sr. Mod, Congrats :D");
            return true;
        }

        if (args[1].equalsIgnoreCase("owner"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " owner");
            player.setOp(true);
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Owner, OMG, LOLOLOL, Congrats :D");
            return true;

        }
        else if (args[1].equalsIgnoreCase("jr.admin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " jr.admin");
            player.setOp(true);           
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Jr. Admin! Congrats :D");
            return true;

        }
        else if (args[1].equalsIgnoreCase("unused"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " unused");
            player.setOp(true);           
           Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " HOST!! Congrats :D");
            return true;
        }
        else if (args[1].equalsIgnoreCase("RegAdmin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " regadmin");
            player.setOp(true);
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Admin! Congrats :D");
            return true;
        }
        else if (args[1].equalsIgnoreCase("Sr.Admin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " sr.admin");
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Sr. Admin! Congrats :D");
            return true;
        }
    
return true;
}
}
