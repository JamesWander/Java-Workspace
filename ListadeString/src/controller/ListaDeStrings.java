package controller;

public class ListaDeStrings {
	
	int tamanho;
	String[] dados;
	
	public ListaDeStrings(int capMax)
	{
		tamanho = 0;
		dados = new String[capMax];
	}

	public void adicionaInicio(String string)
	{
		if(!cheia())
		{
			for(int i = tamanho; i > 0; i--)
			{
				dados[i] = dados[i-1];
			}
			dados[0] = string;
			tamanho++;
		}
		
	}

	public void adicionaFinal(String string)
	{
		if(!cheia())
		{
			dados[tamanho] = string;
			tamanho++;
		}
		
	}

	public void adicionaEspecifico(String string, int posicao)
	{
		if(!cheia())
		{
			if(posicao >= 1 && posicao <= tamanho)
			{
				for(int i = tamanho; i >= posicao; i--)
				{
					dados[i] = dados[i-1];
				}
				dados[posicao-1] = string;
				tamanho++;
			}
		}
		
	}

	public String removeInicio()
	{
		String r = "Não foi";
		if(!vazia())
		{
			r = dados[0];
			for(int i = 0; i < tamanho; i++)
			{
				dados[i] = dados[i+1];
			}
			tamanho--;
		}
		return r;
	}

	public String removeFinal() 
	{
		String r = "Não foi";
		if(!vazia())
		{
			r = dados[tamanho - 1];
			tamanho--;
		}
		
		
		return r;
	}

	public String removeEspecifico(int posicao) 
	{
		String r = "Não foi";
		if(!vazia())
		{
			r = dados[posicao - 1];
			if(posicao >= 1 && posicao <= tamanho)
			{
				for(int i = posicao; i < tamanho; i++)
				{
					dados[i-1] = dados[i];
				}
				tamanho--;
			}
		}
		return r;
		
	}

	public String ObtemPrimeiro()
	{
		String r = "";
		
		if(!vazia())
		{
			r = dados[0];
		}
		
		return r;
	}

	public String ObtemUltimo()
	{
		String r = "vazia";
		if(!vazia())
		{
			r = dados[tamanho-1];
		}
		
		return r;
	}

	public boolean vazia() 
	{
		return tamanho == 0;
	}
	
	public boolean cheia() 
	{
		return tamanho == dados.length;
	}
	
	public String toString()
	{
		String r = "";
		for(int i = 0; i < tamanho; i++)
		{
			r += dados[i] + ", ";
		}
		return r;
	}
	
}
