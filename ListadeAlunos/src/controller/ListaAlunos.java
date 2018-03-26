package controller;

import model.Aluno;

public class ListaAlunos {

	private Aluno dados[];
	private int tamanho;
	
	public ListaAlunos(int capMax)
	{
		dados = new Aluno[capMax];
		tamanho = 0;
		
	}

	public void adicionaInicio(Aluno aluno)
	{
		if(!cheia())
		{
			for(int i = tamanho; i>0; i--)
			{
				dados[i] = dados[i-1];
			}
			dados[0] = aluno;
			tamanho++;
		}
		
	}

	public void adicionaFinal(Aluno aluno)
	{

		if(!cheia())
		{
			dados[tamanho] = aluno;
			tamanho++;
		}
		
	}

	public void adicionaEspecifico(Aluno aluno, int posicao) 
	{
		if(!cheia())
		{
			if(posicao >= 1 && posicao <= tamanho)
			{
				for(int i = tamanho ; i >= posicao; i--)
				{
					dados[i] = dados[i-1];
				}
				dados[posicao - 1] = aluno;
				tamanho++;
				
			}
		}
		
	}

	public boolean vazia() 
	{
		
		return tamanho == 0;	
		
	}

	public String removeInicio() 
	{
		String r = "Não foi removido";
		
		if(!vazia())
		{
			r = dados[0].toString() + " foi removido";
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
		String r = "Não foi removido";
		
		if(!vazia())
		{
			r = dados[tamanho-1].toString() + " foi removido";
			tamanho--;
		}
		
		return r;
	}

	public String ObtemPrimeiro() 
	{
		String r = dados[0].toString();
		
		return r;
	}

	public String ObtemUltimo() 
	{
		String r = dados[tamanho-1].toString();
		
		return r;
	}

	private boolean cheia()
	{
		
		return tamanho == dados.length;
		
	}	
	
	public String removeEspecifico(int posicao) 
	{
		String r = "Não foi removido";
		if(!vazia())
		{
			if(posicao >= 1 && posicao <= tamanho)
			{
				r = dados[posicao -1].toString() + " foi removido";
				for(int i = posicao; i < tamanho; i++ )
				{
					dados[i-1] = dados[i]; 
				}
				tamanho--;
			}
		}
		return r;
		
		
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < tamanho; i++)
		{
			str += dados[i].toString() + "\n";  
		}
		return str;
	}
	
}
