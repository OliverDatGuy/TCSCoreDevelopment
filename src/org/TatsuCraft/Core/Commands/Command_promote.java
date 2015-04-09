package org.TatsuCraft.Core.Commands;

import org.TatsuCraft.Core.TC_Messages;
import org.TatsuCraft.Core.TatsuCraftCore;
import net.pravian.bukkitlib.util.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandPermissions(source = SourceType.ANY, permission = "tatsucraftcore.promote")
@CommandParameters(description = "Promotes a player.", usage = "/promote <player> <reason>")
public class Command_promote extends BukkitCommand<TatsuCraftCore>
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

        else if (args[1].equalsIgnoreCase("admin"))
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
        else if (args[1].equalsIgnoreCase("senioradmin"))
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
        else if (args[1].equalsIgnoreCase("jradmin"))
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
        else if (args[1].equalsIgnoreCase("regadmin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " regadmin");
            player.setOp(true);
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Admin! Congrats :D");
            return true;
        }
        else if (args[1].equalsIgnoreCase("sradmin"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + player.getName() + " sr.admin");
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "TatsuSCore" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + player.getName() + TC_Messages.PROMOTE + ChatColor.RED + " Sr. Admin! Congrats :D");
            return true;
        }
    
return true;
}
}
