package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectaBanco {
	
	
		private static final String URL = "jdbc:mysql://127.0.0.1:3306/bd_locadora";
		private static Connection conn = null;
		public static ResultSet rs = null;
		private static Statement stm = null;
		private static final String PASSWORD = "alunofatec";
		private static final String USER = "root";
		
		
		public static boolean getConnection(){
			
		 
		try {
		conn = DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println(conn + "Conexão efetuada com Sucesso!");
		
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		return true;
				
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel realizar a conexão\nErro: "+e);
			return false;
		}
	}
		
		public static void close()
		{
			CloseConnection();
			CloseResultSet();
			CloseStatement();
		}
		
		private static void CloseConnection(){
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, "Não foi possivel fechar a conexão\nErro: "+e);
			}
		}
		
		private static void CloseStatement(){

			
			try
			{
				stm.close();
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, "Não foi possivel fechar o Statement\nErro: "+e);
			}
		}
		
		public static void setResultSet(String sql)
		{
			try
			{
				rs = stm.executeQuery(sql);
				
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nao Foi possivel ");
			}
			
		
		}
				
		private static void CloseResultSet(){

			try
			{
				rs.close();
			}
			catch(SQLException e)
			{
			}
		}
		
		public static int runOK(String sql)
		{
			int quant = 0;
			try
			{
				quant = stm.executeUpdate(sql);
				
			} catch (SQLException e)
			{
				JOptionPane.showMessageDialog(null, "Não foi possivel fechar o ResultSet");
			}
			return quant;
			
		}
			
		
	
}
