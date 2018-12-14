package Negocio; 

import java.util.ArrayList;
import java.util.UUID;
import Negocio.Player;

public class GameSession {
    
    boolean active;
    
    public void addPlayer(ArrayList players, Player E) { 
        if (validatePlayer(players, E)) {
            players.add(E); 
        } 
    }
    public void showPlayers(ArrayList<Player> players){ 
        if (players != null) { 
            for (Player ply : players) {
                System.out.println("---------------");
                System.out.println(ply.getId());
                System.out.println(ply.getName()); 
            }
        } else {
            System.out.println("No hay players disponibles.");
        }
    }
    
    public boolean validatePlayer(ArrayList<Player> players, Player p) {
        if (players.size() < 3) {
        
        for (Player player: players) {
            if (player.getName() == p.getName()) {  
                return false;
            }
        } 
        return true;
        } else {
            return false;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}