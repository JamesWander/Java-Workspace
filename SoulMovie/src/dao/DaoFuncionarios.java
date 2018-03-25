package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import beans.BeansFuncionario;
import persistencia.Conexao;
import persistencia.Persistencia;

public class DaoFuncionarios {
	
	Persistencia conexao = new Persistencia();
	BeansFuncionario fun;
	
	public void CadastrarFuncionario(BeansFuncionario fun)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("Insert into tbl_funcionarios values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fun.getNome());
			pst.setString(2, fun.getCpf());
			pst.setString(3, fun.getNascimento());
			pst.setString(4, fun.getCargo());
			pst.setDouble(5, fun.getSalario());
			pst.setString(6, fun.getSexo());
			pst.setString(7, fun.getBairro());
			pst.setString(8, fun.getCidade());
			pst.setString(9, fun.getCep());
			pst.setString(10, fun.getUf());
			pst.setString(11, fun.getNumero());
			pst.setString(12, fun.getLogin());
			pst.setString(13, fun.getSenha());
			pst.setString(14, fun.getTipo());
			pst.setBytes(15, fun.getImagen());
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Funcionario Cadastrado com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Cadastrar");
		}
		
		conexao.desconecta();
		
		
	}
	
	public void AlterarFuncionario(BeansFuncionario fun)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("UPDATE `tbl_funcionarios` SET `nome`=?,`cpf`=?,`nascimento`=?,`cargo`=?,`salario`=?,`sexo`=?,`bairro`=?,`cidade`=?,`cep`=?,`uf`=?,`numero`=?,`login`=?,`senha`=?,`tipo`=?,`imagen`=? WHERE `codigo` = ?");
			pst.setString(1, fun.getNome());
			pst.setString(2, fun.getCpf());
			pst.setString(3, fun.getNascimento());
			pst.setString(4, fun.getCargo());
			pst.setDouble(5, fun.getSalario());
			pst.setString(6, fun.getSexo());
			pst.setString(7, fun.getBairro());
			pst.setString(8, fun.getCidade());
			pst.setString(9, fun.getCep());
			pst.setString(10, fun.getUf());
			pst.setString(11, fun.getNumero());
			pst.setString(12, fun.getLogin());
			pst.setString(13, fun.getSenha());
			pst.setString(14, fun.getTipo());
			pst.setBytes(15, fun.getImagen());
			pst.setInt(16, fun.getCodigo());
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Funcionario Alterado com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Alterar");
		}
		
		conexao.desconecta();
		
	}
	
	public void ExcluirFuncionario(BeansFuncionario fun)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("DELETE FROM `tbl_funcionarios` WHERE `codigo` = ?");
			pst.setInt(1, fun.getCodigo());
	
			pst.execute();
			JOptionPane.showMessageDialog(null,"Funcionario Excluido com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Excluir");
		}
		
		conexao.desconecta();
		
	}
	
	public BeansFuncionario buscar(Integer id)
    {
		BeansFuncionario retorno = null;
        String sql = "SELECT codigo,imagen from tbl_funcionarios where codigo = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                retorno = new BeansFuncionario();
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
