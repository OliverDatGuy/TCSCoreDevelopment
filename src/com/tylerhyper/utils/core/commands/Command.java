package com.tylerhyper.utils.core.commands;

import com.tylerhyper.utils.core.TatsuCraftCore;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class Command
{
    protected TatsuCraftCore plugin;
    protected Server server;
    private CommandSender commandSender;
    private Class<?> commandClass;

    public Command()
    {
    }

    abstract public boolean run(final CommandSender sender, final Player sender_p, final Command cmd, final String commandLabel, final String[] args, final boolean senderIsConsole);

    public void setup(final TatsuCraftCore plugin, final CommandSender commandSender, final Class<?> commandClass)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
        this.commandSender = commandSender;
        this.commandClass = commandClass;
    }
}
