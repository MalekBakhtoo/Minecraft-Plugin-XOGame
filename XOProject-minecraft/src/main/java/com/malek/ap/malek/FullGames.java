package com.malek.ap.malek;

import java.util.ArrayList;
import java.util.Objects;

public class FullGames {

    public static ArrayList<Game> games = new ArrayList<>();

    public static   void addGame(Game game){
        game.setGameName(gameName(game));
        games.add(game);
    }
    public  Game FindGame(String GameName){
        for( Game i : games){
            if (Objects.equals(i.getGameName(), GameName)){
                return i;
            }
        }
        return null;
    }
    public static String gameName(Game game){
        int numb = 0 ;
        String name = game.getPlayerName1() +" "+game.getPlayerName2();
        String name2;
        for (Game i : games){

             name2 = i.getPlayerName1() +" "+ i.getPlayerName2();
            if (name.equals(name2)){
                numb =Integer.parseInt( i.getGameName().split(" ")[2]);
            }
        }
        return name + " " + numb++;
    }
    public  void save(){
        Files.save(this);
    }

    public static void setGames(ArrayList<Game> games) {
        FullGames.games = games;
    }
}
