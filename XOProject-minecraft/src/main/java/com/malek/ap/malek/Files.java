package com.malek.ap.malek;

import java.io.*;

public class Files {

    private static int counter = 0 ;

    public static  void save (FullGames games){
        try {
            ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream("Games.txt"));
            o.writeObject(games);
            o.close();
        } catch (FileNotFoundException e) {
            System.out.println("nnt saved");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static FullGames readGames(){
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Games.txt"));) {

            FullGames games = (FullGames) oi.readObject();
            oi.close();
            System.out.println("games have loaded");
            return games;
        } catch (FileNotFoundException e) {
            System.out.println("games not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
