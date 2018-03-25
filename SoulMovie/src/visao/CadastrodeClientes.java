package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import persistencia.Persistencia;
import dao.DaoClientes;
import beans.BeansCliente;
import beans.BeansTabela;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import outros.ManipularImagem;

import javax.swing.JFormattedTextField;

public class CadastrodeClientes extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTable tbHistorico;
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JButton btnAtualizarImg;
	private JButton btnPrimeiro;
	private JButton btnVoltar;
	private JButton btnAvancar;
	private JButton btnUltimo;
	private JLabel lblImagem;
	private JFormattedTextField txtCPF;
	private JButton btnAtualizar;
	private BufferedImage imagem;
	private JTable tbClientes;
	private JFormattedTextField txtDatanascimento;
	private JFormattedTextField txtTelefone;
	private int botao;

	BeansCliente cli = new BeansCliente();
	BeansCliente cliImg = new BeansCliente();
	DaoClientes clid = new DaoClientes();
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtCep;
	
	
	

	public CadastrodeClientes() {
		
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
		setBounds(100, 100, 600, 595);
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setForeground(new Color(51, 102, 255));
		lblCadastroDeClientes.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 27));
		lblCadastroDeClientes.setBackground(Color.WHITE);
		lblCadastroDeClientes.setBounds(163, 0, 273, 28);
		getContentPane().add(lblCadastroDeClientes);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(6, 40, 573, 68);
		getContentPane().add(panel);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botao = 1;
				txtCodigo.setText("Automatico");
				txtNome.setText("");
				txtDatanascimento.setText("");
				txtCPF.setText("");
				txtTelefone.setText("");
				txtCelular.setText("");
				txtEmail.setText("");
				txtBairro.setText("");
				txtRua.setText("");
				txtCidade.setText("");
				txtCep.setText("");
				txtNumero.setText("");
				ajusta(false);
				
			}
		});
		btnNovo.setBounds(8, 16, 105, 35);
		panel.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botao = 2;
				ajusta(false);
				preencherTabela("select * from tbl_clientes");
				
			}
		});
		btnAlterar.setBounds(120, 16, 105, 35);
		panel.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja Excluir?","Excluir Cliente",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					
					
					cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
					clid.ExcluirCliente(cli);
					txtCodigo.setText("");
					txtNome.setText("");
					txtDatanascimento.setText("");
					txtCPF.setText("");
					txtTelefone.setText("");
					txtCelular.setText("");
					txtEmail.setText("");
					txtBairro.setText("");
					txtRua.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
					
				}
				preencherTabela("select * from tbl_clientes");
			}
		});
		btnExcluir.setBounds(228, 16, 105, 35);
		panel.add(btnExcluir);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajusta(true);
				
				if(botao == 1)
				{
					cli.setNome(txtNome.getText());
					cli.setCpf(txtCPF.getText());
					cli.setNascimento(txtDatanascimento.getText());
					cli.setTelefone(txtTelefone.getText());
					cli.setCelular(txtCelular.getText());
					cli.setEmail(txtEmail.getText());
					cli.setBairro(txtBairro.getText());
					cli.setRua(txtRua.getText());
					cli.setCidade(txtCidade.getText());
					cli.setCep(txtCep.getText());
					cli.setNumero(txtNumero.getText());
					cli.setImagen(ManipularImagem.getImgBytes(imagem));
					clid.CadastrarCliente(cli);
					
					txtCodigo.setText("");
					txtNome.setText("");
					txtDatanascimento.setText("");
					txtCPF.setText("");
					txtTelefone.setText("");
					txtCelular.setText("");
					txtEmail.setText("");
					txtBairro.setText("");
					txtRua.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
				}
				else
				{
					cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
					cli.setNome(txtNome.getText());
					cli.setCpf(txtCPF.getText());
					cli.setNascimento(txtDatanascimento.getText());
					cli.setTelefone(txtTelefone.getText());
					cli.setCelular(txtCelular.getText());
					cli.setEmail(txtEmail.getText());
					cli.setBairro(txtBairro.getText());
					cli.setRua(txtRua.getText());
					cli.setCidade(txtCidade.getText());
					cli.setCep(txtCep.getText());
					cli.setNumero(txtNumero.getText());
					clid.AlterarCliente(cli);
					
					txtCodigo.setText("");
					txtNome.setText("");
					txtDatanascimento.setText("");
					txtCPF.setText("");
					txtTelefone.setText("");
					txtCelular.setText("");
					txtEmail.setText("");
					txtBairro.setText("");
					txtRua.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
				}
				preencherTabela("select * from tbl_clientes");
				
			}
		});
		btnConfirmar.setBounds(340, 16, 105, 35);
		btnConfirmar.setEnabled(false);
		panel.add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajusta(true);
				txtCodigo.setText("");
				txtNome.setText("");
				txtDatanascimento.setText("");
				txtCPF.setText("");
				txtTelefone.setText("");
				txtCelular.setText("");
				txtEmail.setText("");
				txtBairro.setText("");
				txtRua.setText("");
				txtCidade.setText("");
				txtCep.setText("");
				txtNumero.setText("");
				preencherTabela("select * from tbl_clientes");
			}
		});
		btnCancelar.setBounds(451, 15, 105, 35);
		panel.add(btnCancelar);
		
		JTabbedPane tpCampos = new JTabbedPane(JTabbedPane.TOP);
		tpCampos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tpCampos.setBounds(6, 118, 576, 192);
		getContentPane().add(tpCampos);
		
		JPanel pnCadastro = new JPanel();
		pnCadastro.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tpCampos.addTab("Cadastro", null, pnCadastro, null);
		pnCadastro.setLayout(null);
		
		JPanel pnCampos = new JPanel();
		pnCampos.setLayout(null);
		pnCampos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnCampos.setBounds(6, 6, 392, 148);
		pnCadastro.add(pnCampos);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCodigo.setBounds(19, 13, 72, 16);
		pnCampos.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNome.setBounds(19, 47, 72, 16);
		pnCampos.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCpf.setBounds(19, 84, 95, 16);
		pnCampos.add(lblCpf);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(205, 6, 181, 28);
		txtCodigo.setEnabled(false);
		pnCampos.add(txtCodigo);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(205, 43, 181, 28);
		txtNome.setEnabled(false);
		pnCampos.add(txtNome);
		
		JLabel lblDatanacimento = new JLabel("Data-Nascimento:");
		lblDatanacimento.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblDatanacimento.setBounds(19, 119, 130, 16);
		pnCampos.add(lblDatanacimento);
		
		txtCPF = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCPF.setEnabled(false);
		txtCPF.setBounds(205, 78, 181, 28);
		pnCampos.add(txtCPF);
		
		txtDatanascimento = new JFormattedTextField(Mascara("##/##/####"));
		txtDatanascimento.setEnabled(false);
		txtDatanascimento.setBounds(205, 113, 181, 28);
		pnCampos.add(txtDatanascimento);
		
		JPanel pnImagem = new JPanel();
		pnImagem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnImagem.setBounds(407, 6, 161, 115);
		pnCadastro.add(pnImagem);
		pnImagem.setLayout(null);
		
		lblImagem = new JLabel("");
		lblImagem.setBounds(4, 3, 154, 107);
		pnImagem.add(lblImagem);
		
		btnAtualizarImg = new JButton("Alterar");
		btnAtualizarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
		        int res = fc.showOpenDialog(null);

		        if (res == JFileChooser.APPROVE_OPTION) {
		            File arquivo = fc.getSelectedFile();

		            try {
		                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 154, 107);

		                lblImagem.setIcon(new ImageIcon(imagem));

		            } catch (Exception ex) {
		               // System.out.println(ex.printStackTrace().toString());
		            }

		        } else {
		            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
		        }
			}
		});
		btnAtualizarImg.setBounds(442, 126, 90, 28);
		btnAtualizarImg.setEnabled(false);
		pnCadastro.add(btnAtualizarImg);
		
		JPanel pnHistorico = new JPanel();
		tpCampos.addTab("Historico", null, pnHistorico, null);
		pnHistorico.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 562, 148);
		pnHistorico.add(scrollPane);
		
		tbHistorico = new JTable();
		tbHistorico.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Titulo", "Data"
			}
		));
		scrollPane.setViewportView(tbHistorico);
		
		JTabbedPane tpDados = new JTabbedPane(JTabbedPane.TOP);
		tpDados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tpDados.setBounds(6, 324, 576, 147);
		getContentPane().add(tpDados);
		
		JPanel pnContato = new JPanel();
		pnContato.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tpDados.addTab("Contato", null, pnContato, null);
		pnContato.setLayout(null);
		
		JLabel lblTelefoneContato = new JLabel("Telefone:");
		lblTelefoneContato.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblTelefoneContato.setBounds(6, 17, 102, 24);
		pnContato.add(lblTelefoneContato);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblCelular.setBounds(197, 17, 123, 24);
		pnContato.add(lblCelular);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblEmail.setBounds(386, 17, 111, 24);
		pnContato.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(386, 53, 181, 43);
		txtEmail.setEnabled(false);
		pnContato.add(txtEmail);
		
		txtTelefone = new JFormattedTextField(Mascara("(##)####-####"));
		txtTelefone.setEnabled(false);
		txtTelefone.setBounds(16, 53, 152, 43);
		pnContato.add(txtTelefone);
		
		txtCelular = new JFormattedTextField(Mascara("(##)#####-####"));
		txtCelular.setEnabled(false);
		txtCelular.setBounds(180, 53, 181, 42);
		pnContato.add(txtCelular);
		
		JPanel pnEndereco = new JPanel();
		pnEndereco.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tpDados.addTab("Endereco", null, pnEndereco, null);
		pnEndereco.setLayout(null);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblBairro.setBounds(6, 6, 102, 24);
		pnEndereco.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(6, 42, 107, 43);
		txtBairro.setEnabled(false);
		pnEndereco.add(txtBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblRua.setBounds(120, 6, 60, 24);
		pnEndereco.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(120, 42, 135, 43);
		txtRua.setEnabled(false);
		pnEndereco.add(txtRua);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblCidade.setBounds(267, 6, 78, 24);
		pnEndereco.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(267, 42, 115, 43);
		txtCidade.setEnabled(false);
		pnEndereco.add(txtCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblCep.setBounds(387, 6, 54, 24);
		pnEndereco.add(lblCep);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(477, 42, 60, 43);
		txtNumero.setEnabled(false);
		pnEndereco.add(txtNumero);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblNumero.setBounds(477, 6, 78, 24);
		pnEndereco.add(lblNumero);
		
		txtCep = new JFormattedTextField(Mascara("#####-###"));
		txtCep.setEnabled(false);
		txtCep.setBounds(387, 42, 78, 40);
		pnEndereco.add(txtCep);
		
		JPanel pnCrud = new JPanel();
		pnCrud.setLayout(null);
		pnCrud.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		pnCrud.setBounds(5, 483, 574, 59);
		getContentPane().add(pnCrud);
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbClientes.setRowSelectionInterval(0,0);
				crud();
				
			}
		});
		btnPrimeiro.setBounds(18, 14, 102, 28);
		pnCrud.add(btnPrimeiro);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbClientes.setRowSelectionInterval(tbClientes.getSelectedRow()-1, tbClientes.getSelectedRow()-1);
				crud();
				
			}
		});
		btnVoltar.setBounds(125, 14, 102, 28);
		pnCrud.add(btnVoltar);
		
		btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbClientes.setRowSelectionInterval(tbClientes.getSelectedRow()+1, tbClientes.getSelectedRow()+1);
				crud();
				
				
			}
		});
		btnAvancar.setBounds(235, 14, 102, 28);
		pnCrud.add(btnAvancar);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbClientes.setRowSelectionInterval(tbClientes.getRowCount()-1, tbClientes.getRowCount()-1);
				crud();
				
			}
		});
		btnUltimo.setBounds(342, 14, 102, 28);
		pnCrud.add(btnUltimo);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preencherTabela("select * from tbl_clientes");
				
			}


		});
		btnAtualizar.setBounds(448, 14, 102, 28);
		pnCrud.add(btnAtualizar);
		
		tbClientes = new JTable();
		tbClientes.setEnabled(false);
		tbClientes.setBounds(15, 554, 0, 0);
		getContentPane().add(tbClientes);
		
		
		preencherTabela("select * from tbl_clientes");

	}
	
	public void preencherTabela(String Sql)
	{
		
		Persistencia conexao = new Persistencia();
		
		ArrayList dados = new ArrayList();
		String[] colunas = new String[]{"Codigo","Nome","Cpf","Data de Nascimento","telefone","celular","email","bairro","rua","cidade","cep","numero","imagen"};
		
		conexao.conexao();
		
		conexao.execultaSql(Sql);
		
		try
		{
			conexao.rs.first();
			do
			{
				dados.add(new Object[]{conexao.rs.getInt("codigo"),conexao.rs.getString("nome"),conexao.rs.getString("cpf"),conexao.rs.getString("nascimento"),conexao.rs.getString("telefone"),conexao.rs.getString("celular"),conexao.rs.getString("email"),conexao.rs.getString("bairro"),conexao.rs.getString("rua"),conexao.rs.getString("cidade"),conexao.rs.getString("cep"),conexao.rs.getString("numero"),conexao.rs.getString("imagen")});                                              
			}while(conexao.rs.next());
	
		}
		catch(SQLException erro)
		{
			
		}
		BeansTabela modelo = new BeansTabela(dados,colunas);
		tbClientes.setModel(modelo);
	
		
		
		conexao.desconecta();
		
	}
	
	public void crud()
	{
		int codigo = (int) tbClientes.getValueAt(tbClientes.getSelectedRow(),0);
		txtCodigo.setText(Integer.toString(codigo));
		txtNome.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),1));
		txtCPF.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),2));
		txtDatanascimento.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),3));
		txtTelefone.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),4));
		txtCelular.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),5));
		txtEmail.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),6));
		txtBairro.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),7));
		txtRua.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),8));
		txtCidade.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),9));
		txtCep.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),10));
		txtNumero.setText((String) tbClientes.getValueAt(tbClientes.getSelectedRow(),11));
		cliImg = clid.buscar(codigo);
		ManipularImagem.exibiImagemLabel(cliImg.getImagen(), lblImagem);
		
	}
	
	public MaskFormatter Mascara(String Mascara){
	        MaskFormatter F_Mascara = new MaskFormatter();
	        try{
	            F_Mascara.setMask(Mascara); //Atribui a mascara
	            F_Mascara.setPlaceholderCharacter('_'); //Caracter para preencimento 
	        }
	        catch (Exception excecao) {
	        excecao.printStackTrace();
	        } 
	        return F_Mascara;
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
			tbClientes.setEnabled(true);
			
			btnConfirmar.setEnabled(false);
			btnCancelar.setEnabled(false);
			txtCodigo.setEnabled(false);
			txtNome.setEnabled(false);
			btnAtualizarImg.setEnabled(false);
			txtNome.setEnabled(false);
			txtCPF.setEnabled(false);
			txtDatanascimento.setEnabled(false);
			txtTelefone.setEnabled(false);
			txtCelular.setEnabled(false);
			txtEmail.setEnabled(false);
			txtBairro.setEnabled(false);
			txtRua.setEnabled(false);
			txtCidade.setEnabled(false);
			txtCep.setEnabled(false);
			txtNumero.setEnabled(false);
			
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
			tbClientes.setEnabled(false);
		
			btnConfirmar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnAtualizarImg.setEnabled(true);
			txtNome.setEnabled(true);
			txtCPF.setEnabled(true);
			txtDatanascimento.setEnabled(true);
			txtTelefone.setEnabled(true);
			txtCelular.setEnabled(true);
			txtEmail.setEnabled(true);
			txtBairro.setEnabled(true);
			txtRua.setEnabled(true);
			txtCidade.setEnabled(true);
			txtCep.setEnabled(true);
			txtNumero.setEnabled(true);
			
			
			
		}
	}
}
