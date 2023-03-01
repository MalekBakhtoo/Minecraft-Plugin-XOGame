package com.malek.ap.malek;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Accept implements CommandExecutor {


    static ArrayList<Location> locations = new ArrayList<>();
    static ArrayList<Location> loc = new ArrayList<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Game.counter =0;
        if (sender instanceof Player) {
            Player player2 =(Player) sender;
            if (player2.equals(challenge.player2)){
                Player player1 = challenge.player1;

                World world = player1.getWorld();

                int x = player1.getLocation().getBlockX();
                int y = player1.getLocation().getBlockY();
                int z = player1.getLocation().getBlockZ();




                for (int i = -5 ; i <5 ; i++){
                    for ( int k=-5 ; k <5 ; k++){
                        loc.add(new Location(world ,x+i, y +12 , z + k ));
                    }
                }
                for (Location location : loc){
                    location.getBlock().setType(Material.WHITE_WOOL);
                }
                player1.teleport(loc.get(15).add(0,1,0));
                player2.teleport(loc.get(18).add(0, 1 , 0));
                x = player1.getLocation().getBlockX();
                y = player1.getLocation().getBlockY();
                z = player1.getLocation().getBlockZ();

                for ( int  i =2 ; i >=0 ;i--  ){
                    for ( int j =1 ; j<=3 ; j++ ){
                        locations.add(new Location(world,x+j,y+i , z+3));
                    }
                }

                for (Location location : locations){
                    location.getBlock().setType(Material.WHITE_WOOL);
                }
                Game game = new Game(player1 , player2,locations,loc);
                player1.sendMessage(player2.getDisplayName() + " have accept your invite \ngood luck");
                player2.sendMessage("you have accept the challenge good luck... ");
                return true;
            }else {
                player2.sendMessage("no challenge");
                return true;
            }
        }
        return false;
    }
}