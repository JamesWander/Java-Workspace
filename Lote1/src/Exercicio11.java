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
public class Exercicio11 {

	public static void main(String[] args) {
		
		double raio,comprimento;
		
		raio = Double.parseDouble(JOptionPane.showInputDialog("Digite o raio de uma circunferencia"));
		
		comprimento = raio * 2 * 3.14;
		
		JOptionPane.showMessageDialog(null, "O comprimento da circunferencia é: "+comprimento);
		
	}

}
