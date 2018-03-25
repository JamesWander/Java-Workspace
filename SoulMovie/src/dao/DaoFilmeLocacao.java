package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistencia.Persistencia;
import beans.BeansFilmeLocacao;
import beans.BeansLocacao;

public class DaoFilmeLocacao {
	
	Persistencia conexao = new Persistencia();
	BeansFilmeLocacao floc;
	
	public void cadastrarFilmeLocacao(BeansFilmeLocacao floc)
	{
		conexao.conexao();
		
		try 
		{		
				PreparedStatement pst = conexao.con.prepareStatement("Insert into tbl_locacao_filme values(null,?,?)");
				pst.setInt(1, floc.getCodigo_locacao());
				pst.setInt(2, floc.getCodigo_titulo());
				pst.execute();
				
			
			
			
		} 
		catch (SQLException e) 
		{
			
		}
	}
	
}
