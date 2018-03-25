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

//14. Receba 2ângulos de um triângulo. Calcule e mostre o valor do 3º ângulo.


public class Exercicio14 {

	public static void main(String[] args) {
		
		int a1,a2,a3;
		
		a1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro angulo"));
		a2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo angulo"));

		
		a3 = 180 - (a1 + a2);
		
		JOptionPane.showMessageDialog(null, "O terceiro angulo é: "+a3);
		
	

	}

}
