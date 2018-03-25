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
public class Exercicio07 {

	public static void main(String[] args) {
	
		double C,L,A,V;
		
		C = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento"));
		L = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura"));
		A = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura"));
		
		V = C*L*A;
		
		JOptionPane.showMessageDialog(null, "O Volume do paralelepípedo é: "+V);
		
		
		
	}

}
