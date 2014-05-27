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
        if(isColorCode(color))
            p.setPlayerListName(color+abbreviate(p.getDisplayName()));
    }
    
    private boolean isColorCode(String color){
        return color.contains("§") && !color.equals("§r") && !color.equals("§f");
    }
    
    private String abbreviate(String name){
        StringBuilder newName = new StringBuilder(name);
        if(name.length() > 14){
            for(int i = 0; i < (name.length() - 12); i++){
                newName.deleteCharAt(newName.length() - 1);
            }
            newName.append("..");
            return newName.toString();
        }
        return name;
    }
}
