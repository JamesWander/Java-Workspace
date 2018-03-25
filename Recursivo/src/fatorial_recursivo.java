import javax.swing.JOptionPane;

public class fatorial_recursivo {

	public static void main(String[] args) {
		int resultado;
		int numero;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		
		
		resultado = fatorial(numero);

		JOptionPane.showMessageDialog(null, "O Fatorial do numero digitado é "+resultado);
		
	}
	
	
	static int fatorial(int n)
	{
		
		if(n == 1)
		{
			return n;
		}
		else
		{
			return fatorial(n-1)*n;
		}
		
	}
	

}
