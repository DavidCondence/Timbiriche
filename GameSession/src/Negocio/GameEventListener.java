/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.awt.Event;
import java.util.EventListener;

/**
 *
 * @author Admin
 */
public interface GameEventListener extends EventListener {
    
    public void playerRequestJoin(GameEvent event);
    
    public void usernameTaken(GameEvent event);
    
    public void updatePlayerList(GameEvent event);
    
    public void sessionFull(GameEvent event);
    
    public void leaveLobby(GameEvent event);
    
    public void playerLeftLobby(GameEvent event); 
    
    public void playerReady(GameEvent event);
    
    public void allPlayersReady(GameEvent event);
    
    public void sessionHasStarted(GameEvent event);
    
    public void updateView(GameEvent event);
    
    public void leaveSession(GameEvent event);
    
    public void playerLeftSession(GameEvent event);
    
    public void gameOver(GameEvent event);
    
    public void updateTablero(GameEvent event);
}