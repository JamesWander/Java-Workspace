import javax.swing.JOptionPane;

/*
 34. Receba um número. Calcule e mostre os resultados da tabuada desse número.
 */
public class Exercicio34 {

	public static void main(String[] args) {
	
		int numero;
		String tabuada="";
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		
		for(int i = 0; i<=10; i++)
		{
			tabuada = tabuada + numero + " X " + i + " = " + (i*numero)+"\n"; 
		}
		JOptionPane.showMessageDialog(null,tabuada);

		
	}

}
