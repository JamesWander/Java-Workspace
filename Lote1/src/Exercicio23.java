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
 23. Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não
necessariamente em ordem. Mostre os 4 números em ordem crescente.
 */

public class Exercicio23 {

	static void Ordem(float N1, float N2, float N3, float N4)
	{
	   if(N4>=N3)
	   {
	       JOptionPane.showMessageDialog(null, N1+" "+N2+" "+N3+" "+N4);
	   }
	   else if(N4>=N2)
	   {
		   JOptionPane.showMessageDialog(null, N1+" "+N2+" "+N4+" "+N3);
	   }
	   else if(N4>=N1)
	   {
		   JOptionPane.showMessageDialog(null, N1+" "+N4+" "+N2+" "+N3);
	   }
	   else
	   {
		   JOptionPane.showMessageDialog(null, N4+" "+N1+" "+N2+" "+N3);
	   }
	}
	
	
	
	public static void main(String[] args) {
		
	int n1,n2,n3,n4;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		
		do{
			n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero maior que "+n1));
		}while(n2<=n1);
		
		do{
			n3 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero maior que "+n2));
		}while(n3<=n2);
		
		n4 = Integer.parseInt(JOptionPane.showInputDialog("Digite mais um numero"));
		
		Ordem(n1,n2,n3,n4);
	}

}
