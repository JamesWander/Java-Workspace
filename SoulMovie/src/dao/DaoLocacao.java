package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistencia.Persistencia;
import visao.Locacao;
import beans.BeansCategoria;
import beans.BeansLocacao;

public class DaoLocacao {

	Persistencia conexao = new Persistencia();
	BeansLocacao loc;
	
	public void cadastrarLocacao(BeansLocacao loc)
	{
		conexao.conexao();
		
		try 
		{
			
			PreparedStatement pst = conexao.con.prepareStatement("Insert into tbl_locacao values(null,?,?,?,?,?,?,?)");
			pst.setInt(1, loc.getFuncionario());
			pst.setInt(2, loc.getCliente());
			pst.setString(3, loc.getDataAtual());
			pst.setInt(4, loc.getNumeroFilme());
			pst.setString(5, loc.getDataDevolucao());
			pst.setDouble(6, loc.getTotal());
			pst.setString(7, loc.getEstado());
			
			conexao.execultaSql("select bloqueado from tbl_clientes where codigo ="+loc.getCliente());
			
			conexao.rs.first();
			if(conexao.rs.getBoolean("bloqueado") == false)
			{
				
				pst.execute();
				JOptionPane.showMessageDialog(null,"Locação Realizada com Sucesso");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Locação Não Realizado: Cliente Bloqueado");
			}
			
			
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao realizar Locação");
		}
		
		
		
		conexao.desconecta();
	}
	
	public void alterarLocacao(BeansLocacao loc)
	{
		conexao.conexao();
		
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("UPDATE tbl_locacao set estado = ? where codigo = ?");
			pst.setString(1,"Devolvido");
			pst.setInt(2,loc.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Locação Alterada com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Alterar Locação");
		}
		
		conexao.desconecta();
	}
	
	public void excluirLocacao(BeansLocacao loc)
	{
		conexao.conexao();
		
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("DELETE FROM tbl_locacao where codigo = ?");
			pst.setInt(1, loc.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Locação Excluida com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Excluir Locação");
		}
		
		conexao.desconecta();
	}
	
	public BeansLocacao buscaLocacao(BeansLocacao loc)
	{
		conexao.conexao();
		conexao.execultaSql("SELECT * FROM tbl_Locacao WHERE nome like'%"+loc.getNomeCliente()+"%'");
		try
		{
			conexao.rs.first();
			loc.setCodigo(conexao.rs.getInt("codigo"));
			//loc.setNome(conexao.rs.getString("nome"));
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		conexao.desconecta();
		return loc;
	}

}
