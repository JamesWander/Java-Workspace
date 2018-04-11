import javax.swing.JOptionPane;


public class PilhaMenu {

	public static void main(String[] args) {
		
		String menu = "1 - Empilhar\n2 - Desempilhar\n3 - Exibir Dados\n0 - Sair";
		Pilha pilha = new Pilha(4);
		int escolha;
		
		do
		{
			escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch(escolha)
			{
				case 1:
					int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
					pilha.empilhar(valor);
					break;
				
				case 2:
					pilha.desempilhar();
					break;
				
				case 3:
					JOptionPane.showMessageDialog(null, pilha.toString());
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
