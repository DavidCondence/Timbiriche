package Negocio; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
 
public class Player implements Serializable { 
    UUID id;
    String name;
    int points;
    boolean ready; 

    public Player() {
    }
    
    public Player(UUID id, String name){
        this.id = id;
        this.name = name;
    }
    public Player(UUID id, String name, int points, boolean ready) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.ready = ready;
    }

    public void drawMove() {
        
    }
    
    public void leaveSession() {
        
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }  
    public Player getPlayer(ArrayList<Player> jugadores, String nickname){
        Player player = null;
        for (int i = 0; i < jugadores.size(); i++) 
            if (jugadores.get(i).getName().equals(nickname)) 
                player =  jugadores.get(i);  
        return player;
    }
    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", points=" + points + ", ready=" + ready + '}';
    }
    
}