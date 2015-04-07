package com.tylerhyper.utils.core.modules;

import com.tylerhyper.utils.core.TatsuCraftCore;
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