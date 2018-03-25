package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistencia.Conexao;
import persistencia.Persistencia;
import beans.BeansCategoria;
import beans.BeansCliente;
import beans.BeansTitulos;

public class DaoTitulos {
	
	Persistencia conexao = new Persistencia();
	BeansTitulos tit;

	public void CadastrarTitulos(BeansTitulos tit)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("Insert into tbl_titulos values(null,?,?,?,?,?,?)");
			pst.setString(1, tit.getNome());
			pst.setDouble(2, tit.getValor());
			pst.setString(3, tit.getCategoria());
			pst.setString(4, tit.getLancamento());
			pst.setString(5, tit.getCensura());
			pst.setBytes(6, tit.getImagen());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Titulo Cadastrado Com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Cadastrar Titulo");
		}
		
		conexao.desconecta();
		
		
	}
	
	public void AlterarTitulos(BeansTitulos tit)

	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("UPDATE `tbl_titulos` SET `nome`=?,`valor`=?,`categoria`=?,`lancamento`=?,`censura`=?,`imagen`=? WHERE `codigo` = ?");
			pst.setString(1, tit.getNome());
			pst.setDouble(2, tit.getValor());
			pst.setString(3, tit.getCategoria());
			pst.setString(4, tit.getLancamento());
			pst.setString(5, tit.getCensura());
			pst.setBytes(6, tit.getImagen());
			pst.setInt(7, tit.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Titulo Alterado Com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Alterar Titulo");
		}
		
		conexao.desconecta();
		
		
	}
	
	public void ExcluirTitulos(BeansTitulos tit)
	{
		conexao.conexao();
		try 
		{
			PreparedStatement pst = conexao.con.prepareStatement("DELETE FROM `tbl_titulos` WHERE codigo =?");
			pst.setInt(1, tit.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null,"Titulo Excluido Com Sucesso");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao Excluir Titulo");
		}
		
		conexao.desconecta();
	}
	
	
	public BeansTitulos buscar(Integer id)
    {
		BeansTitulos retorno = null;
        String sql = "SELECT codigo,imagen from tbl_titulos where codigo = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                retorno = new BeansTitulos();
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

