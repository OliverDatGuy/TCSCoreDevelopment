package com.tylerhyper.utils.core.commands;

import com.tylerhyper.utils.core.TatsuCraftCore;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(source = SourceType.ANY, permission = "tatsucraftcore.kick")
@CommandParameters(description = "Kicks a player.", usage = "/kick <player> <reason>")
public class Command_kick extends BukkitCommand<TatsuCraftCore>
{
    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) 
    {
        if (args.length == 0)
        {
            return false;
        }
        final Player player = getPlayer(args[0]);
        if (player == null)
        {
            sender.sendMessage("Player not found!");
            return true;
        }
        String reason = null;
        if (args.length >= 2)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        }
        
        if (args.length == 1)
        {
            player.getPlayer().kickPlayer("You have been kicked for\n" + reason);
        }
        
        return true;
    }
}
