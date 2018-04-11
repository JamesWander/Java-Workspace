
public class Pilha {

	private int topo;
	private char dados[];
	
	public Pilha(int capMax)
	{
		this.topo = -1;
		this.dados = new char[capMax];
	}
	
	public void empilhar(char valor)
	{
		if(topo < dados.length)
		{
			dados[topo+1] = valor;
			topo++;
		}
	}
	
	
	public void desempilhar()
	{
		if(topo > -1)
		{
			topo--;
		}
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i <= topo; i++)
		{
			str += dados[i] + " ";  
		}
		return str;
		
	}
	
	public boolean vazia()
	{
		if(topo == -1)
		{
			return true;
		}
		return false;
	}
	
	
	
}
