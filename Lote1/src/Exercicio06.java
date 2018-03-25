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
public class Exercicio06 {

	public static void main(String[] args) {
		
		int A,B,C;
		
		A = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor de A"));
		B = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor de B"));
		C = B;
		B = A;
		A = C;
		
		JOptionPane.showMessageDialog(null, "O Valor de A agora é:"+A+"\nE o valor de B agora é: "+B);
		
		

	}

}
