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

/*
 15. Receba os valores de 2 catetos de um triângulo retângulo. Calcule e mostre
a hipotenusa.
 */
public class Exercicio15 {

	public static void main(String[] args) {
		
		float co,ca,hip;
		
		co = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do cateto oposto"));
		ca = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do cateto adjacente"));
		
		hip = co/ca;
		
		JOptionPane.showMessageDialog(null, "O Valor da hipotenusa é: "+hip);
	}

}
