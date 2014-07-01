package co.justgame.ranktab.tabcolor;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import co.justgame.ranktab.main.RankTab;


public class TabColor {
    
    public static String getTabColor(Player p){
        Chat chat = RankTab.getChat();
            if(chat != null){
                if(Bukkit.getServer().getPluginManager().getPlugin("CubeEngine") != null){
                    if(Bukkit.getServer().getPluginManager().getPlugin("CubeEngine").isEnabled()){
                        String world = null;
                        try{
                            String prefix = chat.getPlayerInfoString(world, p.getName(), "prefix", "");
                            if(prefix != null && prefix.length() >= 2){
                                String colorCode = getFirstTwoChars(prefix); 
                                if(isColorCode(colorCode)){
                                    return formatString(colorCode);
                                }else{
                                    return "";
                                }
                            }else{
                                return "";
                            }
                        }catch (Exception e){
                           Bukkit.getConsoleSender().sendMessage("[RankTab] "
                                            + formatString("&cCaught Exception: " + e.toString() + " Message:"
                                                    + e.getMessage()+" Cause: " + e.getCause()));
                            return "";
                        }
                    }
                }

                String prefix = chat.getPlayerPrefix(p);
                if(prefix != null){
                    String colorCode = getFirstTwoChars(prefix); 
                    if(isColorCode(colorCode)){
                        return formatString(colorCode);
                    }else{
                        return "";
                    }
                }else{
                    return "";
                }
            }else{
                return "";
            }
    }

    private static String formatString(String string){
        return string.replace("&", "§");
    }
    
    private static String getFirstTwoChars(String s){
        return s.substring(0, 2);
    }
    
    private static boolean isColorCode(String s){
        return s.contains("&") && !s.contains(" ");
    }
}



