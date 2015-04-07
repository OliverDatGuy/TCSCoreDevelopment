package com.tylerhyper.utils.core.commands;

import java.util.HashMap;
import java.util.Map;
import net.pravian.bukkitlib.InternalExceptionHandler;
import net.pravian.bukkitlib.implementation.BukkitLogger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class BukkitCommandHandler<T extends Plugin> {

    private final T plugin;
    private final BukkitLogger logger;
    private final Map<String, BukkitCommand<T>> commandCache;
    private boolean commandCaching;
    private String superPermission;
    private String onlyFromGameMessage;
    private String onlyFromConsoleMessage;
    private String permissionMessage;
    private String commandPrefix;
    private BukkitPermissionHolder permissionHolder;
    private String commandPath;

    public BukkitCommandHandler(T plugin) {
        this(plugin, new BukkitLogger(plugin));
    }

    public BukkitCommandHandler(T plugin, BukkitLogger logger) {
        this.plugin = plugin;
        this.logger = logger;
        this.commandCache = new HashMap<String, BukkitCommand<T>>();
        this.commandCaching = false;
        this.superPermission = plugin.getName().toLowerCase() + ".*";
        this.onlyFromGameMessage = ChatColor.YELLOW + "Only players may execute that command.";
        this.onlyFromConsoleMessage = ChatColor.YELLOW + "That command can only be executed from console.";
        this.permissionMessage = ChatColor.RED + "You don't have permission to use that command.";
        this.commandPrefix = "Command_";
        this.permissionHolder = null;
        this.commandPath = null;
    }

    public void setSuperPermission(String superPermission) {
        this.superPermission = superPermission;
    }

    public String getSuperPermission() {
        return superPermission;
    }

    public void setCommandLocation(Package commandLocation) {
        this.commandPath = commandLocation.getName();
    }

    public void setCommandPrefix(String prefix) {
        this.commandPrefix = prefix;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setPermissionMessage(String message) {
        this.permissionMessage = message;
    }

    public String getPermissionMessage() {
        return permissionMessage;
    }

    public void setOnlyConsoleMessage(String message) {
        this.onlyFromConsoleMessage = message;
    }

    public String getOnlyConsoleMessage() {
        return onlyFromConsoleMessage;
    }

    public void setOnlyGameMessage(String message) {
        this.onlyFromGameMessage = message;
    }

    public String getOnlyGameMessage() {
        return onlyFromGameMessage;
    }

    public void setPermissionHolder(BukkitPermissionHolder holder) {
        this.permissionHolder = holder;

        if (holder != null) {
            holder.initPermissions();
        }
    }

    public BukkitPermissionHolder getPermissionHolder() {
        return permissionHolder;
    }

    public T getPlugin() {
        return plugin;
    }

    public BukkitLogger getLogger() {
        return logger;
    }

    public void enableCommandCaching() {
        this.commandCaching = true;
    }

    public void clearCommandCache() {
        if (!commandCaching) {
            throw new IllegalStateException("Command caching is not enabled!");
        }

        commandCache.clear();
    }

    public BukkitCommand<?> getCachedCommand(Command command) {
        if (!commandCaching) {
            throw new IllegalStateException("Command caching is not enabled!");
        }

        return commandCache.get(command.getName());
    }

    @SuppressWarnings("unchecked")
    public boolean handleCommand(CommandSender sender, Command command, String commandLabel, String[] args) {

        final BukkitCommand<T> dispatcher;

        if (!commandCaching || !commandCache.containsKey(command.getName())) {
            try {
                dispatcher = (BukkitCommand<T>) BukkitCommandHandler.class.getClassLoader().loadClass(
                        String.format("%s.%s%s", commandPath, commandPrefix, command.getName().toLowerCase())).newInstance();

                dispatcher.setup(this, plugin, logger, sender, command, commandLabel, args, (Class<? extends BukkitCommand<T>>) dispatcher.getClass());

            } catch (Exception ex) {
                InternalExceptionHandler.handle(plugin, "Command not loaded: " + command.getName());
                InternalExceptionHandler.handle(plugin, ex);
                sender.sendMessage(ChatColor.RED + "Command Error: Command  " + command.getName() + " not loaded!");
                return true;
            }

        } else {
            dispatcher = commandCache.get(command.getName());
            dispatcher.setup(this, plugin, logger, sender, command, commandLabel, args, (Class<? extends BukkitCommand<T>>) dispatcher.getCommandClass());
        }

        // Store the command if caching is enabled.
        if (commandCaching && !commandCache.containsKey(command.getName())) {
            commandCache.put(command.getName(), dispatcher);
        }

        try {
            if (dispatcher.checkPermissions()) {
                return dispatcher.execute();
            }
        } catch (RuntimeException ex) {
            InternalExceptionHandler.handle(plugin, "Command Error: " + commandLabel);
            InternalExceptionHandler.handle(plugin, ex);
            sender.sendMessage(ChatColor.RED + "Command Error:  " + command.getName());
        } finally {
            dispatcher.reset();
        }
        return true;
    }
}