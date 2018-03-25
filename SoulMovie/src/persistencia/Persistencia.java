package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class Persistencia {
	
	
	private String PASSWORD = "alunofatec";
	private String USER = "root";
	private String URL = "jdbc:mysql://127.0.0.1:3306/db_locadora";
	public Statement stm;
	public ResultSet rs;
	public Connection con;
	
	public void conexao()
	{
		try 
		{
			con = DriverManager.getConnection(URL,USER,PASSWORD);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println(con + "Conexão efetuada com Sucesso!");
		
		try 
		{
			stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	public void desconecta()
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void execultaSql(String sql)
	{
		try 
		{
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	
}
