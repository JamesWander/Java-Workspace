package visao;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.Persistencia;
import dao.DaoCategoria;
import beans.BeansCategoria;
import beans.BeansTabela;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class CadastrodeCategorias extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTable tbCategorias;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	private JButton btnPrimeiro;
	private JButton btnVoltar;
	private JButton btnAvancar;
	private JButton btnUltimo;
	private JButton btnAtualizar;
	private DefaultTableModel dtm;
	private int botao;

	
	
	BeansCategoria cat = new BeansCategoria();
	DaoCategoria cad = new DaoCategoria();
	Persistencia conexao = new Persistencia();


	public CadastrodeCategorias() {
		
			
		
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
		
		
		
		setTitle("Cadastro de Categorias");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 588, 495);
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeCategorias = new JLabel("Cadastro de Categorias");
		lblCadastroDeCategorias.setForeground(new Color(51, 102, 255));
		lblCadastroDeCategorias.setBackground(Color.WHITE);
		lblCadastroDeCategorias.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 31));
		lblCadastroDeCategorias.setBounds(107, 6, 366, 33);
		getContentPane().add(lblCadastroDeCategorias);
		
		JPanel pnBotoes = new JPanel();
		pnBotoes.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		pnBotoes.setBounds(6, 48, 564, 68);
		getContentPane().add(pnBotoes);
		pnBotoes.setLayout(null);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botao = 1;
				txtCodigo.setText("Automatico");
				txtNome.setText("");
				ajusta(false);
			}
		});
		btnNovo.setBounds(8, 16, 105, 35);
		pnBotoes.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botao = 2;
				ajusta(false);
				
			}
		});
		btnAlterar.setBounds(120, 16, 105, 35);
		pnBotoes.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja Excluir?","ExcluirCategoria",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					
					cat.setNome(txtNome.getText());
					cat.setCodigo(Integer.parseInt(txtCodigo.getText()));
					cad.excluirCategoria(cat);
					txtCodigo.setText("");
					txtNome.setText("");
					
				}
			}
		});
		btnExcluir.setBounds(228, 16, 105, 35);
		pnBotoes.add(btnExcluir);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajusta(true);
				
				if(botao == 1)
				{
				cat.setNome(txtNome.getText());
				cad.cadastrarCategoria(cat);
				txtCodigo.setText("");
				txtNome.setText("");
				}
				else
				{
					cat.setNome(txtNome.getText());
					cat.setCodigo(Integer.parseInt(txtCodigo.getText()));
					cad.alterarCategoria(cat);
					txtCodigo.setText("");
					txtNome.setText("");
				}
				preencherTabela("select * from tbl_categoria");	
			}
		});
		btnConfirmar.setBounds(340, 16, 105, 35);
		btnConfirmar.setEnabled(false);
		pnBotoes.add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajusta(true);
				txtCodigo.setText("");
				txtNome.setText("");
				preencherTabela("select * from tbl_categoria");
				
			}
		});
		btnCancelar.setBounds(451, 15, 105, 35);
		btnCancelar.setEnabled(false);
		pnBotoes.add(btnCancelar);
		
		JPanel pnCampos = new JPanel();
		pnCampos.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCampos.setBounds(6, 128, 564, 86);
		getContentPane().add(pnCampos);
		pnCampos.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblCodigo.setBounds(19, 13, 72, 16);
		pnCampos.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblNome.setBounds(19, 47, 72, 16);
		pnCampos.add(lblNome);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(158, 7, 358, 28);
		txtCodigo.setEnabled(false);
		pnCampos.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(158, 44, 358, 28);
		txtNome.setEnabled(false);
		pnCampos.add(txtNome);
		
		JPanel pnTable = new JPanel();
		pnTable.setBorder(new TitledBorder(null, "", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
		pnTable.setBounds(6, 225, 565, 165);
		getContentPane().add(pnTable);
		pnTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 3, 558, 162);
		pnTable.add(scrollPane);
		
		tbCategorias = new JTable();
		tbCategorias.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				
				if(tbCategorias.isEnabled())
				{
					crud();
				}
			
			}
		});
	
		//tbCategorias.setModel(dtm);
		
		
		
		scrollPane.setViewportView(tbCategorias);
		
		JPanel pnCrud = new JPanel();
		pnCrud.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		pnCrud.setBounds(4, 401, 567, 59);
		getContentPane().add(pnCrud);
		pnCrud.setLayout(null);
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbCategorias.setRowSelectionInterval(0,0);
				crud();
				
			}
		});
		btnPrimeiro.setBounds(18, 14, 102, 28);
		pnCrud.add(btnPrimeiro);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbCategorias.setRowSelectionInterval(tbCategorias.getSelectedRow()-1, tbCategorias.getSelectedRow()-1);
				crud();
				
			}
		});
		btnVoltar.setBounds(125, 14, 102, 28);
		pnCrud.add(btnVoltar);
		
		btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbCategorias.setRowSelectionInterval(tbCategorias.getSelectedRow()+1, tbCategorias.getSelectedRow()+1);
				crud();
			}
			
		});
		btnAvancar.setBounds(235, 14, 102, 28);
		pnCrud.add(btnAvancar);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbCategorias.setRowSelectionInterval(tbCategorias.getRowCount()-1, tbCategorias.getRowCount()-1);
				crud();
			}
		});
		btnUltimo.setBounds(342, 14, 102, 28);
		pnCrud.add(btnUltimo);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				preencherTabela("select * from tbl_categoria");
			}
		});
		
		
		btnAtualizar.setBounds(448, 14, 102, 28);
		pnCrud.add(btnAtualizar);
		preencherTabela("select * from tbl_categoria");

	}
	
	public void crud()
	{
		int codigo = (int) tbCategorias.getValueAt(tbCategorias.getSelectedRow(),0);
		txtCodigo.setText(Integer.toString(codigo));
		txtNome.setText((String) tbCategorias.getValueAt(tbCategorias.getSelectedRow(),1));
	}
	
	public void preencherTabela(String Sql)
	{
		ArrayList dados = new ArrayList();
		String[] colunas = new String[]{"Codigo","Nome"};
		
		conexao.conexao();
		
		conexao.execultaSql(Sql);
		
		try
		{
			conexao.rs.first();
			do
			{
				dados.add(new Object[]{conexao.rs.getInt("codigo"),conexao.rs.getString("nome")});
			}while(conexao.rs.next());
	
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(rootPane,"");
		}
		BeansTabela modelo = new BeansTabela(dados,colunas);
		tbCategorias.setModel(modelo);
		
		tbCategorias.getColumnModel().getColumn(0).setMinWidth(0);
		tbCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
		tbCategorias.getColumnModel().getColumn(0).setWidth(0);
		
		
		conexao.desconecta();
		
	}
	
	
	
	private void ajusta(boolean a)
	{
		if(a)
		{
			btnAlterar.setEnabled(true);
			btnExcluir.setEnabled(true);
			btnNovo.setEnabled(true);
			btnPrimeiro.setEnabled(true);
			btnVoltar.setEnabled(true);
			btnAvancar.setEnabled(true);
			btnUltimo.setEnabled(true);
			btnAtualizar.setEnabled(true);
			tbCategorias.setEnabled(true);
			
			btnConfirmar.setEnabled(false);
			btnCancelar.setEnabled(false);
			txtCodigo.setEnabled(false);
			txtNome.setEnabled(false);
		}
		else
		{
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnNovo.setEnabled(false);
			txtCodigo.setEnabled(false);
			btnPrimeiro.setEnabled(false);
			btnVoltar.setEnabled(false);
			btnAvancar.setEnabled(false);
			btnUltimo.setEnabled(false);
			btnAtualizar.setEnabled(false);
			tbCategorias.setEnabled(false);
			
			
			txtNome.setEnabled(true);
			btnConfirmar.setEnabled(true);
			btnCancelar.setEnabled(true);
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
