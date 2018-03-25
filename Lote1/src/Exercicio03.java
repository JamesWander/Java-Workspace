/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 24/08/2017									   ║
║  															   ║
║  		Objetivo: Receba a temperatura em graus Celsius.	   ║
║		Calcule e mostre a sua temperatura convertida em 	   ║
║		fahrenheit F = (9*C+160) /5.				           ║ 
║															   ║
║															   ║
╚══════════════════════════════════════════════════════════════╝

 */
import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		
		double base, altura;
		
		base = Double.parseDouble(JOptionPane.showInputDialog("Digite a base do triangulo"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triangulo"));
	
		
		JOptionPane.showMessageDialog(null, "A area do triangulo é: " + (base * altura)/2);
		
	}
	
}
