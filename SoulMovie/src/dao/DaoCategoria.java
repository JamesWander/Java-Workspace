package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import persistencia.Persistencia;
import beans.BeansCategoria;

public class DaoCategoria {

	Persistencia conexao = new Persistencia();
	BeansCategoria cat;
	
	public void cadastrarCategoria(BeansCategoria cat)
	{
		conexao.conexao();
		
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("Insert into tbl_categoria values(null,?)");
			pst.setString(1, cat.getNome());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Categoria Cadastrada com Sucesso!");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Cadastrar");
		}
		
		conexao.desconecta();
	}
	
	public void alterarCategoria(BeansCategoria cat)
	{
		conexao.conexao();
		
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("UPDATE tbl_categoria set nome = ? where codigo = ?");
			pst.setString(1, cat.getNome());
			pst.setInt(2, cat.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Categoria Alterada com Sucesso!");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Alterar");
		}
		
		conexao.desconecta();
	}
	
	public void excluirCategoria(BeansCategoria cat)
	{
		conexao.conexao();
		
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("DELETE FROM tbl_categoria where codigo = ?");
			pst.setString(1, Integer.toString(cat.getCodigo()));
			pst.execute();
			JOptionPane.showMessageDialog(null,"Categoria Excluida com Sucesso!");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Excluir");
		}
		
		conexao.desconecta();
	}
	
	
}
