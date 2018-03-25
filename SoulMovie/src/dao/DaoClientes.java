package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import beans.BeansCliente;
import beans.BeansFuncionario;
import persistencia.Conexao;
import persistencia.Persistencia;

public class DaoClientes {

	Persistencia conexao = new Persistencia();
	BeansCliente cli;
	
	public void CadastrarCliente(BeansCliente cli)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("Insert into tbl_clientes values(null,?,?,?,?,?,?,?,?,?,?,?,?,false)");
			pst.setString(1, cli.getNome());
			pst.setString(2, cli.getCpf());
			pst.setString(3, cli.getNascimento());
			pst.setString(4, cli.getTelefone());
			pst.setString(5, cli.getCelular());
			pst.setString(6, cli.getEmail());
			pst.setString(7, cli.getBairro());
			pst.setString(8, cli.getRua());
			pst.setString(9, cli.getCidade());
			pst.setString(10, cli.getCep());
			pst.setString(11, cli.getNumero());
			pst.setBytes(12, cli.getImagen());
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso!");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Cadastrar");
		}
		
		conexao.desconecta();
		
		
	}

	public void AlterarCliente(BeansCliente cli)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("UPDATE `tbl_clientes` SET `nome`=?,`cpf`=?,`nascimento`=?,`telefone`=?,`celular`=?,`email`=?,`bairro`=?,`rua`=?,`cidade`=?,`cep`=?,`numero`=?,`imagen`=? WHERE `codigo` = ?");
			pst.setString(1, cli.getNome());
			pst.setString(2, cli.getCpf());
			pst.setString(3, cli.getNascimento());
			pst.setString(4, cli.getTelefone());
			pst.setString(5, cli.getCelular());
			pst.setString(6, cli.getEmail());
			pst.setString(7, cli.getBairro());
			pst.setString(8, cli.getRua());
			pst.setString(9, cli.getCidade());
			pst.setString(10, cli.getCep());
			pst.setString(11, cli.getNumero());
			pst.setBytes(12, cli.getImagen());
			pst.setInt(13, cli.getCodigo());
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Cliente Alterado com Sucesso!");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Alterar");
		}
		
		conexao.desconecta();
		
	}

	public void ExcluirCliente(BeansCliente cli)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("DELETE FROM `tbl_clientes` WHERE `codigo` = ?");

			pst.setInt(1, cli.getCodigo());
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Cliente Excluido com Sucesso!");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Excluir");
		}
		
		conexao.desconecta();
	}
	
	public BeansCliente buscar(Integer id)
    {
		BeansCliente retorno = null;
        String sql = "SELECT codigo,imagen from tbl_clientes where codigo = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                retorno = new BeansCliente();
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setImagen(rs.getBytes("imagen"));
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }
        
        return retorno;
    
    }

}
