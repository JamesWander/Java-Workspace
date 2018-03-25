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
public class Exercicio05 {

	public static void main(String[] args) {
		
		double A,B,C,DELTA,X1,X2;
		
		A = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor de A"));
		B = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor de B"));
		C = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor de C"));
		
		DELTA = (B*B)-(4*A*C);
		
		X1 = -B + Math.sqrt(DELTA)/(2*A);
		X2 = -B - Math.sqrt(DELTA)/(2*A);
		
		JOptionPane.showMessageDialog(null, "X1 = "+X1+"\nX2 = "+X2);
		
		
		
		
		
		

	}

}
