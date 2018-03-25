import javax.swing.JOptionPane;

public class Exercicio02 {

	
	
	public static void main(String[] args) {
			
		int vetor[] = new int[100];		
		
			for(int i = 0; i <= 99; i++)
			{
				vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
			}
				
			maior(vetor);
			menor(vetor);
			media(vetor);
	}
	
	static void maior (int vetor[])
	{
		int maior = 0;
		
		for(int i = 0; i <= 99; i++)
		{
			if(vetor[i] > maior)
			{
				maior = vetor[i];
			}
		}
		
		JOptionPane.showMessageDialog(null, "O Maior valor é "+maior);
	}
	
	static void menor (int vetor[])
	{
		int menor = Integer.MAX_VALUE;
		
		for(int i = 0; i <= 99; i++)
		{
			if(vetor[i] < menor)
			{
				menor = vetor[i];
			}
		}
		
		JOptionPane.showMessageDialog(null, "O Menor valor é "+menor);
	}
	
	static void media (int vetor[])
	{
		int media = 0;
		
		for(int i = 0;i <= 99; i++)
		{
			media += vetor[i];
		}
		
		media = media / 100;
		
		JOptionPane.showMessageDialog(null, media );
		
	}
	

}
