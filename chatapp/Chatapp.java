
package chatapp;

import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Chatapp {

    	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JLabel lblIpAdress;
	private JTextField txtPort;
	private JLabel lblPort;
    
    public static void main(String[] args) {
       
        	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        
    }
    
}
