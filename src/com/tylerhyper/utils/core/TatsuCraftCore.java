package com.tylerhyper.utils.core;

import com.tylerhyper.utils.core.commands.BukkitCommandHandler;
import com.tylerhyper.utils.core.commands.Command_kick;
import com.tylerhyper.utils.core.listener.TatsuCraftListener;
import java.io.File;
import net.pravian.bukkitlib.BukkitLib;
import net.pravian.bukkitlib.config.YamlConfig;
import net.pravian.bukkitlib.implementation.BukkitLogger;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TatsuCraftCore extends BukkitPlugin {
    //
    public ListStore bannedPlayers;
    //
    public static final String MODPREFIX = "[TatsuCraftCore] ";
    public static TatsuCraftCore plugin;
    public BukkitLogger logger;
    public YamlConfig config;
    public BukkitCommandHandler handler;
    private final TatsuCraftListener playerListener = new TatsuCraftListener(this);
    //
    
    @Override
    public void onLoad() {
        this.plugin = this;
        this.logger = new BukkitLogger(plugin);
        this.config = new YamlConfig(plugin, "config.yml");
        this.handler = new BukkitCommandHandler(plugin);
    }
    
    @Override
    public void onEnable() {
        logger.info("TatsuCraftCore made by tylerhyperHD");
        BukkitLib.init(plugin);
        config.load();
        logger.setDebugMode(config.getBoolean("debug"));
        logger.debug("Debug mode enabled!");

        handler.setCommandLocation(Command_kick.class.getPackage());
        
        String pluginFolder = this.getDataFolder().getAbsolutePath();
        (new File(pluginFolder)).mkdir();
        this.bannedPlayers = new ListStore(new File(pluginFolder + File.separator + "banned-players.txt"));
        this.bannedPlayers.load();
        
        logger.info(plugin.getName() + " v" + plugin.getVersion() + " is enabled");
    }
    
    @Override
    public void onDisable() {
        this.bannedPlayers.save();
        logger.info(plugin.getName() + " is disabled");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return handler.handleCommand(sender, cmd, commandLabel, args);
    }
}
