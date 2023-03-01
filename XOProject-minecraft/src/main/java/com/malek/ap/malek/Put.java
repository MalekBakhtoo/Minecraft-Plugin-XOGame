package com.malek.ap.malek;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Put implements CommandExecutor {

    public static void blockSetter(){

        int[] puts = Game.chooses;
        int counter = 0;
        for (Location location : Accept.locations) {
            if(puts[counter]==1){
                location.getBlock().setType(Material.BLUE_WOOL);
            }else if (puts[counter]==2){
                location.getBlock().setType(Material.RED_WOOL);
            }
            counter++;
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player1 = Game.game.player1;
        Player player2 = Game.game.player2;



        if (commandSender instanceof  Player){
            int ch ;
            try {
                ch = Integer.parseInt(strings[0]);
                if (commandSender==player1 && Game.counter%2 ==0) {
                    Game.game.choose(ch);
                    blockSetter();
                    return true;
                }else if (commandSender==player1 && Game.counter%2 ==1){
                    commandSender.sendMessage("not your turn");
                }else if (commandSender==player2 && Game.counter%2 ==1) {
                    Game.game.choose(ch);
                    blockSetter();
                    return true;
                }else if (commandSender==player2 && Game.counter%2 ==0){
                    commandSender.sendMessage("not your turn");
                }
            }catch (TypeNotPresentException e){
                commandSender.sendMessage("inter an int after 'put' command");
                return false;
            }
        }
        return false;
    }
}
