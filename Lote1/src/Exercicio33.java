import javax.swing.JOptionPane;

/*
 33. Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.
 */
public class Exercicio33 {

	static float CalcSerie(float num)
	{
	    float serie = 1,i;
	    
	       for(i = 2; i<=num; i++)
	       {
	           serie = serie + (1/i);
	 
	       }
	    return serie;
	}

	
	public static void main(String[] args) {
		
		int numero;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro"));

		JOptionPane.showMessageDialog(null, "O valor da serie é "+ CalcSerie(numero));
	}

}
