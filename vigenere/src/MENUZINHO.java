import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MENUZINHO extends JFrame {
	
	JButton bt_descrip,bt_encrip;

	
	public MENUZINHO()
	{
			this.setTitle("Criptografar e Descriptografar");
			this.setLayout(null);
			this.setSize(500, 200);
			
			bt_descrip = new JButton("Descriptografar");
			bt_encrip = new JButton("Encriptografar");
			
			bt_descrip.setBounds(50, 50, 150, 50);
			bt_encrip.setBounds(250, 50, 150, 50);
			
			bt_descrip.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Descriptografar desc = new Descriptografar();
					desc.main(null);
					
				}
			});
			
			bt_encrip.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Encriptografar enc = new Encriptografar();
					enc.main(null);
					
				}
			});
			
			this.getContentPane().add(bt_descrip);
			this.getContentPane().add(bt_encrip);
	}
	
	public static void main(String[] args) {
		new MENUZINHO().setVisible(true);
	}
	
	
}


