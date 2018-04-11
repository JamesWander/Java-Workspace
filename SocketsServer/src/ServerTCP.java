import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class ServerTCP {

	public static void main(String[] args) {
		
		
		try
		{
			ServerSocket servidor = new ServerSocket(17777);
			System.out.println("Listening na porta 17777");
			String asd = JOptionPane.showInputDialog("Digite a mensagen");
			while(true)
			{
				//aceita a conexao do usuario
				Socket cliente = servidor.accept();
				
				//exibe o usuario que foi conectado
				System.out.println("Usuario conectado: " + cliente.getInetAddress().getHostAddress());
				
				//????????
				ObjectOutputStream said = new ObjectOutputStream(cliente.getOutputStream());
				
				
				said.flush();
				said.writeObject(asd);
				said.close();
				cliente.close();
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Server"+e);
		}
		
	}

}
