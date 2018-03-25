package visao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import dao.DaoTitulos;
import beans.BeansTabela;
import beans.BeansTitulos;
import persistencia.Persistencia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;

import outros.ManipularImagem;

import javax.swing.JFormattedTextField;

public class CadastrodeTitulos extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTable tbTitulos;
	private JTextField txtCensura;
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
	private BufferedImage imagem;
	private JButton btnAtualizar;
	private JComboBox cbCategorias;
	private DefaultTableModel dtm;
	private int botao;

	BeansTitulos tit = new BeansTitulos();
	DaoTitulos tid = new DaoTitulos();
	private JLabel lblImagem;
	private JTextField txtValor;
	private JFormattedTextField txtLancamento;
	

	public CadastrodeTitulos() {
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
		setBounds(100, 100, 598, 607);
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeTitulos = new JLabel("Cadastro de Titulos");
		lblCadastroDeTitulos.setForeground(new Color(51, 102, 255));
		lblCadastroDeTitulos.setFont(new Font("MS PMincho", Font.BOLD | Font.ITALIC, 28));
		lblCadastroDeTitulos.setBackground(Color.WHITE);
		lblCadastroDeTitulos.setBounds(144, 0, 292, 29);
		getContentPane().add(lblCadastroDeTitulos);
		
		JPanel pnBotoes = new JPanel();
		pnBotoes.setLayout(null);
		pnBotoes.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnBotoes.setBounds(6, 35, 574, 68);
		getContentPane().add(pnBotoes);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botao = 1;
				txtCodigo.setText("Automatico");
				txtNome.setText("");
				txtLancamento.setText("");
				txtCensura.setText("");
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
				preencherTabela("select * from tbl_titulos");
				
			}
		});
		btnAlterar.setBounds(120, 16, 105, 35);
		pnBotoes.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja Excluir?","Excluir Titulo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					
					
					tit.setCodigo(Integer.parseInt(txtCodigo.getText()));
					tid.ExcluirTitulos(tit);
					txtCodigo.setText("");
					txtNome.setText("");
					txtLancamento.setText("");
					txtCensura.setText("");
					
				}
				preencherTabela("select * from tbl_titulos");
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
					tit.setNome(txtNome.getText());
					tit.setCategoria((String) cbCategorias.getSelectedItem());
					tit.setCensura(txtCensura.getText());
					tit.setLancamento(txtLancamento.getText());
					tit.setValor(Double.parseDouble(txtValor.getText()));
					tit.setImagen(ManipularImagem.getImgBytes(imagem));
					tid.CadastrarTitulos(tit);
					txtCodigo.setText("");
					txtNome.setText("");
					txtLancamento.setText("");
					txtCensura.setText("");
				}
				else
				{
					tit.setNome(txtNome.getText());
					tit.setCategoria((String) cbCategorias.getSelectedItem());
					tit.setCensura(txtCensura.getText());
					tit.setLancamento(txtLancamento.getText());
					tit.setCodigo(Integer.parseInt(txtCodigo.getText()));
					tit.setImagen(ManipularImagem.getImgBytes(imagem));
					tit.setValor(Double.parseDouble(txtValor.getText()));
					tid.AlterarTitulos(tit);
					txtCodigo.setText("");
					txtNome.setText("");
					txtLancamento.setText("");
					txtCensura.setText("");
				}
				preencherTabela("select * from tbl_titulos");
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
				txtLancamento.setText("");
				txtCensura.setText("");
				
			}
		});
		btnCancelar.setBounds(451, 15, 105, 35);
		btnCancelar.setEnabled(false);
		pnBotoes.add(btnCancelar);
		
		JPanel pnCampos = new JPanel();
		pnCampos.setLayout(null);
		pnCampos.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCampos.setBounds(6, 115, 320, 211);
		getContentPane().add(pnCampos);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCodigo.setBounds(19, 13, 72, 16);
		pnCampos.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNome.setBounds(19, 47, 72, 16);
		pnCampos.add(lblNome);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCategoria.setBounds(19, 84, 95, 16);
		pnCampos.add(lblCategoria);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(116, 6, 158, 28);
		txtCodigo.setEnabled(false);
		pnCampos.add(txtCodigo);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(116, 43, 158, 28);
		txtNome.setEnabled(false);
		pnCampos.add(txtNome);
		
		cbCategorias = new JComboBox();
		cbCategorias.setBounds(116, 78, 158, 22);
		cbCategorias.setEnabled(false);
		pnCampos.add(cbCategorias);
		
		JLabel lblLanamento = new JLabel("Lan\u00E7amento:");
		lblLanamento.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblLanamento.setBounds(19, 119, 85, 16);
		pnCampos.add(lblLanamento);
		
		JLabel lblCensura = new JLabel("Censura:");
		lblCensura.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblCensura.setBounds(19, 151, 72, 16);
		pnCampos.add(lblCensura);
		
		txtCensura = new JTextField();
		txtCensura.setColumns(10);
		txtCensura.setBounds(116, 144, 158, 28);
		txtCensura.setEnabled(false);
		pnCampos.add(txtCensura);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblValor.setBounds(17, 185, 72, 16);
		pnCampos.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(116, 180, 158, 25);
		pnCampos.add(txtValor);
		
		txtLancamento = new JFormattedTextField(Mascara("##/##/####"));
		txtLancamento.setEnabled(false);
		txtLancamento.setBounds(116, 113, 158, 22);
		pnCampos.add(txtLancamento);
		
		JPanel pnTable = new JPanel();
		pnTable.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		pnTable.setBounds(6, 332, 320, 167);
		getContentPane().add(pnTable);
		pnTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 308, 155);
		pnTable.add(scrollPane);
		
		tbTitulos = new JTable();
		tbTitulos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crud();
			}
		});

		scrollPane.setViewportView(tbTitulos);
		
		JPanel pnCrud = new JPanel();
		pnCrud.setLayout(null);
		pnCrud.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		pnCrud.setBounds(6, 511, 574, 59);
		getContentPane().add(pnCrud);
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbTitulos.setRowSelectionInterval(0,0);
				crud();
				
			}
		});
		btnPrimeiro.setBounds(18, 14, 102, 28);
		pnCrud.add(btnPrimeiro);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbTitulos.setRowSelectionInterval(tbTitulos.getSelectedRow()-1, tbTitulos.getSelectedRow()-1);
				crud();
				
			}
		});
		btnVoltar.setBounds(125, 14, 102, 28);
		pnCrud.add(btnVoltar);
		
		btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbTitulos.setRowSelectionInterval(tbTitulos.getSelectedRow()+1, tbTitulos.getSelectedRow()+1);
				crud();
				
			}
		});
		btnAvancar.setBounds(235, 14, 102, 28);
		pnCrud.add(btnAvancar);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tbTitulos.setRowSelectionInterval(tbTitulos.getRowCount()-1, tbTitulos.getRowCount()-1);
				crud();
				
			}
		});
		btnUltimo.setBounds(342, 14, 102, 28);
		pnCrud.add(btnUltimo);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preencherTabela("select * from tbl_titulos");
				
			}
		});
		btnAtualizar.setBounds(448, 14, 102, 28);
		pnCrud.add(btnAtualizar);
		
		JPanel pnImagem = new JPanel();
		pnImagem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnImagem.setBounds(360, 138, 185, 298);
		getContentPane().add(pnImagem);
		

	
		pnImagem.setLayout(null);
		
		lblImagem = new JLabel("");
		lblImagem.setBounds(0, 6, 186, 286);
		pnImagem.add(lblImagem);
		
		btnAtualizarImg = new JButton("Alterar");
		btnAtualizarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
		        int res = fc.showOpenDialog(null);

		        if (res == JFileChooser.APPROVE_OPTION) {
		            File arquivo = fc.getSelectedFile();

		            try {
		                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 200, 500);

		                lblImagem.setIcon(new ImageIcon(imagem));

		            } catch (Exception ex) {
		               // System.out.println(ex.printStackTrace().toString());
		            }

		        } else {
		            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
		        }
			}
		});
		btnAtualizarImg.setBounds(348, 471, 209, 28);
		btnAtualizarImg.setEnabled(false);
		getContentPane().add(btnAtualizarImg);
		
		preencherComboBox();
		preencherTabela("select * from tbl_titulos");
		
		
		
		tbTitulos.setRowSelectionInterval(0,0);
		crud();
		
	}
	
	public void preencherComboBox()
	{
		Persistencia conexao = new Persistencia();
		
		conexao.conexao();
		
		conexao.execultaSql("select * from tbl_categoria");
		try 
		{
			conexao.rs.first();
			cbCategorias.removeAllItems();
			
			do
			{
				cbCategorias.addItem(conexao.rs.getString("nome"));
				
			}
			while(conexao.rs.next());

		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		conexao.desconecta();
	}
	
	
	
	public void preencherTabela(String Sql)
	{
		
		Persistencia conexao = new Persistencia();
		
		ArrayList dados = new ArrayList();
		String[] colunas = new String[]{"Codigo","Nome","Categoria","Lançamento","Censura","Imagen","Valor"};
		
		conexao.conexao();
		
		conexao.execultaSql(Sql);
		
		try
		{
			conexao.rs.first();
			do
			{
				dados.add(new Object[]{conexao.rs.getInt("codigo"),conexao.rs.getString("nome"),conexao.rs.getString("categoria"),conexao.rs.getString("lancamento"),conexao.rs.getString("censura"),conexao.rs.getString("imagen"),conexao.rs.getString("valor")});
			}while(conexao.rs.next());
	
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(rootPane,"");
		}
		BeansTabela modelo = new BeansTabela(dados,colunas);
		tbTitulos.setModel(modelo);
		tbTitulos.getColumnModel().getColumn(0).setMinWidth(0);
		tbTitulos.getColumnModel().getColumn(0).setMaxWidth(0);
		tbTitulos.getColumnModel().getColumn(0).setWidth(0);
		tbTitulos.getColumnModel().getColumn(5).setMinWidth(0);
		tbTitulos.getColumnModel().getColumn(5).setMaxWidth(0);
		tbTitulos.getColumnModel().getColumn(5).setWidth(0);
		
		
		conexao.desconecta();
	
	}
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	 this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	 
	}
	
	public void crud()
	{
		int codigo = (int) tbTitulos.getValueAt(tbTitulos.getSelectedRow(),0);
		txtCodigo.setText(Integer.toString(codigo));
		txtNome.setText((String) tbTitulos.getValueAt(tbTitulos.getSelectedRow(),1));
		cbCategorias.setSelectedItem((String) tbTitulos.getValueAt(tbTitulos.getSelectedRow(),2));
		txtLancamento.setText((String) tbTitulos.getValueAt(tbTitulos.getSelectedRow(),3));
		txtCensura.setText((String) tbTitulos.getValueAt(tbTitulos.getSelectedRow(),4));
		txtValor.setText((String) (tbTitulos.getValueAt(tbTitulos.getSelectedRow(),6)));
		tit = tid.buscar(codigo);
		ManipularImagem.exibiImagemLabel(tit.getImagen(), lblImagem);
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
			tbTitulos.setEnabled(true);
			
			btnConfirmar.setEnabled(false);
			btnCancelar.setEnabled(false);
			txtCodigo.setEnabled(false);
			txtNome.setEnabled(false);
			txtLancamento.setEnabled(false);
			txtCensura.setEnabled(false);
			cbCategorias.setEnabled(false);
			btnAtualizarImg.setEnabled(false);
			txtValor.setEnabled(false);
			
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
			tbTitulos.setEnabled(false);
			
		
			
			txtNome.setEnabled(true);
			btnConfirmar.setEnabled(true);
			btnCancelar.setEnabled(true);
			txtLancamento.setEnabled(true);
			txtCensura.setEnabled(true);
			cbCategorias.setEnabled(true);
			btnAtualizarImg.setEnabled(true);
			txtValor.setEnabled(true);
		}
	}
}
