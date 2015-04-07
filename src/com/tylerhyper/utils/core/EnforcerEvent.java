package com.tylerhyper.utils.core;
 
import java.lang.ProcessBuilder.Redirect.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
 
public class EnforcerEvent extends Event {
 
        Player p;
        Type t;
       
        public EnforcerEvent(Player p, Type t) {
                this.p = p;
                this.t = t;
        }

    public EnforcerEvent(Player player, com.tylerhyper.utils.core.Type type)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
        public Player getPlayer() {
                return p;
        }
       
        public Type getType() {
                return t;
        }
       
        private static final HandlerList handlers = new HandlerList();
         
        public HandlerList getHandlers() {
            return handlers;
        }
         
        public static HandlerList getHandlerList() {
            return handlers;
        }
}