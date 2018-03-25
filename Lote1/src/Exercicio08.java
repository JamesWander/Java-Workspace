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
public class Exercicio08 {

	public static void main(String[] args) {
		
		double deposito,reajustado;
		
		deposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que foi depositado"));
		reajustado = deposito+(deposito*0.013);
		
		JOptionPane.showMessageDialog(null, "O Valor apos 1 mes na poupança é de: R$"+reajustado);
		
		

	}

}
