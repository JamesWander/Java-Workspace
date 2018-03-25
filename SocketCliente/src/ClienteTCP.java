import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class ClienteTCP {

	public static void main(String[] args) {
		
		try
		{
			Socket cliente = new Socket("James",17777);
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			Date data = (Date)entrada.readObject();
			JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data.toString());
			entrada.close();
			System.out.println("Conexão Encerrada");
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "aaaa"+e);
		}

	}

}
