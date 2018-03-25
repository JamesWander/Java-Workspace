package visao;

import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import outros.DadosLogin;
import outros.ManipularImagem;
import dao.DaoFilmeLocacao;
import dao.DaoFuncionarios;
import dao.DaoLocacao;
import dao.DaoTitulos;
import beans.BeansCliente;
import beans.BeansFilmeLocacao;
import beans.BeansFuncionario;
import beans.BeansLocacao;
import beans.BeansTabela;
import beans.BeansTitulos;
import persistencia.Persistencia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Locacao extends JInternalFrame {
	private JTextField txtDataAtual;
	private JTable tbLocacoes;
	private JTextField txtDataDevolucao;
	private JTextField txtNumeroFilme;
	private JTextField txtTotal;
	private JComboBox cbCliente;
	private JComboBox cbTitulo;
	private JButton btnConcluir;
	private ArrayList dados;
	DefaultTableModel dtm;
	private Vector vetor;
	private JLabel lblImagem;
	private double valor;
	private JTextField txtFuncionario;
	private int codigo;
	
	DaoTitulos titDao = new DaoTitulos();
	BeansTitulos tit = new BeansTitulos();
	BeansLocacao loc = new BeansLocacao();
	DaoLocacao lod = new DaoLocacao();
	BeansFilmeLocacao floc = new BeansFilmeLocacao();
	DaoFilmeLocacao flod = new DaoFilmeLocacao();
	

	public Locacao() {
		
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
		//-------------Fim --------------//
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 600, 517);
		getContentPane().setLayout(null);
		
		JLabel lblLocaes = new JLabel("Loca\u00E7\u00F5es");
		lblLocaes.setForeground(new Color(51, 102, 255));
		lblLocaes.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 27));
		lblLocaes.setBackground(Color.WHITE);
		lblLocaes.setBounds(223, 6, 129, 28);
		getContentPane().add(lblLocaes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 46, 392, 192);
		getContentPane().add(panel_1);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblFuncionario.setBounds(19, 13, 95, 16);
		panel_1.add(lblFuncionario);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCliente.setBounds(19, 48, 72, 16);
		panel_1.add(lblCliente);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblTitulo.setBounds(19, 120, 95, 16);
		panel_1.add(lblTitulo);
		
		JLabel lblData = new JLabel("Data-Atual:");
		lblData.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblData.setBounds(19, 87, 115, 16);
		panel_1.add(lblData);
		
		txtDataAtual = new JTextField();
		txtDataAtual.setEnabled(false);
		txtDataAtual.setColumns(10);
		txtDataAtual.setBounds(205, 80, 181, 28);
		Calendar calendar = new GregorianCalendar();
	
		
		calendar.add(Calendar.DATE,+0);
		calendar.getTime();
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
		txtDataAtual.setText(formatarDate.format(calendar.getTime()));
		panel_1.add(txtDataAtual);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(205, 42, 181, 28);
		panel_1.add(cbCliente);
		
		cbTitulo = new JComboBox();
		cbTitulo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try
				{
					Integer id = tituloReverso((String) cbTitulo.getSelectedItem());
					tit = titDao.buscar(id);
					ManipularImagem.exibiImagemLabel(tit.getImagen(), lblImagem);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		cbTitulo.setBounds(205, 115, 181, 28);
		panel_1.add(cbTitulo);
		
		JButton btnNewButton = new JButton("Adicionar Titulo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					dtm.addRow(new Object[]{Integer.toString(tituloReverso(cbTitulo.getSelectedItem().toString())),cbTitulo.getSelectedItem()});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tbLocacoes.setModel(dtm);
				try {
					atualizaCampos();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(138, 155, 115, 28);
		panel_1.add(btnNewButton);
		
		JButton btnRemoverTitulo = new JButton("Remover Titulo");
		btnRemoverTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dtm.removeRow(tbLocacoes.getSelectedRow());
				tbLocacoes.setModel(dtm);
				
				try {
					atualizaCampos();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				
			}
		});
		btnRemoverTitulo.setBounds(265, 155, 121, 28);
		panel_1.add(btnRemoverTitulo);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setText(Integer.toString(DadosLogin.getCodigo()));
		txtFuncionario.setEnabled(false);
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(205, 7, 181, 28);
		panel_1.add(txtFuncionario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(410, 46, 168, 192);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblImagem = new JLabel("");
		lblImagem.setBounds(6, 6, 156, 180);
		panel_2.add(lblImagem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(6, 250, 289, 229);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 277, 217);
		panel_3.add(scrollPane);
		
		tbLocacoes = new JTable();
		
		dados = new ArrayList();
		

		//dados.add(new Object[]{"","",cbTitulo.getSelectedItem()});
		

		
		dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo Titulo", "Nome do Filme"
				}
			);
			
		
		tbLocacoes.setModel(dtm);

		tbLocacoes.getColumnModel().getColumn(0).setPreferredWidth(94);
		tbLocacoes.getColumnModel().getColumn(1).setPreferredWidth(107);

		
		scrollPane.setViewportView(tbLocacoes);
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_4.setBounds(302, 250, 276, 229);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNu = new JLabel("Numero Filmes:");
		lblNu.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNu.setBounds(16, 29, 108, 16);
		panel_4.add(lblNu);
		
		JLabel lblAs = new JLabel("Total:");
		lblAs.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblAs.setBounds(16, 107, 72, 16);
		panel_4.add(lblAs);
		
		JLabel label_2 = new JLabel("Data Devolu\u00E7\u00E3o");
		label_2.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		label_2.setBounds(13, 69, 108, 16);
		panel_4.add(label_2);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setEnabled(false);
		txtDataDevolucao.setColumns(10);
		txtDataDevolucao.setBounds(146, 63, 124, 28);	
		Calendar calendar2 = new GregorianCalendar();
		calendar2.add(Calendar.DATE,+7);
		calendar2.getTime();
		SimpleDateFormat formatarDate2 = new SimpleDateFormat("dd/MM/yyyy");
		txtDataDevolucao.setText(formatarDate2.format(calendar2.getTime()));
		panel_4.add(txtDataDevolucao);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				txtNumeroFilme.setText("");
				txtTotal.setText("");
				
				tbLocacoes = new JTable();
				
				dados = new ArrayList();
				

				//dados.add(new Object[]{"","",cbTitulo.getSelectedItem()});
				

				
				dtm = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo Titulo", "Nome do Filme"
						}
					);
					
				
				tbLocacoes.setModel(dtm);

				tbLocacoes.getColumnModel().getColumn(0).setPreferredWidth(94);
				tbLocacoes.getColumnModel().getColumn(1).setPreferredWidth(107);

				
				scrollPane.setViewportView(tbLocacoes);
				
				
			}
		});
		btnCancelar.setBounds(146, 173, 124, 28);
		panel_4.add(btnCancelar);
		
		txtNumeroFilme = new JTextField();
		txtNumeroFilme.setEnabled(false);
		txtNumeroFilme.setColumns(10);
		txtNumeroFilme.setBounds(146, 23, 124, 28);
		panel_4.add(txtNumeroFilme);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setBounds(146, 101, 124, 28);
		panel_4.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnConcluir = new JButton("Concluir");
	
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				loc.setFuncionario(Integer.parseInt(txtFuncionario.getText()));
			
				
				try {
					loc.setCliente(codigoReverso(cbCliente.getSelectedItem().toString()));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				loc.setDataAtual(txtDataAtual.getText());
				//loc.setNumeroFilme(Integer.parseInt(txtNumeroFilme.getText()));
				loc.setNumeroFilme(Integer.parseInt(txtNumeroFilme.getText()));
				loc.setDataDevolucao(txtDataDevolucao.getText());
				//loc.setTotal(Double.parseDouble(txtTotal.getText()));
				loc.setTotal(Double.parseDouble(txtTotal.getText()));
				loc.setEstado("Pendente");
				lod.cadastrarLocacao(loc);
				
				for(int linha=0; linha<tbLocacoes.getRowCount();linha++){
					floc.setCodigo_locacao(pegalocacao());
					floc.setCodigo_titulo(Integer.parseInt((String) tbLocacoes.getValueAt(linha,0)));
					flod.cadastrarFilmeLocacao(floc);
					
				}
				
				
				txtNumeroFilme.setText("");
				txtTotal.setText("");
				
				tbLocacoes = new JTable();
				
				dados = new ArrayList();
				

				//dados.add(new Object[]{"","",cbTitulo.getSelectedItem()});
				

				
				dtm = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo Titulo", "Nome do Filme"
						}
					);
					
				
				tbLocacoes.setModel(dtm);

				tbLocacoes.getColumnModel().getColumn(0).setPreferredWidth(94);
				tbLocacoes.getColumnModel().getColumn(1).setPreferredWidth(107);

				
				scrollPane.setViewportView(tbLocacoes);
				
				
			}
		});
		btnConcluir.setBounds(6, 173, 124, 28);
		panel_4.add(btnConcluir);

		preencheComboBox();
		
	}
	
	

	
	public void atualizaCampos() throws NumberFormatException, SQLException
	{
		txtNumeroFilme.setText(Integer.toString(tbLocacoes.getRowCount()));
		valor = 0;

			Persistencia conexao = new Persistencia();
		
			conexao.conexao();
			conexao.execultaSql("select valor,codigo from tbl_titulos where nome = '"+cbTitulo.getSelectedItem()+"'");
			
			for(int linha=0; linha<tbLocacoes.getRowCount();linha++){
			
				
					conexao.execultaSql("select valor,codigo from tbl_titulos where codigo = '"+tbLocacoes.getValueAt(linha,0)+"'");
					try {
						conexao.rs.first();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						valor = valor + Double.parseDouble(conexao.rs.getString("valor"));
						//txtTotal.setText(Double.toString(conexao.rs.getDouble("valor")));
					

			}
			conexao.desconecta();
			txtTotal.setText(Double.toString(valor));
			
		
	}
	
	public int pegalocacao()
	{
		Persistencia conexao = new Persistencia();
		
		conexao.conexao();
		
		conexao.execultaSql("select MAX(codigo) as cod from tbl_locacao");
		try 
		{
			conexao.rs.first();
		
			
			do
			{
				
				codigo = conexao.rs.getInt("cod");
				
			}
			while(conexao.rs.next());

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return codigo;
	}
	
	public void preencheComboBox()
	{
		Persistencia conexao = new Persistencia();
		
		conexao.conexao();
		
		conexao.execultaSql("select * from tbl_titulos");
		try 
		{
			conexao.rs.first();
			cbTitulo.removeAllItems();
			
			do
			{
				cbTitulo.addItem(conexao.rs.getString("nome"));
				
			}
			while(conexao.rs.next());

		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		
		conexao.execultaSql("select * from tbl_clientes");
		try 
		{
			conexao.rs.first();
			cbCliente.removeAllItems();
			
			do
			{
				cbCliente.addItem(conexao.rs.getString("nome"));
				
			}
			while(conexao.rs.next());

		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		conexao.desconecta();
	}

	public int codigoReverso(String nome) throws SQLException
	{
		Persistencia conexao = new Persistencia();
		int codigo;
		

			conexao.conexao();
			conexao.execultaSql("select codigo from tbl_clientes where nome = '"+nome+"'");
			conexao.rs.first();
			codigo = Integer.parseInt(conexao.rs.getString("codigo"));
			
			conexao.desconecta();

		return codigo;
		
	}
	
	
	public int tituloReverso(String nome) throws SQLException
	{
		Persistencia conexao = new Persistencia();
		int codigo;
		

			conexao.conexao();
			conexao.execultaSql("select codigo from tbl_titulos where nome = '"+nome+"'");
			conexao.rs.first();
			codigo = Integer.parseInt(conexao.rs.getString("codigo"));
			
			conexao.desconecta();

		return codigo;
		
	}
	
	public void ajusta(boolean a)
	{
		if(a)
		{
			txtDataAtual.setEnabled(false);
			tbLocacoes.setEnabled(false);
			txtDataDevolucao.setEnabled(false);
			txtNumeroFilme.setEnabled(false);
			txtTotal.setEnabled(false);
			cbCliente.setEnabled(false);
			cbTitulo.setEnabled(false);
			btnConcluir.setEnabled(false);
			txtFuncionario.setEnabled(false);
			
			
		}
		else
		{
		
		}
		
	}
	
	
}
