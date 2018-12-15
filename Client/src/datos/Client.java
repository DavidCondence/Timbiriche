package Datos;
 
 
import Interfaz.Cliente;
import Negocio.*; 
import java.net.*;
import java.io.*;
import java.util.*;
 
public class Client implements GameEventListener  { 
    public ObjectInputStream sInput;		// to read from the socket
    public ObjectOutputStream sOutput;		// to write on the socket
    public Socket socket; 
    public Cliente cg;  
    public String server, username;
    public UUID uuid;
    public int port; 
    public Client(String server, int port, String username, UUID uuid) { 
        this(server, port, username, uuid, null);
    } 
    public Client(String server, int port, String username,UUID uuid, Cliente cg) {
        this.server = server;
        this.port = port;
        this.username = username; 
        this.uuid = uuid;
        this.cg = cg; 
    } 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public boolean start() { 
        try {
            socket = new Socket(server, port);
        }  
        catch(Exception ec) {
            display("Error connectiong to server:" + ec);
            return false;
        }

        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        display(msg); 
        try {
            sInput  = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            display("Exception creating new Input/output Streams: " + eIO);
            return false;
        } 
        new ListenFromServer().start(); 
        try {
            sOutput.writeObject(username); 
        }
        catch (IOException eIO) {
            display("Exception doing login : " + eIO);
            disconnect();
            return false;
        } 
        return true;
    } 
    public void display(String msg) {
        if(cg == null) {
            System.out.println(msg);
            
        } else {
            //cg.append(msg + "\n"); 
             
        } 
    }
    public void enviarEvent(GameEvent msg) {
        try {
            sOutput.writeObject(msg);
            sOutput.reset();
            
        }
        catch(IOException e) {
            display("Exception writing to server: " + e);
        }
    } 
    public void sendMessage(String msg) {
        try {
            sOutput.writeObject(msg);
            
        }
        catch(IOException e) {
            display("Exception writing to server: " + e);
        }
    }
    public void enviarCorreo(Mensaje mensaje){
        try {
            sOutput.writeObject(mensaje);
        }
        catch(IOException e) {
            display("Exception writing to server: " + e);
        }
    }
    public void disconnect() {
        try { 
                if(sInput != null) sInput.close();
        }
        catch(Exception e) {} 
        try {
                if(sOutput != null) sOutput.close();
        }
        catch(Exception e) {} 
        try{
            if(socket != null) socket.close();
        } catch(Exception e) {}  
            if(cg != null)
                System.out.println("eee");
                //cg.connectionFailed(); 
    }  

    @Override
    public void playerRequestJoin(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void usernameTaken(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePlayerList(GameEvent event) {
        ArrayList<Player> players;
        players = event.getPlayerList(); 
        if(cg == null) { 
        } else {
            cg.updatePlayers(players); 
        }  
    }

    @Override
    public void sessionFull(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveLobby(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playerLeftLobby(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void allPlayersReady(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionHasStarted(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateView(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveSession(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playerLeftSession(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gameOver(GameEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    GameEvent gameEvent; 
    public class ListenFromServer extends Thread { 
        public void run() {
            while(true) {
                try {
                    gameEvent = (GameEvent) sInput.readObject();  
                    /**
                    updatePlayerList(gameEvent);
                    System.out.println(gameEvent);
                    if(cg == null) {
                        System.out.println(gameEvent.toString());
                        System.out.print("> ");
                    }
                    * */
                }
                catch(IOException e) {
                    display("Server has close the connection: " + e);
                    if(cg != null) 
                        //cg.connectionFailed();
                    break;
                } 
                catch(ClassNotFoundException e2) {
                }
                switch(gameEvent.getType()) { 
                    case GameEvent.UPDATELIST:
                        updatePlayerList(gameEvent); 
                        break; 
                    case GameEvent.SESSIONFULL:
                        disconnect();
                        cg.handleSessionFull();
                        System.out.println("Session full. Calling handler...");
                        break; 
                        
                    case GameEvent.USERNAMEOK:
                        System.out.println("User OK");  
                        break; 
                        
                    case GameEvent.USERNAMETAKEN: 
                        System.out.println("Get player ID: "+gameEvent.getPlayer().getId());
                        System.out.println("Session ID :"+uuid);
                        if (gameEvent.getPlayer().getId().equals(uuid)) { 
                            cg.connectionFailed();
                        } 
                        
                        break; 
                    default: 
                        updatePlayerList(gameEvent);
                     break;
                }
            }
        }
    }
}
