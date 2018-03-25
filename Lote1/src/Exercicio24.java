import javax.swing.JOptionPane;

//24. Receba um valor inteiro. Verifique e mostre se é divisível por 2 e 3.


public class Exercicio24 {

	static void divisivel(int N)
	{
	    
	   if(N % 2 == 0 && N % 3 == 0)
	   {
	       JOptionPane.showMessageDialog(null,"O Numero é divisivel por 2 e 3");
	   }
	   else
	   {
	       JOptionPane.showMessageDialog(null, "O Numero nao é divisivel por 2 e 3");
	   }
	    
	}
	
	
	public static void main(String[] args) {
		
		int numero;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		
		divisivel(numero);

	}

}
