import javax.swing.JOptionPane;

public class FilaMenu {

	public static void main(String[] args) {
		
		String menu = "1 - Enfilerar\n2 - Desenfilerar\n3 - Exibir Dados\n0 - Sair";
		Fila fila = new Fila();
		int escolha;
		
		do
		{
			escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch(escolha)
			{
				case 1:
					int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
					fila.enfilerar(valor);
					break;
				
				case 2:
					fila.desenfilerar();
					break;
				
				case 3:
					JOptionPane.showMessageDialog(null, fila.toString());
					break;
					
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Erro");
					break;
					
			}
			
		}while(escolha != 0);
		

	}

}
