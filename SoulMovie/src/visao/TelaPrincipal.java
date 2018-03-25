package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SpringLayout;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Window.Type;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.DaoFuncionarios;
import beans.BeansFuncionario;
import outros.DadosLogin;
import outros.ManipularImagem;
import outros.Relatorios;
import persistencia.Persistencia;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;


public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private static HashMap fil;
	private JLabel lblFoto;
	
	
	BeansFuncionario funImg = new BeansFuncionario();
	DaoFuncionarios func = new DaoFuncionarios();
	
	public TelaPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		this.setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 598);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRelatorios = new JMenu("Relatorios");

		mnRelatorios.setMnemonic('R');
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmLocao = new JMenuItem("Loca\u00E7\u00E3o");
		mntmLocao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
		mntmLocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fil = new HashMap<>();
				Relatorios relatorio = new Relatorios();
				
				relatorio.callRelatorio("RelatorioLocacoes","Relatorio de Locações", fil);

			}
		});
		
		mnRelatorios.add(mntmLocao);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcionarios");
		mntmFuncionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0));
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fil = new HashMap<>();
				Relatorios relatorio = new Relatorios();
				
				relatorio.callRelatorio("RelatorioFuncionarios","Relatorio de Funcionarios", fil);
				
			}
		});
		mnRelatorios.add(mntmFuncionarios);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0));
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fil = new HashMap<>();
				Relatorios relatorio = new Relatorios();
				
				relatorio.callRelatorio("RelatorioClientes","Relatorio de Clientes", fil);
			}
		});
		mnRelatorios.add(mntmClientes);
		
		JMenuItem mntmTitulos = new JMenuItem("Titulos");
		mntmTitulos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0));
		mntmTitulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fil = new HashMap<>();
				Relatorios relatorio = new Relatorios();
				
				relatorio.callRelatorio("RelatorioTitulos","Relatorio de Titulos", fil);
				
			}
		});
		mnRelatorios.add(mntmTitulos);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)), "Menu", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		panel.setLayout(new GridLayout(1, 6, 0, 0));
		
		JButton btnLocacoes = new JButton("Loca\u00E7\u00F5es");
		btnLocacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locacao f = new Locacao();
				desktopPane.add(f);
				f.setVisible(true);
			}
		});
		panel.add(btnLocacoes);
		
		JButton btnDevolucoes = new JButton("Devolu\u00E7\u00F5es");
		btnDevolucoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarLocacoes f = new GerenciarLocacoes();
				desktopPane.add(f);
				f.setVisible(true);
			}
		});
		panel.add(btnDevolucoes);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrodeClientes f = new CadastrodeClientes();
				desktopPane.add(f);
				f.setVisible(true);
				
			}
		});

		panel.add(btnClientes);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				if(DadosLogin.getTipo().equals("Administrador"))
				{
					CadastrodeFuncionario f = new CadastrodeFuncionario();
					desktopPane.add(f);
					f.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Somente Para Administradores");
					
				}
				
				
			}
		});
		panel.add(btnFuncionarios);
		
		JButton btnTitulos = new JButton("Titulos");
		btnTitulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrodeTitulos f = new CadastrodeTitulos();
				desktopPane.add(f);
				f.setPosicao();
				f.setVisible(true);
				
			}
		});
		panel.add(btnTitulos);
		
		JButton btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrodeCategorias f = new CadastrodeCategorias();
				desktopPane.add(f);
				f.setVisible(true);
			}
		});
		panel.add(btnCategorias);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Usuario", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		
		JPanel panelTransparente = new JPanel();
		panelTransparente.setBackground(new Color(214, 217, 223));
		panelTransparente.setOpaque(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(UIManager.getColor("ArrowButton.background"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(UIManager.getColor("ArrowButton.background"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBackground(UIManager.getColor("ArrowButton.background"));
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTransparente, GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1078, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(953, Short.MAX_VALUE))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(34)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelTransparente, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblFoto.setBounds(12, 27, 115, 79);
		panel_1.add(lblFoto);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNome.setBounds(16, 120, 94, 16);
		lblNome.setText(DadosLogin.getNome());
		panel_1.add(lblNome);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblTipo.setBounds(16, 148, 94, 16);
		lblTipo.setText(DadosLogin.getTipo());
		panel_1.add(lblTipo);
		
		
		
		JLabel lblData = new JLabel("Data");
		
		Calendar calendar2 = new GregorianCalendar();
		calendar2.add(Calendar.DATE,+0);
		calendar2.getTime();
		SimpleDateFormat formatarDate2 = new SimpleDateFormat("dd/MM/yyyy");
		lblData.setText(formatarDate2.format(calendar2.getTime()));
		
		lblData.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblData.setBounds(16, 178, 72, 16);
		panel_1.add(lblData);
		desktopPane.setLayout(gl_desktopPane);
		ajustaImagem();
		
		
		verificaAtraso();
	}
		
	private void ajustaImagem()
	{
		funImg = func.buscar(DadosLogin.getCodigo());
		ManipularImagem.exibiImagemLabel(funImg.getImagen(), lblFoto);
	}
	
	
	private void verificaAtraso()
	{
		Persistencia conexao = new Persistencia();
		
		conexao.conexao();
		int quant;
		try {
			PreparedStatement pst = conexao.con.prepareStatement(" Update tbl_locacao as L set L.estado = 'Atrasado' where CURdate() > STR_TO_DATE(datadevolucao,'%d/%m/%Y') and L.estado != 'Devolvido' and L.estado != 'Atrasado';");
			quant = pst.executeUpdate();
			PreparedStatement psa = conexao.con.prepareStatement("call devolucoes()");
			psa.execute();
			if(quant >= 1)
			{
			 JOptionPane.showMessageDialog(null,"Existe Devoluções Atrasadas, os Clientes foram bloqueados");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.desconecta();
	}
		
		

	
	
}
