package me.RobinsonGallego.PersonalCommands;

import org.TatsuCraft.Core.TatsuCraftCore;
import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.command.CommandPermissions;
import net.pravian.bukkitlib.command.SourceType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandPermissions(source = SourceType.PLAYER, permission = "")
public class rules extends BukkitCommand<TatsuCraftCore>
{
    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args)
    {     
        //I need the rules. @ImALuckyGuy
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        return true;
    }
}