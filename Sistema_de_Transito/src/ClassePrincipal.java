import java.io.IOException;

import javax.swing.JOptionPane;

public class ClassePrincipal {

	public static void main(String[] args) throws IOException {
		
		int WTF = 0;
		Cidade[] city = new Cidade[15]; 
		ClasseMetodos help = new ClasseMetodos();
		
		while(WTF != 9)
		{
			WTF = Integer.parseInt(JOptionPane.showInputDialog("MENU ESTATISTICA\n1 - Cadastro Estatistica\n"
					+ "2 - Consulta por tipo de veiculo\n3 - Consulta por quantidade de acidente\n"
					+ "4 - Consulta todas as cidades\n5 - Consulta maior menor média de acidentes\n9 - finaliza"));
			
			switch(WTF)
			{
				case 1:
					city = help.CadCidades(city);
				break;
				
				case 2:
					int tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de veiculo, 1 - passeio\n 2 - publico\n3 - Caminhao"));
					help.ConsultaTipo(city, tipo);
				break;
				
				case 3:
					
				break;
				
				case 4:
					
				break;
				
				case 5:
				
				break;
				
				case 9:
					JOptionPane.showMessageDialog(null, "Encerrando");
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
				break;
				
			}
		}
		
		

	}

}
