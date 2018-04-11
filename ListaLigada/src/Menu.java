import javax.swing.JOptionPane;


public class Menu {

	public static void main(String[] args) {
		int op = 0,valor;
		ListaLigada lista = new ListaLigada();
		
		do
		{
			op = Integer.parseInt(JOptionPane.showInputDialog( "1 - Adiciona Inicio\n"+"2 - Adiciona Final\n"+"3 - Adiciona Especifico\n"+
			"4 - Remove Inicio\n"+"5 - Remove Final\n"+"6 - Remove Especifico\n"+"7 - Obtem Primeiro\n"+"8 - Obtem Ultimo\n"+"9 - Mostrar todos os elementos\n"+"0 - Sair"));
		
			switch(op)
			{
			
				case 1:
					valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero para adicionar a lista"));
					lista.adicionaInicio(valor);
					break;
					
				case 2:
					valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero para adicionar a lista"));
					lista.adicionaFinal(valor);
					break;
					
				case 4:
					JOptionPane.showMessageDialog(null, lista.removerInicio());
					break;
					
				case 9:
					JOptionPane.showMessageDialog(null, lista.toString());
					break;
					
					
				case 0:
					JOptionPane.showMessageDialog(null, "Finalizando programa");
					break;
							
					
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					break;
					
			}
			
		}while(op != 0);
		System.exit(0);

		
	}

}
