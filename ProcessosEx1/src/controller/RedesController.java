package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController()
	{
		super();
	}
	
	
	public String ip(String sistema)
	{
		StringBuffer ipconfig = new StringBuffer();
		String adaptador = "";
		if(sistema.contains("Windows"))
		{
			try 
			{
				Process processo = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				
				String linha = buffer.readLine();
				while(linha!=null)
				{
					if(linha.contains("Adaptador"))
					{
						adaptador = linha.toString();
						linha = buffer.readLine();
						do
						{
							linha = buffer.readLine();
							if(linha!= null && linha.contains("IPv4"))
							{
								ipconfig.append(adaptador + linha.substring(linha.indexOf(":")+1, linha.length()) + "\n");
								
								break;
							}
						}while(linha != null && linha != "");
						
					}
					linha = buffer.readLine();
				}
				
				
			} catch (IOException e) {}
			
		}
		return ipconfig.toString();
	}

	public String ping(String sistema)
	{
		StringBuffer ping = new StringBuffer();
		
		Process processo;
		try 
		{	
			processo = Runtime.getRuntime().exec("Ping www.google.com -n 2");
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			while(linha!=null)
			{
				if(linha.contains("M‚dia"))
				{
					ping.append("Media de ping é:"+linha.substring(linha.lastIndexOf("=")+1, linha.length()));
					
				}
				linha = buffer.readLine();
			}
			
		} catch (IOException e) {}
		
		
		return ping.toString();
	}
	
}
