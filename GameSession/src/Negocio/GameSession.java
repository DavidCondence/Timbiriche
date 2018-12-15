package Negocio; 

import java.util.ArrayList;
import java.util.UUID;
import Negocio.Player;

public class GameSession {
    
    boolean active;
    
   
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
    
    public GameEvent validatePlayer(ArrayList<Player> players, Player p) { 
        if (players.size() < 4) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(p.getName())) { 
                    return new GameEvent(4); // Nombre Repetido
                } 
            } 
            return new GameEvent(12); //USERNAMEOK
        } else {
            return new GameEvent(2); //Session full
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}