
package chatapp;

import javax.swing.UIManager;


public class Login extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    public Login() {
      
     //lookandfeel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {  } 
 
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Login");
        
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelipaddress = new javax.swing.JLabel();
        jTextFieldipaddress = new javax.swing.JTextField();
        jLabelport = new javax.swing.JLabel();
        jTextFieldport = new javax.swing.JTextField();
        jButtonlogin = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("login"); // NOI18N
        setPreferredSize(new java.awt.Dimension(317, 334));
        setResizable(false);
        setSize(new java.awt.Dimension(315, 288));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelName.setText("Name :");
        getContentPane().add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 130, -1));

        jLabelipaddress.setText("IP Address :");
        getContentPane().add(jLabelipaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));
        getContentPane().add(jTextFieldipaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));

        jLabelport.setText("Port :");
        getContentPane().add(jLabelport, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jTextFieldport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldportActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldport, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 130, -1));

        jButtonlogin.setText("Login");
        jButtonlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonloginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldportActionPerformed

    private void jButtonloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonloginActionPerformed
        String name=jTextFieldName.getText();
        String ipaddress=jTextFieldipaddress.getText();
        int port=Integer.parseInt(jTextFieldport.getText());
        login(name,ipaddress,port);
    }//GEN-LAST:event_jButtonloginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonlogin;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelipaddress;
    private javax.swing.JLabel jLabelport;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldipaddress;
    private javax.swing.JTextField jTextFieldport;
    // End of variables declaration//GEN-END:variables

    private void login(String name, String ipaddress, int port) {
        dispose();
        new client(name,ipaddress,port);
    }
}
