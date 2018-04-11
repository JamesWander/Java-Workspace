
public class Fila {

	public No inicio;
	
	
	public void enfilerar(int valor)
	{
		
		No novo = new No(valor); 
		
		
		if(inicio == null)
		{
			inicio = novo;
		}
		else
		{
			No aux 	= inicio;
			
			while(aux.prox != null)
			{
				aux = aux.prox;
			}
			aux.prox = novo;
		}
		
	}
	
	public int desenfilerar()
	{
		int r = -1;
		
		if(inicio == null)
		{
			System.out.println("Erro, Nenhum elemento na Fila");
		}
		else
		{
			r = inicio.dado;
			inicio = inicio.prox;
		}
		
		return r;
	}
	
	public String toString()
	{
		No aux = inicio;
		String s = "";
		
		while(aux != null)
		{
			s = s + " " + aux.dado;
			aux = aux.prox;
		}
		return s;
	}
	
}
