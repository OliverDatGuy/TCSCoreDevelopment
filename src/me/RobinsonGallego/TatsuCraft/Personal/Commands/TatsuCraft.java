package me.RobinsonGallego.TatsuCraft.Personal.Commands;

import org.TatsuCraft.Core.TatsuCraftCore;
import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.command.CommandPermissions;
import net.pravian.bukkitlib.command.SourceType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandPermissions(source = SourceType.ANY, permission = "")
public class TatsuCraft extends BukkitCommand<TatsuCraftCore>
{
    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args)
    {      
        sender.sendMessage("This is for the plugin");
        sender.sendMessage("This is a test command");
        sender.sendMessage("Why are you here?");
        sender.sendMessage("Just ignore me.");
        return true;
    }
}