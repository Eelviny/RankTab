package co.justgame.ranktab.main;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import co.justgame.ranktab.listeners.Listeners;


public class RankTab extends JavaPlugin{
    
    public static Chat chat = null;
    
    @Override
    public void onEnable(){
        getLogger().info("RankTab has been enabled!");
        setupChat();
        getServer().getPluginManager().registerEvents(new Listeners(), this);
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
