import javax.swing.JOptionPane;

public class Fila {
	
	int tamanho;
	int[] dados;
	
	public Fila(int capMax)
	{
		this.tamanho = 0;
		this.dados = new int[capMax];
	}
	
	public void enfilerar(int valor)
	{
		if(tamanho == dados.length)
		{
			System.out.println("Erro, Fila Cheia");
		}
		else
		{
			tamanho++;
			dados[tamanho] = valor;
		}
	}
	
	public int desenfilerar()
	{
		int r = -1;
		
		if(tamanho > -1)
		{
			r = dados[0];
			
			for(int i = 1; i < tamanho; i++)
			{
				dados[i-1] = dados[i];
			}
			tamanho--;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erro");
		}
		
		
		return r;
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i <= tamanho; i++)
		{
			str += dados[i] + " ";  
		}
		return str;
		
	}
	
}
