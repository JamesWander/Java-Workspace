import javax.swing.JOptionPane;

public class Exercicio05 {

	public static void main(String[] args) {
		
		int vetor[] = new int[20];
		int somatoria = 0;
		
		for(int i = 0; i <= 19; i++)
		{
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));	
		}
		
		for(int i = 0; i <= 9; i++)
		{
			somatoria += vetor[i] - vetor[19-i];
		}

		JOptionPane.showMessageDialog(null, "O resultado da somatoria é "+somatoria);
		
	}

}
