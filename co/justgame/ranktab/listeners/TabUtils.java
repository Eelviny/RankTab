package co.justgame.ranktab.listeners;


public class TabUtils {
    
    public static boolean isColorCode(String color){
        return color.contains("§") && !color.equals("§r") && !color.equals("§f");
    }
    
    public static String abbreviate(String name){
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
