package net.pravian.bukkitlib.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
    public static final List<ChatColor> CHAT_COLOR_POOL = Arrays.asList(
            ChatColor.DARK_BLUE,
            ChatColor.DARK_GREEN,
            ChatColor.DARK_AQUA,
            ChatColor.DARK_RED,
            ChatColor.DARK_PURPLE,
            ChatColor.DARK_GRAY,
            ChatColor.GOLD,
            ChatColor.BLACK,
            ChatColor.BLUE,
            ChatColor.GREEN,
            ChatColor.AQUA,
            ChatColor.RED,
            ChatColor.LIGHT_PURPLE,
            ChatColor.YELLOW);
    private static final Random RANDOM = new Random();

    private ChatUtils() {
    }

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('§', ChatColor.translateAlternateColorCodes('&', string));
    }

    public static ChatColor randomChatColor() {
        return CHAT_COLOR_POOL.get(RANDOM.nextInt(CHAT_COLOR_POOL.size()));
    }

    public static void messagePlayers(String message, String permission, Collection<Player> players) {
        for (Player player : players) {
            if (permission.isEmpty() || player.hasPermission(permission)) {
                player.sendMessage(message);
            }
        }
    }
}