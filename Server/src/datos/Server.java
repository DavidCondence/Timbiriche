package datos;
 
import Interfaz.ServerGUI;
import Negocio.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*; 

public class Server implements GameEventListener{ 
    public static int uniqueId; 
    public ArrayList<ClientThread> clientThreadList; 
    public ServerGUI sg; 
    public SimpleDateFormat sdf; 
    public int port; 
    public boolean keepGoing; 
    public GameSession gs = new GameSession();
    public static ArrayList<Player>  jugadores = new ArrayList<Player>(3);
    public static ArrayList<Movimientos> movimientos = new ArrayList<Movimientos>();
    public int readyCounter = 0;
    public Player playerTmp = new Player();
    public Server(int port) {
            this(port, null);
    } 
    public Server(int port, ServerGUI sg) { 
            this.sg = sg; 
            this.port = port; 
            sdf = new SimpleDateFormat("HH:mm:ss"); 
            clientThreadList = new ArrayList<ClientThread>();
    } 
    public void start() {
        keepGoing = true; 
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(keepGoing) { 
                display("Server waiting for Clients on port " + port + "."); 
                Socket socket = serverSocket.accept();   
                if(!keepGoing)
                        break;
                ClientThread t = new ClientThread(socket); 
                clientThreadList.add(t); 
                t.start();
                t.writeMsg(new GameEvent(0, jugadores));
            } try {
                
                /**
                serverSocket.close();
                for(int i = 0; i < clientThreadList.size(); ++i) {
                    ClientThread tc = clientThreadList.get(i);
                    try {
                        tc.sInput.close();
                        tc.sOutput.close();
                        tc.socket.close();
                    }
                    catch(IOException ioE) {
                    }
                }
                */
            } catch(Exception e) {
                display("Exception closing the server and clients: " + e);
            }
        } catch (IOException e) {
            String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
            display(msg);
        }
    }	 
    public void stop() {
        keepGoing = false; 
        try {
            new Socket("localhost", port);
        }
        catch(Exception e) { 
        }
    } 
    public void display(String msg) { 
        String time = sdf.format(new Date()) + " " + msg;

        if(sg == null) {
            System.out.println(time);  
        } else{
            sg.appendEvent(time + "\n");
             
        }
    } 
    public synchronized void broadcast(GameEvent event) {   
        
        if(sg == null) {  
        } else {   
        }
        for(int i = clientThreadList.size(); --i >= 0;) {
            ClientThread ct = clientThreadList.get(i); 
            if(!ct.writeMsg(event)) {
                clientThreadList.remove(i);
                display("Disconnected Client " + ct.username + " removed from list.");
            }
        } 
    } 
    synchronized void remove(int id) { 
        for(int i = 0; i < clientThreadList.size(); ++i) {
            ClientThread ct = clientThreadList.get(i); 
            if(ct.id == id) {
                clientThreadList.remove(i);
                return;
            }
        }
        
    }  
     
    @Override
    public void playerRequestJoin(GameEvent event) {  
        GameEvent eventTmp = gs.validatePlayer(jugadores, event.getPlayer());  
        switch(eventTmp.getType()) { 
            case GameEvent.USERNAMEOK:
                jugadores.add(event.getPlayer()); 
                updatePlayerList(event); 
                break; 
            case GameEvent.USERNAMETAKEN:   
                System.out.println("usuario repetido");
                usernameTaken(event); 
                break; 
            case GameEvent.SESSIONFULL: 
                sessionFull(new GameEvent(2)); 
                break;  
        } 
        if (jugadores.size() == 4) {
            allPlayersReady(new GameEvent(11)); 
        }
    }

    @Override
    public void usernameTaken(GameEvent event) {
        Random rand = new Random(); 
        int value = rand.nextInt(50);
        System.out.println("Username: '" + event.getPlayer() + "' is not available.");
        event.getPlayer().setName(event.getPlayer().getName()+value);
        jugadores.add(event.getPlayer());
        updatePlayerList(event);
        
    }

    @Override
    public void updatePlayerList(GameEvent event) {
        sg.EliminarTablaTareas();
        sg.llenarTablaMemoria(jugadores);  
        broadcast(new GameEvent(5, jugadores));
    }

    @Override
    public void sessionFull(GameEvent event) {
        broadcast(new GameEvent(2, jugadores));
    }

    @Override
    public void leaveLobby(GameEvent event) {
        throw new UnsupportedOperationException("Operation not supported by Game Server.");
    }

    @Override
    public void playerLeftLobby(GameEvent event) {
        jugadores.remove(event.getPlayer());
        updatePlayerList(new GameEvent(0));
    }


    @Override
    public void allPlayersReady(GameEvent event) {
        System.out.println("------------------------------------");
        System.out.println("ALL PLAYERS READY. Starting game...");
        System.out.println("------------------------------------");
        
        for (Player p : jugadores) {
            p.setReady(true);
        }
        sessionHasStarted(new GameEvent(11));
        updatePlayerList(new GameEvent(0));
        tableroUpdate(new GameEvent(0));
        
    }

    @Override
    public void sessionHasStarted(GameEvent event) {
        gs.setActive(true);
        System.out.println("Session is now active.");
        broadcast(new GameEvent(7));
    }

    @Override
    public void updateView(GameEvent event) {
        
    }
    @Override
    public void leaveSession(GameEvent event) {
        throw new UnsupportedOperationException("Operation not supported by Game Server.");
    }
    @Override
    public void playerLeftSession(GameEvent event) {
        jugadores.remove(event.getPlayer());
        updatePlayerList(new GameEvent(0));
    }

    @Override
    public void gameOver(GameEvent event) {
        
    }  

    @Override
    public void playerReady(GameEvent event) {
        boolean allReady = false;
        for (Player p : jugadores) {
            if (p.getId().equals(event.getPlayer().getId())) {
                p.setReady(true);
                readyCounter++;
                System.out.println("Players ready: " + readyCounter);
            }
        }
        updatePlayerList(new GameEvent(5));
        
        if (jugadores.size() <= 3) 
            if (jugadores.size() == 3)
                if (readyCounter == 3)
                    allPlayersReady(new GameEvent(11)); 
            if (jugadores.size() == 2)
                if (readyCounter == 2)
                    allPlayersReady(new GameEvent(11));
    }

    @Override
    public void tableroUpdate(GameEvent event) {
        broadcast(new GameEvent(14, jugadores, movimientos));
    }
    public class ClientThread extends Thread { 
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id; 
        String username; 
        GameEvent gameEvent; 
        
        public ClientThread(Socket socket) {
            id = ++uniqueId;
            this.socket = socket; 
            System.out.println("Thread trying to create Object Input/Output Streams");
            try { 
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput  = new ObjectInputStream(socket.getInputStream()); 
                username = (String) sInput.readObject();
                //display(username + " just connected.");
            }
            catch (IOException e) {
                    display("Exception creating new Input/output Streams: " + e);
                    return;
            } 
            catch (ClassNotFoundException e) {
            }
            
        } 
        
        public void run() { 
            boolean keepGoing = true;
            while(keepGoing) {
                try {
                    gameEvent = (GameEvent) sInput.readObject(); 
                    System.out.println(gameEvent.getType());
                } catch (IOException e) {
                    display(username + " Exception reading Streams: " + e);  
                    jugadores.remove(playerTmp.getPlayer(jugadores, username));
                    updatePlayerList(new GameEvent(0, jugadores));
                    readyCounter--;
                    break;				
                }
                catch(ClassNotFoundException e2) {
                    break;
                } 
                
                switch(gameEvent.getType()) { 
                    case GameEvent.LOGINREQUEST:
                        playerRequestJoin(gameEvent);
                        break; 
                    case GameEvent.PLAYERREADY:   
                        playerReady(gameEvent);
                        break;  
                    case GameEvent.NEWMOVIMIENTO:
                        System.out.println("nuevo movimiento");
                        break;
                    default:
                        playerRequestJoin(gameEvent);
                        break;
                }
            }  
            remove(id);
            close();
        } 
        public void close() { 
            try {
                if(sOutput != null) sOutput.close();
            } catch(Exception e) {}
            try {
                if(sInput != null) sInput.close();
            }
            catch(Exception e) {};
            try {
                if(socket != null) socket.close();
            }
            catch (Exception e) {}
        }
         
        public boolean writeMsg(GameEvent msg) { 
          
            if(!socket.isConnected()) { 
                close();
                return false;
            } 
            try { 
                sOutput.writeObject(msg); 
                sOutput.reset(); 
            } 
            catch(IOException e) {
                display("Error sending message to " + username);
                display(e.toString());
            }
            return true;
        }
    }
}

