package com.malek.ap.malek;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class denyChallenge implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            challenge.player1.sendMessage(challenge.player2.getDisplayName() + " have reject your challenge ");
            return true;
        }
        return false;
    }
}
