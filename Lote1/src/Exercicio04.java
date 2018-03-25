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

public class Exercicio04 {	
	public static void main(String[] args){
		double C, F;
		
		
		C=Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura em celsius"));
		F=(9*C+160)/5;
		JOptionPane.showMessageDialog(null, "A temperatura convertida para Fahrenheints é: " + F);
		
			
		
	}
	
}