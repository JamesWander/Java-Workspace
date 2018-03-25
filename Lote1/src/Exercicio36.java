import javax.swing.JOptionPane;

/*
36. Receba um número N. Calcule e mostre a série 1 + 1/1! + 1/2! + ... + 1/N!
 */
public class Exercicio36 {

	static double SerieFator(int num)
	{
	    double serie = 1,um = 1;
	    int i;
	    
	    
	       for(i = 1; i<=num; i++)
	       {
	           serie = serie + (um/Exercicio32.Fatorial(i));
	           
	       }
	    return serie;
	}

	
	public static void main(String[] args) {
		
		int numero;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro"));

		JOptionPane.showMessageDialog(null, "O valor da serie é "+ SerieFator(numero));
	}

}
