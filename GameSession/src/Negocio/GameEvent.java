package Negocio;
import Negocio.Player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventObject; 
public class GameEvent implements Serializable {
    
    public static final int GENERIC=0, LOGINREQUEST=1, SESSIONFULL=2, JOINSUCCESS=3, USERNAMETAKEN=4, UPDATELIST=5, PLAYERREADY=6, STARTGAME=7,
            PLAYERLEFTSESSION=8, GAMEOVER=9, LEAVELOBBY=10, ALLPLAYERSREADY = 11;
    public int type;
    Player player; 
    ArrayList<Player> playerList = new ArrayList<Player>(3);
    
    public GameEvent(int type) {
        this.type = type;
    }
    
    public GameEvent(int type, Player player) {
        this.type = type;
        this.player = player;
    }
    
    public GameEvent(int type, ArrayList<Player> playerList) {
        this.type = type;
        this.playerList = playerList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    } 
    
    
}