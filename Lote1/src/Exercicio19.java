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
 19. Receba 2 valores reais. Calcule e mostre o maior deles.
 */
public class Exercicio19 {

	static void maior(float n1, float n2)
	{
		if(n1 > n2)
		{
			JOptionPane.showMessageDialog(null,n1+" é maior");
		}
		else if(n2 > n1)
		{
			JOptionPane.showMessageDialog(null, n2+" é maior");
		}
		else
		{
			JOptionPane.showMessageDialog(null, n1+" = "+n2);
		}
	}
	
	
	public static void main(String[] args) {

		float n1,n2;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite N1"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite N2"));
		
		maior(n1,n2);

	}

}
