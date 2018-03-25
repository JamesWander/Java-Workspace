package outros;

import java.awt.Frame;
import java.io.InputStream;
import java.util.HashMap;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.Persistencia;

public class Relatorios {

	private static String path;
	
	public  void callRelatorio(String nomeRel, String title, HashMap<String, Object> filtro)
	{
		try
		{
			Persistencia conexao = new Persistencia();
			conexao.conexao();
			
			//path = "src/relatorios/"+nomeRel+".jasper";
			
			InputStream path = getClass().getResourceAsStream("/relatorios/"+nomeRel+".jasper");
			//path = "I:/tudo/3 semestre/Java/Locadora/SoulMovie/RelatorioLocacoes.jasper";
			JasperPrint print = JasperFillManager.fillReport(path, filtro, conexao.con);
			JasperViewer viewr = new JasperViewer(print, false);
			viewr.setVisible(true);
			viewr.setExtendedState(Frame.MAXIMIZED_BOTH);
			viewr.setTitle(title);
			
			
			
			conexao.desconecta();
			
		}
		catch(JRException erro)
		{
			JOptionPane.showMessageDialog(null,erro);
		}
	}
}
