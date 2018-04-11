
public class Pilha {

	private No inicio;
	
	public void empilhar(int valor)
	{
		No aux = new No(valor);
		aux.prox = inicio;
		inicio = aux;
			
	}
	
	public int desempilhar()
	{
		int r = -1;
		if(inicio == null)
		{
			System.out.println("Erro, Nenhum elemento na pilha");
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
