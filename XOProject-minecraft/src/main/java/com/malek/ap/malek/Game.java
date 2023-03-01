package com.malek.ap.malek;

import org.bukkit.Location;
import org.bukkit.entity.Player;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class Game implements Serializable {

    private String PlayerName1 ="";
    private String PlayerName2 ="" ;
    public static Game game = null;
    public static int[] chooses = new int[9];
    private String GameName ;
    Player player1 ;
    Player player2 ;
    ArrayList<Location> locationsWall ;
    ArrayList<Location> roof ;

    public Game(Player player1,Player player2 ,ArrayList<Location> locations,ArrayList<Location> roof) {
        this.PlayerName1 = player1.getDisplayName();
        this.PlayerName2 = player2.getDisplayName();
        this.player1 = player1;
        this.player2 = player2;
        game =this;
        this.locationsWall = locations;
        this.roof = roof;
    }

    public String getPlayerName1() {
        return PlayerName1;
    }

    public String getPlayerName2() {
        return PlayerName2;
    }

    public void setPlayerName1(String playerName1) {
        PlayerName1 = playerName1;
    }

    public void setPlayerName2(String playerName2) {
        PlayerName2 = playerName2;
    }

    public int[] getChooses() {
        return chooses;
    }

    public void setChooses(int[] chooses) {
        this.chooses = chooses;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getGameName() {
        return GameName;
    }

    public Player FindWinner() {
        if (chooses[0] == 1 && chooses[5] == 1 && chooses[7] == 1) {
            return player1;
        }
        //} else if (chooses[2] == 1 && chooses[3] == 1 && chooses[7] == 1) {

          //  return player1;
//        } else if (chooses[6] == 1 && chooses[] == 1 && chooses[8] == 1) {
//
//            return player1;
//        } else if (chooses[0] == 1 && chooses[4] == 1 && chooses[8] == 1) {
//
//            return player1;
//        } else if (chooses[2] == 1 && chooses[4] == 1 && chooses[6] == 1) {
//            return player1;
//        } else if (chooses[2] == 1 && chooses[8] == 1 && chooses[5] == 1) {
//
//            return player1;
//        } else if (chooses[1] == 1 && chooses[4] == 1 && chooses[7] == 1) {
//
//            return player1;
//        } else if (chooses[0] == 1 && chooses[3] == 1 && chooses[6] == 1) {
//
//            return player1;
//        }
//        else if (chooses[0] == 2 && chooses[1] == 2 && chooses[2] == 2) {
//            return player2;
//        } else if (chooses[3] == 2 && chooses[4] == 2 && chooses[5] == 2) {
//            return player2;
//        } else if (chooses[6] == 2 && chooses[7] == 2 && chooses[8] == 2) {
//            return player2;
//        } else if (chooses[0] == 2 && chooses[4] == 2 && chooses[8] == 2) {
//            return player2;
//        } else if (chooses[2] == 2 && chooses[4] == 2 && chooses[6] == 2) {
//            return player2;
//        } else if (chooses[2] == 2 && chooses[8] == 2 && chooses[5] == 2) {
//
//            return player2;
//        } else if (chooses[1] == 2 && chooses[4] == 2 && chooses[7] == 2) {
//
//            return player2;
//        } else if (chooses[0] == 2 && chooses[3] == 2 && chooses[6] == 2) {
//
//            return player2;
//        }
        return null;
    }


    public static int counter = 0;

    public void choose(int ch) {
        if (FindWinner() == null) {
            if (counter <= 8) {
                if (chooses[ch - 1] == 0) {
                    if (counter % 2 == 0) {
                        chooses[ch - 1] = 1;
                        if (FindWinner() != null) {
                            player1.sendMessage("\ngame have finished winner is : " + FindWinner().getDisplayName()+"\n");
                            player2.sendMessage("\ngame have finished winner is : " + FindWinner().getDisplayName()+"\n");
                        }
                        else {
                            player1.sendMessage("\n" +player2.getDisplayName() + " turn\n");
                            player2.sendMessage("\n" +player2.getDisplayName() + " turn\n");

                        }
                    } else if(counter%2==1) {
                        chooses[ch - 1] = 2;
                        if (FindWinner() != null) {
                            player1.sendMessage("\ngame have finished winner is : " + FindWinner().getDisplayName()+"\n");
                            player2.sendMessage("\ngame have finished winner is : " + FindWinner().getDisplayName()+"\n");
                        }
                        else {
                            player1.sendMessage("\n" +player1.getDisplayName() + " turn\n");
                            player2.sendMessage("\n" +player1.getDisplayName() + " turn\n");

                        }
                    }
                    counter++;
                } else {
                    if (counter % 2 ==0) {
                        player1.sendMessage("\nchoose another place this place have been fulled before\n");
                    }else {
                        player2.sendMessage("\nchoose another place this place have been fulled before\n");
                    }
                }
            } else {
                player1.sendMessage("\ngame have finished with no winner \n");
                player2.sendMessage("\ngame have finished with no winner \n");
            }
        }
    }
    public void save(){
        FullGames.addGame(this);
    }

    public boolean finishCheck(){
        return (counter>8 || FindWinner() != null);
    }

    public static void  reloadGame(){
        chooses = new int[9];
        counter =0;
    }
}