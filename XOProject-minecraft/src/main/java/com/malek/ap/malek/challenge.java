package com.malek.ap.malek;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class challenge implements CommandExecutor {

    public static Player player1 ;
    public static Player player2 ;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            player1 = (Player) sender;
            if (args.length ==0 ){
                player1.sendMessage("enter a name...");
                return true;
            }
            if (player1.getDisplayName().equals(args[0])){
                player1.sendMessage("you cannot challenge yourself");
                return true;
            }
            for ( Player player : Bukkit.getServer().getOnlinePlayers()){
                if (player.getName().equals(args[0])){
                    player2 = player;
                    player2.sendMessage(player1.getDisplayName() + " have invite you to a tik tak toe game ...");
                    return true;
                }
            }
            player1.sendMessage("not found this player");
            return true;
        }
        return false;
    }
}
