import javax.swing.JOptionPane;

/*
 44. Receba o número da base e do expoente. Calcule e mostre o valor da
potência.
 */
public class Exercicio44 {

	static double elevado(int base,int expoente)
	{
		return  Math.pow(base,expoente);	  
	}
	
	public static void main(String[] args) {
		
		int base,expoente;
		
		base = Integer.parseInt(JOptionPane.showInputDialog("Digite a base"));
		expoente = Integer.parseInt(JOptionPane.showInputDialog("Digite o expoente"));

		JOptionPane.showMessageDialog(null, "O valor da potencia é "+elevado(base,expoente));
	}

}
