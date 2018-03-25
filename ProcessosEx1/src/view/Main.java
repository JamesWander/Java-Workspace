package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redes = new RedesController();
		String os =	System.getProperty("os.name");
		int aux;
		
		do
		{	
			aux = Integer.parseInt(JOptionPane.showInputDialog("Escolha o que deseja executar\n1-Configuraçoes de IPv4\n2-Teste de Ping\n0-Sair"));
			switch(aux)
			{
				case 1:
					JOptionPane.showMessageDialog(null, redes.ip(os));
					break;
					
				case 2:
					JOptionPane.showMessageDialog(null, redes.ping(os));
					break;
				
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Funçao inexistente");
					break;
			}
		}while(aux != 0);
		
	}

}
