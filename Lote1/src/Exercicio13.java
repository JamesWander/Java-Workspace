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
public class Exercicio13 {

	public static void main(String[] args) {
	
			float kg,dias;
			
			kg = Float.parseFloat(JOptionPane.showInputDialog("Digite a quantidade de almento em quilos"));
			
			dias = kg/50;
			
			JOptionPane.showMessageDialog(null,"A comida ira durar "+dias+" dias");

	}

}
