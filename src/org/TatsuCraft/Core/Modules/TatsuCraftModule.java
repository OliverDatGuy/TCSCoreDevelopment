package org.TatsuCraft.Core.Modules;

import org.TatsuCraft.Core.TatsuCraftCore;
import org.bukkit.Server;

public class TatsuCraftModule
{

    protected final TatsuCraftCore plugin;
    protected final Server server;

    public TatsuCraftModule(TatsuCraftCore plugin)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
    }
}