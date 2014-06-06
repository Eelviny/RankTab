package co.justgame.ranktab.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import co.justgame.ranktab.tabcolor.TabColor;


public class Listeners implements Listener{
    
    @EventHandler(priority = EventPriority.NORMAL)
    public synchronized void onLogin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String color = TabColor.getTabColor(p);
        if(TabUtils.isColorCode(color))
            p.setPlayerListName(color+TabUtils.abbreviate(p.getDisplayName()));
    }
    
}
