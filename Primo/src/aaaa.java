import javax.swing.JOptionPane;

public class aaaa {

	public static void main(String args[])
	{
		int n1,n2;
		String numeros = "Os Numeros Primos são: ";
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite N1"));
		
		do
		{
			n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite N2"));
		}
		while(n1 >= n2);
		
		for(int i = n1; i <= n2; i++)
		{
			int contador = 0;
			
			for(int j = 1; j <= i; j++)
			{
				if(i % j == 0)
				{
					contador++;
				}
			}
			if(contador == 2)
			{
				numeros += i + " ";
			}
		}
		JOptionPane.showMessageDialog(null, numeros);
		
	}

	
}
