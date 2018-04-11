
public class ListaLigada {

	private No inicio;
	
	public void adicionaInicio(int novoElemento)
	{
		No novo = new No(novoElemento);
		novo.prox =  inicio;
		inicio = novo;
	}
	
	public int removerInicio()
	{
		int r = -1;
		if(inicio == null)
		{
			System.out.println("Erro");
		}
		else
		{
			r =  inicio.dado;
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
	
	

	public int removeFinal()
	{
		int retorno = -1;
		if(inicio == null)
		{
			return retorno;
		}
		else if(inicio.prox == null)
		{
			retorno = inicio.dado;
			return retorno;
		}
		else
		{
			No aux1 = inicio, aux2 = null;
			while(aux1.prox != null)
			{
				aux2 = aux1;
				aux1 = aux1.prox;
			}
			aux2.prox = null;
			retorno = aux1.dado;
			return retorno;
		}
		
		
		
	}
	
	public void adicionaFinal(int novoElemento)
	{
		
		if(inicio == null)
		{
			inicio = new No(novoElemento);
		}
		else
		{
			No aux = inicio;
			
			while(aux.prox != null)
			{
				aux = aux.prox;
			}
			No novo = new No(novoElemento);
			aux.prox = novo;
		}
	}
}
