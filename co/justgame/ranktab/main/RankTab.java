package co.justgame.ranktab.main;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import co.justgame.ranktab.listeners.Listeners;
import co.justgame.ranktab.listeners.TabUtils;
import co.justgame.ranktab.tabcolor.TabColor;


public class RankTab extends JavaPlugin{
    
    public static Chat chat = null;
    
    @Override
    public void onEnable(){
        getLogger().info("RankTab has been enabled!");
        setupChat();
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        
        for(Player p: Bukkit.getOnlinePlayers()){
            String color = TabColor.getTabColor(p);
            if(TabUtils.isColorCode(color))
                p.setPlayerListName(color+TabUtils.abbreviate(p.getDisplayName()));
        }
    }
    
    @Override
    public void onDisable(){
        getLogger().info("RankTab has been disabled!");
    }
    
    public static Chat getChat(){
        return chat;
    }
    
    private void setupChat(){
        if(getServer().getPluginManager().getPlugin("Vault") != null){
            RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager()
                    .getRegistration(net.milkbowl.vault.chat.Chat.class);
            if(rsp != null){
                chat = rsp.getProvider();
            }
        }
    }
}
