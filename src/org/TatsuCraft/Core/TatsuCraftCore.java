package org.TatsuCraft.Core;

import org.TatsuCraft.Core.Commands.BukkitCommandHandler;
import org.TatsuCraft.Core.Commands.NoSlash.Command_ban;
import org.TatsuCraft.Core.Commands.Command_kick;
import org.TatsuCraft.Core.Commands.Command_promote;
import org.TatsuCraft.Core.Listener.TatsuCraftListener;
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
        logger.info("TatsuCraftCore made by tylerhyperHD, xDestroyer217, Revalation, Oliver and ImALuckyGuy");
        BukkitLib.init(plugin);
        config.load();
        logger.setDebugMode(config.getBoolean("debug"));
        logger.debug("Debug mode enabled!");

        handler.setCommandLocation(Command_kick.class.getPackage());
        handler.setCommandLocation(Command_ban.class.getPackage());
        handler.setCommandLocation(Command_promote.class.getPackage());
        
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
