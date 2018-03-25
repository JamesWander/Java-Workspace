/*

 Nome do programador: Rodrigo
 Data de Elaboração: 03/08/2017
 Objetivo: Mostrar que o Rodrigo nao manja de java e Calcular a soma de dois valores a partir
 da coleta de A e B
 
*/

import javax.swing.JOptionPane;

public class Exemplo01 {	
	public static void main(String[] args){
		int A, B, C;
		
		try{
		A=Integer.parseInt(JOptionPane.showInputDialog("Digite um valor em A"));
		B=Integer.parseInt(JOptionPane.showInputDialog("Digite um valor em B"));
		C=A+B;
		System.out.println("A soma dos DOIS valores digitados equivale a: " + C);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro");
		}
		
	}
}