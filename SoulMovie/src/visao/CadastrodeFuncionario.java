package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;

import persistencia.Persistencia;
import dao.DaoFuncionarios;
import outros.ManipularImagem;
import beans.BeansFuncionario;
import beans.BeansTabela;

import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;

public class CadastrodeFuncionario extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSalario;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtNumero;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
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
	private JButton btnAtualizar;
	private JComboBox cbTipoLogin;
	private JRadioButton rbMasculino;
	private JLabel lblImagem;
	private JRadioButton rbFeminino;
	private JTable tbFuncionario;
	private BufferedImage imagem;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int botao;
	
	BeansFuncionario fun = new BeansFuncionario();
	BeansFuncionario funImg = new BeansFuncionario();
	DaoFuncionarios func = new DaoFuncionarios();
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtNasc;
	private JFormattedTextField txtCep;


	public CadastrodeFuncionario() {
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
		//-------------Fim --------------//
	
		
		setBounds(100, 100, 588, 582);
		getContentPane().setLayout(null);
		
		JPanel pnBotoes = new JPanel();
		pnBotoes.setLayout(null);
		pnBotoes.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnBotoes.setBounds(0, 46, 573, 68);
		getContentPane().add(pnBotoes);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botao = 1;
				txtCodigo.setText("Automatico");
				txtNome.setText("");
				txtCpf.setText("");;
				txtNasc.setText("");
				txtCargo.setText("");
				txtSalario.setText("");
				txtBairro.setText("");
				txtUf.setText("");
				txtCidade.setText("");
				txtCep.setText("");
				txtNumero.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
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
				preencherTabela("Select * from tbl_funcionarios");
				
			}
		});
		btnAlterar.setBounds(120, 16, 105, 35);
		pnBotoes.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja Excluir?","Excluir Cliente",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					fun.setCodigo(Integer.parseInt(txtCodigo.getText()));
					func.ExcluirFuncionario(fun);
				}
				preencherTabela("Select * from tbl_funcionarios");
			}
		});
		btnExcluir.setBounds(228, 16, 105, 35);
		pnBotoes.add(btnExcluir);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajusta(true);
				
				if(botao == 1)
				{
					fun.setNome(txtNome.getText());
					fun.setCpf(txtCpf.getText());
					fun.setNascimento(txtNasc.getText());
					fun.setCargo(txtCargo.getText());
					fun.setSalario(Double.parseDouble(txtSalario.getText()));
					if(rbMasculino.isSelected()){fun.setSexo("M");}else{fun.setSexo("F");}
					fun.setBairro(txtBairro.getText());
					fun.setCidade(txtCidade.getText());
					fun.setCep(txtCep.getText());
					fun.setUf(txtUf.getText());
					fun.setNumero(txtNumero.getText());
					fun.setLogin(txtLogin.getText());
					fun.setSenha(txtSenha.getText());
					fun.setTipo(cbTipoLogin.getSelectedItem().toString());
					fun.setImagen(ManipularImagem.getImgBytes(imagem));
					func.CadastrarFuncionario(fun);
					
					txtCodigo.setText("");
					txtNome.setText("");
					txtCpf.setText("");;
					txtNasc.setText("");
					txtCargo.setText("");
					txtSalario.setText("");
					txtBairro.setText("");
					txtUf.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
					txtLogin.setText("");
					txtSenha.setText("");
					
				}
				else
				{
					fun.setCodigo(Integer.parseInt(txtCodigo.getText()));
					fun.setNome(txtNome.getText());
					fun.setCpf(txtCpf.getText());
					fun.setNascimento(txtNasc.getText());
					fun.setCargo(txtCargo.getText());
					fun.setSalario(Double.parseDouble(txtSalario.getText()));
					if(rbMasculino.isSelected()){fun.setSexo("M");}else{fun.setSexo("F");}
					fun.setBairro(txtBairro.getText());
					fun.setCidade(txtCidade.getText());
					fun.setCep(txtCep.getText());
					fun.setUf(txtUf.getText());
					fun.setNumero(txtNumero.getText());
					fun.setLogin(txtLogin.getText());
					fun.setSenha(txtNumero.getText());
					fun.setTipo(cbTipoLogin.getSelectedItem().toString());
					func.AlterarFuncionario(fun);
					
					txtCodigo.setText("");
					txtNome.setText("");
					txtCpf.setText("");;
					txtNasc.setText("");
					txtCargo.setText("");
					txtSalario.setText("");
					txtBairro.setText("");
					txtUf.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
				
					

				}
				
				preencherTabela("Select * from tbl_funcionarios");
			}
		});
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(340, 16, 105, 35);
		pnBotoes.add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajusta(true);
				preencherTabela("Select * from tbl_funcionarios");
				
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(451, 15, 105, 35);
		pnBotoes.add(btnCancelar);
		
		JLabel lblCadastroDeFuncionario = new JLabel("Cadastro de Funcionario");
		lblCadastroDeFuncionario.setForeground(new Color(51, 102, 255));
		lblCadastroDeFuncionario.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 27));
		lblCadastroDeFuncionario.setBackground(Color.WHITE);
		lblCadastroDeFuncionario.setBounds(116, 7, 339, 28);
		getContentPane().add(lblCadastroDeFuncionario);
		
		JTabbedPane tpFuncionario = new JTabbedPane(JTabbedPane.TOP);
		tpFuncionario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tpFuncionario.setBounds(0, 124, 570, 186);
		getContentPane().add(tpFuncionario);
		
		JPanel pnCadastro = new JPanel();
		pnCadastro.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnCadastro.setToolTipText("");
		tpFuncionario.addTab("Cadastro", null, pnCadastro, null);
		pnCadastro.setLayout(null);
		
		JPanel pnImg = new JPanel();
		pnImg.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnImg.setBounds(401, 0, 161, 118);
		pnCadastro.add(pnImg);
		pnImg.setLayout(null);
		
		lblImagem = new JLabel("");
		lblImagem.setBounds(6, 6, 154, 106);
		pnImg.add(lblImagem);
		
		JPanel pnCampos = new JPanel();
		pnCampos.setLayout(null);
		pnCampos.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnCampos.setBounds(0, 0, 392, 148);
		pnCadastro.add(pnCampos);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCodigo.setBounds(19, 13, 46, 16);
		pnCampos.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNome.setBounds(19, 47, 48, 16);
		pnCampos.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCpf.setBounds(19, 84, 46, 16);
		pnCampos.add(lblCpf);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(77, 7, 162, 28);
		pnCampos.add(txtCodigo);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(77, 41, 162, 28);
		pnCampos.add(txtNome);
		
		JLabel lblNasc = new JLabel("Data-Nacimento:");
		lblNasc.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNasc.setBounds(19, 119, 104, 16);
		pnCampos.add(lblNasc);
		
		
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCargo.setBounds(251, 13, 48, 16);
		pnCampos.add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setEnabled(false);
		txtCargo.setColumns(10);
		txtCargo.setBounds(296, 7, 90, 28);
		pnCampos.add(txtCargo);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblSalario.setBounds(251, 53, 48, 16);
		pnCampos.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setEnabled(false);
		txtSalario.setColumns(10);
		txtSalario.setBounds(296, 47, 90, 28);
		pnCampos.add(txtSalario);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblSexo.setBounds(251, 106, 48, 16);
		pnCampos.add(lblSexo);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setEnabled(false);
		buttonGroup.add(rbMasculino);
		rbMasculino.setBounds(296, 89, 90, 18);
		pnCampos.add(rbMasculino);

		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setEnabled(false);
		buttonGroup.add(rbFeminino);
		rbFeminino.setBounds(296, 118, 90, 18);
		pnCampos.add(rbFeminino);
		
		txtCpf = new JFormattedTextField(Mascara("###.###.###-##"));
		txtCpf.setEnabled(false);
		txtCpf.setBounds(77, 78, 162, 28);
		pnCampos.add(txtCpf);
		
		txtNasc = new JFormattedTextField(Mascara("##/##/####"));
		txtNasc.setEnabled(false);
		txtNasc.setBounds(135, 113, 104, 22);
		pnCampos.add(txtNasc);
		
		
		
		btnAtualizarImg = new JButton("Alterar");
		btnAtualizarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fc = new JFileChooser();
			        int res = fc.showOpenDialog(null);

			        if (res == JFileChooser.APPROVE_OPTION) {
			            File arquivo = fc.getSelectedFile();

			            try {
			                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);

			                lblImagem.setIcon(new ImageIcon(imagem));

			            } catch (Exception ex) {
			               // System.out.println(ex.printStackTrace().toString());
			            }

			        } else {
			            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
			        }
			        preencherTabela("Select * from tbl_funcionarios");
			}
		});
		btnAtualizarImg.setEnabled(false);
		btnAtualizarImg.setBounds(434, 120, 90, 28);
		pnCadastro.add(btnAtualizarImg);
		
		JPanel pnEndereco = new JPanel();
		pnEndereco.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tpFuncionario.addTab("Endereço", null, pnEndereco, null);
		pnEndereco.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_6.setBounds(6, 6, 556, 148);
		pnEndereco.add(panel_6);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblBairro.setBounds(19, 13, 46, 16);
		panel_6.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCidade.setBounds(19, 47, 48, 16);
		panel_6.add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCep.setBounds(19, 84, 46, 16);
		panel_6.add(lblCep);
		
		txtBairro = new JTextField();
		txtBairro.setEnabled(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(77, 7, 249, 28);
		panel_6.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(77, 41, 249, 28);
		panel_6.add(txtCidade);
		
		JLabel lblUf = new JLabel("Uf:");
		lblUf.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblUf.setBounds(19, 119, 104, 16);
		panel_6.add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setEnabled(false);
		txtUf.setColumns(10);
		txtUf.setBounds(77, 113, 249, 28);
		panel_6.add(txtUf);
		
		JLabel lblNumero = new JLabel("N\u00BA:");
		lblNumero.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNumero.setBounds(381, 13, 48, 16);
		panel_6.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(426, 7, 90, 28);
		panel_6.add(txtNumero);
		
		txtCep = new JFormattedTextField(Mascara("#####-###"));
		txtCep.setEnabled(false);
		txtCep.setBounds(77, 78, 249, 28);
		panel_6.add(txtCep);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		tpFuncionario.addTab("Login", null, pnLogin, null);
		pnLogin.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setEnabled(false);
		txtLogin.setColumns(10);
		txtLogin.setBounds(6, 79, 181, 43);
		pnLogin.add(txtLogin);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblLogin.setBounds(6, 43, 102, 24);
		pnLogin.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblSenha.setBounds(197, 43, 123, 24);
		pnLogin.add(lblSenha);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("HP Simplified", Font.BOLD, 20));
		lblTipo.setBounds(386, 43, 111, 24);
		pnLogin.add(lblTipo);
		
		txtSenha = new JPasswordField();
		txtSenha.setEnabled(false);
		txtSenha.setBounds(199, 79, 175, 43);
		pnLogin.add(txtSenha);
		
		cbTipoLogin = new JComboBox();
		cbTipoLogin.setEnabled(false);
		cbTipoLogin.setModel(new DefaultComboBoxModel(new String[] {"Comum", "Administrador"}));
		cbTipoLogin.setBounds(386, 79, 176, 43);
		pnLogin.add(cbTipoLogin);
		
		JPanel pnTable = new JPanel();
		pnTable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnTable.setBounds(0, 313, 570, 158);
		getContentPane().add(pnTable);
		pnTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 558, 146);
		pnTable.add(scrollPane);
		
		tbFuncionario = new JTable();

		scrollPane.setViewportView(tbFuncionario);
		
		JPanel pnCrud = new JPanel();
		pnCrud.setLayout(null);
		pnCrud.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnCrud.setBounds(-1, 483, 574, 59);
		getContentPane().add(pnCrud);
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tbFuncionario.setRowSelectionInterval(0,0);
				crud();
				
			}
		});
		btnPrimeiro.setBounds(18, 14, 102, 28);
		pnCrud.add(btnPrimeiro);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbFuncionario.setRowSelectionInterval(tbFuncionario.getSelectedRow()-1, tbFuncionario.getSelectedRow()-1);
				crud();
				
			}
		});
		btnVoltar.setBounds(125, 14, 102, 28);
		pnCrud.add(btnVoltar);
		
		btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbFuncionario.setRowSelectionInterval(tbFuncionario.getSelectedRow()+1, tbFuncionario.getSelectedRow()+1);
				crud();
				
			}
		});
		btnAvancar.setBounds(235, 14, 102, 28);
		pnCrud.add(btnAvancar);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbFuncionario.setRowSelectionInterval(tbFuncionario.getRowCount()-1, tbFuncionario.getRowCount()-1);
				crud();
				
			}
		});
		btnUltimo.setBounds(342, 14, 102, 28);
		pnCrud.add(btnUltimo);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preencherTabela("Select * from tbl_funcionarios");
				
			}
		});
		btnAtualizar.setBounds(448, 14, 102, 28);
		pnCrud.add(btnAtualizar);
		
	
		preencherTabela("Select * from tbl_funcionarios");
		
		
		
	}
	
	public void preencherTabela(String Sql)
	{
		
		Persistencia conexao = new Persistencia();
		
		ArrayList dados = new ArrayList();
		String[] colunas = new String[]{"Codigo","Nome","Cpf","Data de Nascimento","Cargo","Salario","Sexo","Bairro","Cidade","Cep","UF","Numero","Login","Senha","Tipo","Imagen"};
		
		conexao.conexao();
		
		conexao.execultaSql(Sql);
		
		try
		{
			conexao.rs.first();
			do
			{
				dados.add(new Object[]{conexao.rs.getInt("codigo"),conexao.rs.getString("nome"),conexao.rs.getString("cpf"),conexao.rs.getString("nascimento"),conexao.rs.getString("cargo"),conexao.rs.getString("salario"),conexao.rs.getString("sexo"),conexao.rs.getString("bairro"),conexao.rs.getString("cidade"),conexao.rs.getString("cep"),conexao.rs.getString("uf"),conexao.rs.getString("numero"),conexao.rs.getString("login"),conexao.rs.getString("senha"),conexao.rs.getString("tipo"),conexao.rs.getString("imagen")});                                              
			}while(conexao.rs.next());
	
		}
		catch(SQLException erro)
		{
			
		}
		BeansTabela modelo = new BeansTabela(dados,colunas);
		tbFuncionario.setModel(modelo);
	
		tbFuncionario.getColumnModel().getColumn(0).setMinWidth(0);
		tbFuncionario.getColumnModel().getColumn(0).setMaxWidth(0);
		tbFuncionario.getColumnModel().getColumn(0).setWidth(0);
		
		conexao.desconecta();
		
	}
	
	public void crud()
	{
		int codigo = (int) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),0);
		txtCodigo.setText(Integer.toString(codigo));
		txtNome.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),1));
		txtCpf.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),2));
		txtNasc.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),3));
		txtCargo.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),4));
		txtSalario.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),5));
		
		if(tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),6).equals("M"))
		{
			rbMasculino.setSelected(true);
			rbFeminino.setSelected(false);
		}
		else
		{
			rbMasculino.setSelected(false);
			rbFeminino.setSelected(true);
		}
		txtBairro.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),7));
		txtCidade.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),8));
		txtCep.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),9));
		txtUf.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),10));
		txtNumero.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),11));
		txtLogin.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),12));
		txtSenha.setText((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),13));
		cbTipoLogin.setSelectedItem((String) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(),14));
		funImg = func.buscar(codigo);
		ManipularImagem.exibiImagemLabel(funImg.getImagen(), lblImagem);
		
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
			tbFuncionario.setEnabled(true);
			
			btnConfirmar.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnAtualizarImg.setEnabled(false);
			txtCodigo.setEnabled(false);
			txtNome.setEnabled(false);
			txtNome.setEnabled(false);
			txtCpf.setEnabled(false);
			txtNasc.setEnabled(false);
			txtCargo.setEnabled(false);
			txtSalario.setEnabled(false);
			cbTipoLogin.setEnabled(false);
			rbMasculino.setEnabled(false);
			rbFeminino.setEnabled(false);
			txtBairro.setEnabled(false);
			txtUf.setEnabled(false);
			txtCidade.setEnabled(false);
			txtCep.setEnabled(false);
			txtNumero.setEnabled(false);
			txtLogin.setEnabled(false);
			txtSenha.setEnabled(false);
			
			
			
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
			tbFuncionario.setEnabled(false);
		
			btnConfirmar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnAtualizarImg.setEnabled(true);
			txtNome.setEnabled(true);
			txtCpf.setEnabled(true);
			txtNasc.setEnabled(true);
			txtCargo.setEnabled(true);
			txtSalario.setEnabled(true);
			cbTipoLogin.setEnabled(true);
			rbMasculino.setEnabled(true);
			rbFeminino.setEnabled(true);
			txtBairro.setEnabled(true);
			txtUf.setEnabled(true);
			txtCidade.setEnabled(true);
			txtCep.setEnabled(true);
			txtNumero.setEnabled(true);
			txtLogin.setEnabled(true);
			txtSenha.setEnabled(true);
			
			
			
		}
	}
	
}
