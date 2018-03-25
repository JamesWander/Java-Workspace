import javax.swing.JOptionPane;

public class Exercicio07 {

	public static void main(String[] args) {
		
		int vetor[] = new int[20];
		int proc;
		
		for(int i = 0; i <= 19; i++)
		{
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));	
		}
		
		vetor = Exercicio06.BubbleSort(vetor);
		proc = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor procurado"));	
		
		if(pesquisa(vetor,proc))
		{
			JOptionPane.showMessageDialog(null,"Existe");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Não Existe");
		}
	}
	
	static boolean pesquisa(int vet[],int procurado)
	{
		boolean pesquisa = true,achou = false;
		int maior = vet.length-1, menor = 0, meio; 
		
		
		
		while(menor<=maior)
		{
			
			meio = (maior+menor)/2;
			
			if(vet[meio] == procurado)
			{
				pesquisa = false;
				achou = true;
				break;
			}
			if(vet[meio] > procurado)
			{
				maior = meio - 1;
			}
			else
			{
				menor = meio + 1;
			}

		}
		
		return achou;
		
	}

}
