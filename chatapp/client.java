
package chatapp;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class client extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
	private String name,ipaddress;
	private int port;
        private DatagramSocket socket;
        private InetAddress inetaddress;
        private Thread send;
        
    public client(String name,String ipaddress,int port) {
           try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;   } } } catch (Exception e) { }
                 
                
                setVisible(true);
                setSize(637, 383);
		setLocationRelativeTo(null);
                setTitle("Chat Client");
		
                this.name=name;
		this.ipaddress=ipaddress;
		this.port=port;
            
                boolean connect=openConnection(ipaddress,port);
                if(!connect){
                    System.err.println("Connection Failed");
                    console("Connection Failed");
                }
                
                
                initComponents();
                console("Attempiting to connect "+ipaddress+" : "+port+" user: "+name);
                
    }
    private String recieve(){
    
       
            byte[] data=new byte[1024];
            DatagramPacket packet=new DatagramPacket(data,data.length);
          
            try {  socket.receive(packet);
        } catch (IOException ex) {ex.printStackTrace();  }
            String messege=new String(packet.getData());
            return messege;
    }
    
    public void send(final byte[] data){
        send=new Thread("Send"){
            public void run(){
                try {
                    DatagramPacket packet=new DatagramPacket(data,data.length,inetaddress,port);
                    socket.send(packet);
                } catch (IOException ex) { }
            }
        };
        send.start();
    }
    
    //the reason to make this boolean just for know whether connection has established succesfully or not
    private boolean openConnection(String ipaddress,int port){
        try {socket=new DatagramSocket(port); } catch (SocketException ex) { return false; }
        
        try {  inetaddress=InetAddress.getByName(ipaddress); } catch (UnknownHostException ex) {return false;   }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreahistory = new javax.swing.JTextArea();
        jButtonsend = new javax.swing.JButton();
        jTextFieldmessege = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(637, 383));
        setSize(new java.awt.Dimension(637, 383));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTextAreahistory.setEditable(false);
        jTextAreahistory.setColumns(20);
        jTextAreahistory.setRows(5);
        jTextAreahistory.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTextAreahistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 594;
        gridBagConstraints.ipady = 269;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButtonsend.setText("Send");
        jButtonsend.setRequestFocusEnabled(false);
        jButtonsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsendActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 6, 31, 10);
        getContentPane().add(jButtonsend, gridBagConstraints);

        jTextFieldmessege.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldmessegeKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 527;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 10, 31, 0);
        getContentPane().add(jTextFieldmessege, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsendActionPerformed
        // TODO add your handling code here:
         send(jTextFieldmessege.getText()); 
         
    }//GEN-LAST:event_jButtonsendActionPerformed

    private void jTextFieldmessegeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldmessegeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            send(jTextFieldmessege.getText());
        }
    }//GEN-LAST:event_jTextFieldmessegeKeyPressed

  
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonsend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreahistory;
    private javax.swing.JTextField jTextFieldmessege;
    // End of variables declaration//GEN-END:variables

    private void console(String Message) {
        jTextAreahistory.append(Message+" \n");
    }

    private void send(String Message) {
            if(Message.equals("")){return;}
            Message=name+" : "+Message;
           console(Message);
         jTextFieldmessege.setText("");
    }
}
