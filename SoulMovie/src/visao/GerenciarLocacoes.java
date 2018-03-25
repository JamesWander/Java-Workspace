package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import persistencia.Persistencia;
import beans.BeansLocacao;
import beans.BeansTabela;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.DaoLocacao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GerenciarLocacoes extends JInternalFrame {
	private JTable tbDevolucao;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtPesquisa;
	private JTable tbFilmes;
	private BeansLocacao loc = new BeansLocacao();
	private DaoLocacao lod = new DaoLocacao();

	public GerenciarLocacoes() {
		setClosable(true);
		setIconifiable(true);
		
		//---------Nimbus-Teme ----------//
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					 break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
						    // handle exception
		} catch (ClassNotFoundException e) {
						    // handle exception
		} catch (InstantiationException e) {
						    // handle exception
		} catch (IllegalAccessException e) {
						    // handle exception
		}
		setBounds(100, 100, 602, 589);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(6, 33, 573, 111);
		getContentPane().add(panel);
		
		JLabel label_3 = new JLabel("Pesquisar:");
		label_3.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		label_3.setBounds(6, 29, 69, 16);
		panel.add(label_3);
		
		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				preencherTabela("SELECT L.codigo, F.nome AS NomeFuncionario, C.nome AS NomeCliente, datadevolucao AS DataDevolucao,C.telefone as TelefoneCliente, C.celular as CelularCliente, C.email as EmailCliente, C.codigo as CodigoCliente, L.estado as estado FROM tbl_locacao AS L INNER JOIN tbl_funcionarios AS F ON L.funcionario = F.codigo INNER JOIN tbl_clientes AS C ON L.cliente = C.codigo where C.nome like'%"+txtPesquisa.getText()+"%'");
				
			}
		});
		txtPesquisa.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
				
			}
		});
		txtPesquisa.setColumns(10);
		txtPesquisa.setBounds(87, 23, 476, 28);
		panel.add(txtPesquisa);
		
		JButton button_1 = new JButton("Devolvido");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loc.setCodigo(Integer.parseInt((String) tbDevolucao.getValueAt(tbDevolucao.getSelectedRow(),0)));
				lod.alterarLocacao(loc);
				Persistencia conexao = new Persistencia();
				conexao.conexao();
				
				PreparedStatement pst;
				try 
				{
					pst = conexao.con.prepareStatement("call devolucoes()");
					pst.executeUpdate();
				} 
				catch (SQLException e) 
				{

					e.printStackTrace();
				}
				
				
				 conexao.desconecta();
			}
		});
		button_1.setBounds(304, 70, 122, 35);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Excluir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja Excluir?","Excluir Titulo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					loc.setCodigo(Integer.parseInt((String) tbDevolucao.getValueAt(tbDevolucao.getSelectedRow(),0)));
					lod.excluirLocacao(loc);
					txtTelefone.setText("");
					txtCelular.setText("");
					txtEmail.setText("");
					
				}
				preencherTabela("SELECT L.codigo, F.nome AS NomeFuncionario, C.nome AS NomeCliente, datadevolucao AS DataDevolucao,C.telefone as TelefoneCliente, C.celular as CelularCliente, C.email as EmailCliente, C.codigo as CodigoCliente, L.estado as estado FROM tbl_locacao AS L INNER JOIN tbl_funcionarios AS F ON L.funcionario = F.codigo INNER JOIN tbl_clientes AS C ON L.cliente = C.codigo");
			}
		});
		button_2.setBounds(438, 70, 129, 35);
		panel.add(button_2);
		
		JLabel lblGerenciarLocaes = new JLabel("Gerenciar Loca\u00E7\u00F5es");
		lblGerenciarLocaes.setForeground(new Color(51, 102, 255));
		lblGerenciarLocaes.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 27));
		lblGerenciarLocaes.setBackground(Color.WHITE);
		lblGerenciarLocaes.setBounds(168, 6, 273, 28);
		getContentPane().add(lblGerenciarLocaes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(6, 156, 330, 189);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 318, 177);
		panel_1.add(scrollPane);
		
		tbDevolucao = new JTable();
		tbDevolucao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				crud();
				
			}
		});
		scrollPane.setViewportView(tbDevolucao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		panel_2.setBounds(5, 493, 574, 59);
		getContentPane().add(panel_2);
		
		JButton button = new JButton("Primeiro");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbDevolucao.setRowSelectionInterval(0,0);
				crud();
				preencherTabela("SELECT L.codigo, F.nome AS NomeFuncionario, C.nome AS NomeCliente, datadevolucao AS DataDevolucao,C.telefone as TelefoneCliente, C.celular as CelularCliente, C.email as EmailCliente, C.codigo as CodigoCliente, L.estado as estado FROM tbl_locacao AS L INNER JOIN tbl_funcionarios AS F ON L.funcionario = F.codigo INNER JOIN tbl_clientes AS C ON L.cliente = C.codigo");
			}
		});
		button.setBounds(18, 14, 102, 28);
		panel_2.add(button);
		
		JButton button_5 = new JButton("Voltar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbDevolucao.setRowSelectionInterval(tbDevolucao.getSelectedRow()-1, tbDevolucao.getSelectedRow()-1);
				crud();
			}
		});
		button_5.setBounds(125, 14, 102, 28);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("Avan\u00E7ar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbDevolucao.setRowSelectionInterval(tbDevolucao.getSelectedRow()+1, tbDevolucao.getSelectedRow()+1);
				crud();
			}
		});
		button_6.setBounds(235, 14, 102, 28);
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("Ultimo");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbDevolucao.setRowSelectionInterval(tbDevolucao.getRowCount()-1, tbDevolucao.getRowCount()-1);
				crud();
			}
		});
		button_7.setBounds(342, 14, 102, 28);
		panel_2.add(button_7);
		
		JButton button_8 = new JButton("Atualizar");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabela("SELECT L.codigo, F.nome AS NomeFuncionario, C.nome AS NomeCliente, datadevolucao AS DataDevolucao,C.telefone as TelefoneCliente, C.celular as CelularCliente, C.email as EmailCliente, C.codigo as CodigoCliente, L.estado as estado FROM tbl_locacao AS L INNER JOIN tbl_funcionarios AS F ON L.funcionario = F.codigo INNER JOIN tbl_clientes AS C ON L.cliente = C.codigo");
			}
		});
		button_8.setBounds(448, 14, 102, 28);
		panel_2.add(button_8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 355, 578, 126);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("Telefone:");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(6, 26, 102, 24);
		panel_3.add(label);
		
		txtTelefone = new JTextField();
		txtTelefone.setEnabled(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(6, 62, 181, 43);
		panel_3.add(txtTelefone);
		
		txtCelular = new JTextField();
		txtCelular.setEnabled(false);
		txtCelular.setColumns(10);
		txtCelular.setBounds(197, 62, 181, 43);
		panel_3.add(txtCelular);
		
		JLabel label_1 = new JLabel("Celular:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(197, 26, 123, 24);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("E-Mail:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(386, 26, 111, 24);
		panel_3.add(label_2);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(386, 62, 181, 43);
		panel_3.add(txtEmail);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Filmes da Loca\u00E7\u00E3o", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel_4.setBounds(343, 156, 236, 189);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 19, 224, 164);
		panel_4.add(scrollPane_1);
		
		tbFilmes = new JTable();
		scrollPane_1.setViewportView(tbFilmes);
		preencherTabela("SELECT L.codigo, F.nome AS NomeFuncionario, C.nome AS NomeCliente, datadevolucao AS DataDevolucao,C.telefone as TelefoneCliente, C.celular as CelularCliente, C.email as EmailCliente, C.codigo as CodigoCliente, L.estado as estado FROM tbl_locacao AS L INNER JOIN tbl_funcionarios AS F ON L.funcionario = F.codigo INNER JOIN tbl_clientes AS C ON L.cliente = C.codigo");

	}
	

	
	public void crud()
	{

		txtTelefone.setText((String) tbDevolucao.getValueAt(tbDevolucao.getSelectedRow(),4));
		txtCelular.setText((String) tbDevolucao.getValueAt(tbDevolucao.getSelectedRow(),5));
		txtEmail.setText((String) tbDevolucao.getValueAt(tbDevolucao.getSelectedRow(),6));
		
		
		Persistencia conexao = new Persistencia();
		
		ArrayList dados = new ArrayList();
		String[] colunas = new String[]{"Filmes"};
		
		conexao.conexao();
		
		conexao.execultaSql("SELECT T.nome as Filmes FROM `tbl_locacao` as L INNER JOIN tbl_locacao_filme as LF on L.codigo = LF.codigo_locacao INNER JOIN tbl_titulos as T on LF.codigo_titulo = T.codigo where L.codigo = "+tbDevolucao.getValueAt(tbDevolucao.getSelectedRow(),0));
		
		try
		{
			conexao.rs.first();
			do
			{
				dados.add(new Object[]{conexao.rs.getString("Filmes")});
			}while(conexao.rs.next());
	
		}
		catch(SQLException erro)
		{
			
		}
		BeansTabela modelo = new BeansTabela(dados,colunas);
		tbFilmes.setModel(modelo);

		
		conexao.desconecta();
		
		
	}
	
	public void preencherTabela(String Sql)
	{
		
		Persistencia conexao = new Persistencia();
		
		ArrayList dados = new ArrayList();
		String[] colunas = new String[]{"Codigo Locação","Nome Funcionario","Nome Cliente","Data Devolução","TelefoneCliente","CelularCliente","EmailCliente","CodigoCliente","Estado"};
		
		conexao.conexao();
		
		conexao.execultaSql(Sql);
		
		try
		{
			conexao.rs.first();
			do
			{
				dados.add(new Object[]{conexao.rs.getString("codigo"),conexao.rs.getString("NomeFuncionario"),conexao.rs.getString("NomeCliente"),conexao.rs.getString("DataDevolucao"),conexao.rs.getString("TelefoneCliente"),conexao.rs.getString("CelularCliente"),conexao.rs.getString("EmailCliente"),conexao.rs.getString("CodigoCliente"),conexao.rs.getString("estado")});                                              
			}while(conexao.rs.next());
			
	
		}
		catch(SQLException erro)
		{
			
		}
		BeansTabela modelo = new BeansTabela(dados,colunas);
		tbDevolucao.setModel(modelo);
		
		tbDevolucao.getColumnModel().getColumn(4).setMinWidth(0);
		tbDevolucao.getColumnModel().getColumn(4).setMaxWidth(0);
		tbDevolucao.getColumnModel().getColumn(4).setWidth(0);
		
		tbDevolucao.getColumnModel().getColumn(5).setMinWidth(0);
		tbDevolucao.getColumnModel().getColumn(5).setMaxWidth(0);
		tbDevolucao.getColumnModel().getColumn(5).setWidth(0);
		
		tbDevolucao.getColumnModel().getColumn(6).setMinWidth(0);
		tbDevolucao.getColumnModel().getColumn(6).setMaxWidth(0);
		tbDevolucao.getColumnModel().getColumn(6).setWidth(0);
		
		tbDevolucao.getColumnModel().getColumn(7).setMinWidth(0);
		tbDevolucao.getColumnModel().getColumn(7).setMaxWidth(0);
		tbDevolucao.getColumnModel().getColumn(7).setWidth(0);
		
		conexao.desconecta();
		
	}
}
