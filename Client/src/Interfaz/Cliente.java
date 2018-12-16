/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Interfaz.Dialogs.addNickName;
import Interfaz.Dialogs.Config;
import Interfaz.Dialogs.changeName;
import Interfaz.Dialogs.sessionFullDialog;
import Interfaz.Panel.Tablero;
import Negocio.GameEvent; 
import Negocio.GameSession;
import Negocio.Player;
import datos.Client;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;  
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */ 
    public Player player; 
    addNickName nicknameDialog = new addNickName(); 
    Config configDialog = new Config(); 
    sessionFullDialog fullDialog = new sessionFullDialog();
    changeName changeNameDialog = new changeName();
    public Client client; 
    public int defaultPort;
    public String defaultHost; 
    public boolean connected;
    
    
    public Color playerColor_1 = Color.BLUE;
    public Color playerColor_2 = Color.ORANGE;
    public Color playerColor_3 = Color.YELLOW;
    public Color playerColor_4 = Color.pink;
     boolean check=false;
    public Cliente() {  
        initComponents();
    }
    public Cliente(String host, int port) { 
        //this.setUndecorated(true); 
        initComponents();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);  
        this.setLocationRelativeTo(null);
        jugadorReady.setVisible(false);
        playerReadySidebar.setVisible(false);
        
        
        player_1.setText("");
        player_2.setText("");
        player_3.setText("");
        player_4.setText("");
        
       
       
    } 
    public void connectionFailed() {  
        client.disconnect();
        connected = false;
    }
    public void updatePlayers(ArrayList<Player> players){ 
        String listaJugadores = ""; 
        int position = 1;
        player_1.setText("");
        player_1.setIcon(null); 
        player_2.setText("");
        player_2.setIcon(null); 
        player_3.setText("");
        player_3.setIcon(null); 
        player_4.setText("");
        player_4.setIcon(null); 
        for (int i = 0; i < players.size(); i++) {
            if (position == 1) { 
                player_1.setText(players.get(i).getName());
                player_1.setForeground(playerColor_1);
                if (players.get(i).isReady()) {
                    player_1.setIcon(new ImageIcon("src/images/checked.png")); 
                } else {
                    player_1.setIcon(new ImageIcon("src/images/cancel.png")); 
                }
            }
            if (position == 2) {
                player_2.setText(players.get(i).getName());
                player_2.setForeground(playerColor_2);
                if (players.get(i).isReady()) {
                    player_2.setIcon(new ImageIcon("src/images/checked.png")); 
                } else {
                    player_2.setIcon(new ImageIcon("src/images/cancel.png")); 
                }
            }
            if (position == 3) {
                player_3.setText(players.get(i).getName());
                player_3.setForeground(playerColor_3);
                if (players.get(i).isReady()) {
                    player_3.setIcon(new ImageIcon("src/images/checked.png")); 
                } else {
                    player_3.setIcon(new ImageIcon("src/images/cancel.png")); 
                }
            }
            if (position == 4) {
                player_4.setText(players.get(i).getName());
                player_4.setForeground(playerColor_4);
                if (players.get(i).isReady()) {
                    player_4.setIcon(new ImageIcon("src/images/checked.png")); 
                } else {
                    player_4.setIcon(new ImageIcon("src/images/cancel.png")); 
                }
            }
            position++;
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        playerReady = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        playerReadySidebar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        readyPlayer = new javax.swing.JToggleButton();
        player_1 = new javax.swing.JLabel();
        player_2 = new javax.swing.JLabel();
        player_3 = new javax.swing.JLabel();
        player_4 = new javax.swing.JLabel();
        JButton_Config = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        tablero = new javax.swing.JPanel();
        jugadorReady = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(780, 536));

        Sidebar.setBackground(new java.awt.Color(7, 55, 99));
        Sidebar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sidebar.setMinimumSize(new java.awt.Dimension(175, 490));
        Sidebar.setName(""); // NOI18N
        Sidebar.setPreferredSize(new java.awt.Dimension(199, 490));

        playerReady.setBackground(new java.awt.Color(7, 55, 99));

        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button.png"))); // NOI18N
        jButton3.setAlignmentY(0.0F);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playerReadyLayout = new javax.swing.GroupLayout(playerReady);
        playerReady.setLayout(playerReadyLayout);
        playerReadyLayout.setHorizontalGroup(
            playerReadyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)
        );
        playerReadyLayout.setVerticalGroup(
            playerReadyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerReadyLayout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(445, Short.MAX_VALUE))
        );

        playerReadySidebar.setBackground(new java.awt.Color(7, 55, 99));
        playerReadySidebar.setPreferredSize(new java.awt.Dimension(199, 490));
        playerReadySidebar.setRequestFocusEnabled(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/players.png"))); // NOI18N

        readyPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notReady.png"))); // NOI18N
        readyPlayer.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ready.png"))); // NOI18N
        readyPlayer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ready.png"))); // NOI18N
        readyPlayer.setVerifyInputWhenFocusTarget(false);
        readyPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyPlayerActionPerformed(evt);
            }
        });

        player_1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player_1.setForeground(new java.awt.Color(255, 255, 255));
        player_1.setText("jLabel3");
        player_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player_1MouseClicked(evt);
            }
        });

        player_2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player_2.setForeground(new java.awt.Color(255, 255, 255));
        player_2.setText("jLabel4");

        player_3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player_3.setForeground(new java.awt.Color(255, 255, 255));
        player_3.setText("jLabel3");

        player_4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player_4.setForeground(new java.awt.Color(255, 255, 255));
        player_4.setText("jLabel4");

        JButton_Config.setBackground(new java.awt.Color(7, 55, 99));
        JButton_Config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config.png"))); // NOI18N
        JButton_Config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_ConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playerReadySidebarLayout = new javax.swing.GroupLayout(playerReadySidebar);
        playerReadySidebar.setLayout(playerReadySidebarLayout);
        playerReadySidebarLayout.setHorizontalGroup(
            playerReadySidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerReadySidebarLayout.createSequentialGroup()
                .addGroup(playerReadySidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(readyPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(playerReadySidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerReadySidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player_2)
                    .addComponent(player_3)
                    .addComponent(player_4)
                    .addComponent(JButton_Config)
                    .addComponent(player_1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playerReadySidebarLayout.setVerticalGroup(
            playerReadySidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerReadySidebarLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(JButton_Config)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(readyPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerReadySidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(playerReady, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerReadySidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerReady, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(61, 133, 198));
        content.setPreferredSize(new java.awt.Dimension(429, 490));

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jugadorReady.setBackground(new java.awt.Color(61, 133, 198));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jugadores");

        javax.swing.GroupLayout jugadorReadyLayout = new javax.swing.GroupLayout(jugadorReady);
        jugadorReady.setLayout(jugadorReadyLayout);
        jugadorReadyLayout.setHorizontalGroup(
            jugadorReadyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugadorReadyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(511, Short.MAX_VALUE))
        );
        jugadorReadyLayout.setVerticalGroup(
            jugadorReadyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugadorReadyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jugadorReady, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jugadorReady, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        GameSession gs = new GameSession();
        nicknameDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jButton3.setEnabled(false);
        nicknameDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                jButton3.setEnabled(true);
                if (connected=true) { 
                    if (nicknameDialog.jTextField12 != null) {  
                        // Conectar al servidor aqui 
                        conectarServer();   
                        UUID uuid = UUID.randomUUID(); 
                        player = new Player(uuid, nicknameDialog.jTextField12); 
                        GameEvent newEvent = new GameEvent(1,player);
                        client.enviarEvent(newEvent); 

                        jugadorReady.setVisible(true);
                        playerReady.setVisible(false);
                        playerReadySidebar.setVisible(true);
                        jLabel1.setText(player.getName());
                    }
                } else {
                    String message = "\"Problemas con el servidor\"\n"
                    + "Puede que el servidor este apagado\n"
                    + "o tengas un problema de conexion";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }  
        });
        nicknameDialog.setVisible(true); 
    }//GEN-LAST:event_jButton3ActionPerformed
    void conectarServer(){
        String username = nicknameDialog.nickname.getText();
        System.out.println(username);
        // empty username ignore it
        if(username.length() == 0)
                return;
        // empty serverAddress ignore it
        String server = nicknameDialog.hostname.getText();
        System.out.println(server);
        if(server.length() == 0)
                return;
        // empty or invalid port numer, ignore it
        String portNumber = "1500";
        if(portNumber.length() == 0)
                return;
        int port = 0;
        try {
                port = Integer.parseInt(portNumber);
        }
        catch(Exception en) {
                return;   // nothing I can do if port number is not valid
        }

        // try creating a new Client with GUI

        client = new Client(server, port, username, this);
        // test if we can start the Client
        if(!client.start()) 
                return;
    
    }
    public void handleSessionFull(){
        
        fullDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fullDialog.setVisible(true);
    }
    private void readyPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyPlayerActionPerformed
        player.setReady(true);
        client.enviarEvent(new GameEvent(6,player)); 
        
    }//GEN-LAST:event_readyPlayerActionPerformed

    private void JButton_ConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_ConfigActionPerformed
        GameSession gs = new GameSession();
        configDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jButton3.setEnabled(false);
        configDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("prueba");
            }  
        });
        configDialog.setVisible(true); 
    }//GEN-LAST:event_JButton_ConfigActionPerformed

    private void player_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player_1MouseClicked
        // TODO add your handling code here:
        System.out.println("prueba");
    }//GEN-LAST:event_player_1MouseClicked
     
    /**
     * @param args the command line arguments
     */ 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });

*/
        new Cliente("localhost", 1500);
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton_Config;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel content;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jugadorReady;
    private javax.swing.JPanel playerReady;
    private javax.swing.JPanel playerReadySidebar;
    private javax.swing.JLabel player_1;
    private javax.swing.JLabel player_2;
    private javax.swing.JLabel player_3;
    private javax.swing.JLabel player_4;
    public static javax.swing.JToggleButton readyPlayer;
    public static javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}
