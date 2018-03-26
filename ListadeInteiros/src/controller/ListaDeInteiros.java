package controller;
/**
 * Lista de Números inteiros
 * @author James Wander Ferreira de Souza Junior
 * @version 05/03/2018
 */

import javax.swing.JOptionPane;


public class ListaDeInteiros {

	private int dados[];
	private int tamanho;
	
	/**
	 * Construtor
	 * @param capMax é a capacidade máxima da lista 
	 */
	public ListaDeInteiros(int capMax)
	{
		dados = new int[capMax];
		tamanho = 0;
		
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < tamanho; i++)
		{
			str += dados[i] + " ";  
		}
		return str;
		
	}
	
	public void adicionaInicio(int e)
	{
		if(cheia())
		{
			JOptionPane.showMessageDialog(null, "Lista Cheia");
		}
		else
		{
			for(int i = tamanho; i>0; i--)
			{
				dados[i] = dados[i-1];
			}
			dados[0] = e;
			tamanho++;
		}
	}
	
	public int removeInicio()
	{
		int r = -1;
		if(vazia())
		{
			JOptionPane.showMessageDialog(null, "Lista Vazia");
		}
		else
		{
			r = dados[0];	
			for(int i = 1; i <= tamanho-1; i++)
			{
				dados[i-1] = dados[i];
			}
			tamanho--;
		}
		
		return r;
	}

	public boolean cheia()
	{
		return dados.length == tamanho;
	}
	
	public boolean vazia()
	{
		
		return tamanho == 0;
	}

	public void adicionaFinal(int e)
	{
		if(cheia())
		{
			JOptionPane.showMessageDialog(null, "Lista Cheia");
		}
		else
		{
			dados[tamanho] = e;
			tamanho++;
		}
	}

	public int removeFinal()
	{
		int r = -1;
		
		if(vazia())
		{
			JOptionPane.showInputDialog(null,"Lista vazia");
		}
		else
		{
			r = dados[--tamanho];
		}
		return r;
	}

	public int ObtemPrimeiro()
	{
		int r = -1;
		if(vazia())
		{
			JOptionPane.showMessageDialog(null, "Lista Vazia");
		}
		else
		{
			r = dados[0];
		}
		return r;
	}

	public int ObtemUltimo()

	{
		int r = -1;
		if(vazia())
		{
			JOptionPane.showMessageDialog(null, "Lista Vazia");
		}
		else
		{
			r = dados[tamanho-1];
		}
		return r;
	}
	

	public void adicionaEspecifico(int valor, int posicao)
	{
		if(!cheia())
		{
			if(posicao >= 1 && posicao <= tamanho)
			{
				for(int i = tamanho; i >= posicao; i--)
				{
					dados[i] = dados[i-1];
					
				}
				dados[posicao-1] = valor;
				tamanho++;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Lista Cheia");
		}
	}
	
	public int removeEspecifico(int posicao)
	{
		int r = -1;
		
		if(!vazia())
		{
			if(posicao >= 1 && posicao <= tamanho)
			{
				r = dados[posicao - 1];
				for(int i = posicao; i < tamanho; i++)
				{
					dados[i-1] = dados[i];
				}
				tamanho--;
			}
		}
		
		return r;
	}
}











