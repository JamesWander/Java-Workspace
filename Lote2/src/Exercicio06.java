import javax.swing.JOptionPane;

public class Exercicio06 {

	public static void main(String[] args) {
		
		int vetor[] = new int[20];
		
		for(int i = 0; i <= 19; i++)
		{
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));	
		}
		
		vetor = BubbleSort(vetor);
		
		for(int i = 0; i <= 19; i++)
		{
			JOptionPane.showMessageDialog(null, vetor[i]);
		}
	}
	
	static int[] BubbleSort(int vet[])
	{
		int ajudante;
		for(int i = 0; i <= 18; i++)
		{
			for(int j = i+1; j <= 19; j++)
			{
				if(vet[i] > vet[j])
				{
					ajudante = vet[i];
					vet[i] = vet[j];
					vet[j] = ajudante;
				}
			}
			
		}
		
		return vet;
	}
	
	

}
