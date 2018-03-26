package view;

import javax.swing.JOptionPane;

import controller.ListaAlunos;
import model.Aluno;



public class MenuAlunos {

	public static void main(String[] args) {
		int op = 0;
		ListaAlunos lista1 = new ListaAlunos(4);
		Aluno aluno;
		int posicao;
		String nome,ra;
		
		do
		{
			op = Integer.parseInt(JOptionPane.showInputDialog( "1 - Adiciona Inicio\n"+"2 - Adiciona Final\n"+"3 - Adiciona Especifico\n"+
			"4 - Remove Inicio\n"+"5 - Remove Final\n"+"6 - Remove Especifico\n"+"7 - Obtem Primeiro\n"+"8 - Obtem Ultimo\n"+"9 - Mostrar todos os Alunos\n"+"0 - Sair"));
		
			switch(op)
			{
				case 1:
					nome = JOptionPane.showInputDialog("Digite o Nome do aluno");
					ra = JOptionPane.showInputDialog("Digite o RA do aluno");
					aluno = new Aluno(nome,ra);
					
					lista1.adicionaInicio(aluno);
					break;
					
				case 2:
					nome = JOptionPane.showInputDialog("Digite o Nome do aluno");
					ra = JOptionPane.showInputDialog("Digite o RA do aluno");
					aluno = new Aluno(nome,ra);
					
					lista1.adicionaFinal(aluno);
					break;
					
				case 3:
					nome = JOptionPane.showInputDialog("Digite o Nome do aluno");
					ra = JOptionPane.showInputDialog("Digite o RA do aluno");
					aluno = new Aluno(nome,ra);
					
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja adicionar"));
					
					lista1.adicionaEspecifico(aluno, posicao);
					break;
					
				case 4:
					if(lista1.vazia())
					{
						JOptionPane.showMessageDialog(null, "Lista Vazia");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "O Aluno " + lista1.removeInicio());
					}
					break;
					
				case 5:
					if(lista1.vazia())
					{
						JOptionPane.showMessageDialog(null, "Lista Vazia");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "O Aluno " + lista1.removeFinal());
					}
					break;
					
				case 6:
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja Remover"));
					JOptionPane.showMessageDialog(null, "O Aluno " + lista1.removeEspecifico(posicao));
					break;
					
				case 7:
					JOptionPane.showMessageDialog(null, "O primeiro Aluno é " + lista1.ObtemPrimeiro());
					break;
					
				case 8:
					JOptionPane.showMessageDialog(null, "O ultimo Aluno é " + lista1.ObtemUltimo());
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
