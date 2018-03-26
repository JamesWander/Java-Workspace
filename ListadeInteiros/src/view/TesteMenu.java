package view;
import javax.swing.JOptionPane;

import controller.ListaDeInteiros;


public class TesteMenu {

	public static void main(String[] args) {
		int op = 0;
		ListaDeInteiros lista1 = new ListaDeInteiros(4);
		int valor,posicao;
		
		do
		{
			op = Integer.parseInt(JOptionPane.showInputDialog( "1 - Adiciona Inicio\n"+"2 - Adiciona Final\n"+"3 - Adiciona Especifico\n"+
			"4 - Remove Inicio\n"+"5 - Remove Final\n"+"6 - Remove Especifico\n"+"7 - Obtem Primeiro\n"+"8 - Obtem Ultimo\n"+"9 - Mostrar todos os elementos\n"+"0 - Sair"));
		
			switch(op)
			{
				case 1:
					valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero para adicionar a lista"));
					lista1.adicionaInicio(valor);
					break;
					
				case 2:
					valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero para adicionar a lista"));
					lista1.adicionaFinal(valor);
					break;
					
				case 3:
					valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero para adicionar a lista"));
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja adicionar"));
					lista1.adicionaEspecifico(valor, posicao);
					break;
					
				case 4:
					if(lista1.vazia())
					{
						JOptionPane.showMessageDialog(null, "Lista Vazia");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "O Numero " + lista1.removeInicio());
					}
					break;
					
				case 5:
					if(lista1.vazia())
					{
						JOptionPane.showMessageDialog(null, "Lista Vazia");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "O Numero " + lista1.removeFinal() + " foi removido");
					}
					break;
					
				case 6:
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja Remover"));
					lista1.removeEspecifico(posicao);
					break;
					
				case 7:
					JOptionPane.showMessageDialog(null, "O primeiro numero é " + lista1.ObtemPrimeiro());
					break;
					
				case 8:
					JOptionPane.showMessageDialog(null, "O ultimo numero é " + lista1.ObtemUltimo());
					break;
					
				case 9:
					if(lista1.vazia())
					{
						JOptionPane.showMessageDialog(null, "Lista Vazia");
					}
					else
					{
						JOptionPane.showMessageDialog(null, lista1.toString());
					}
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
