package com.malek.ap.malek;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.ArrayList;

public class save implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            ArrayList<Game> games = FullGames.games;
            FullGames allGames = new FullGames();

            FullGames.setGames(games);
            Files.save(allGames);
            challenge.player1.sendMessage(((Player) commandSender).getDisplayName() +" have saved the game");
            challenge.player2.sendMessage(((Player) commandSender).getDisplayName() +" have saved the game");
        }



        return false;
    }
}
