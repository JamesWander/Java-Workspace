/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 24/08/2017									   ║
║  															   ║
║  		Objetivo: Receba a base e a altura de um triângulo.    ║
║		Calcule e mostre a sua área. 		   				   ║
║													           ║
║                                                              ║  
║															   ║
╚══════════════════════════════════════════════════════════════╝
 */

import javax.swing.JOptionPane;
public class Exercicio10 {

	public static void main(String[] args) {

		double N1,N2,DF;
		
		N1 = Integer.parseInt(JOptionPane.showInputDialog("Digite N1"));
		N2 = Integer.parseInt(JOptionPane.showInputDialog("Digite N2"));
		
		DF = N1 -N2;
		
		JOptionPane.showMessageDialog(null, "A Diferença dos valores é: "+ DF);
		
		
		

	}

}
