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
public class Exercicio09 {

	public static void main(String[] args) {
	
		int N1,N2,SQ;
		
		N1 = Integer.parseInt(JOptionPane.showInputDialog("Digite N1"));
		N2 = Integer.parseInt(JOptionPane.showInputDialog("Digite N2"));
		
		SQ = (N1 * N1) + (N2 * N2);
		
		JOptionPane.showMessageDialog(null, "A soma dos quadrados é: "+ SQ);
		
		
	}
	
}
