package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import persistencia.Persistencia;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import outros.DadosLogin;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblSenha;
	private JLabel lblSoulMovie;
	private JLabel lblByViniciusDo;
	Persistencia con = new Persistencia();
	private JPasswordField passSenha;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
				
			}
		Login frame = new Login();
		frame.setVisible(true);
	}
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imgs/LogoProvavelFinal.png")));
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imgs/LogoProvavelFinal.png")));
		lblNewLabel.setBounds(29, 48, 305, 279);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Trajan Pro", Font.PLAIN, 17));
		lblUsuario.setBounds(364, 71, 142, 25);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(364, 99, 216, 32);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Trajan Pro", Font.PLAIN, 17));
		lblSenha.setBounds(364, 143, 142, 25);
		contentPane.add(lblSenha);
		
		lblSoulMovie = new JLabel("Soul Movie");
		lblSoulMovie.setForeground(Color.WHITE);
		lblSoulMovie.setFont(new Font("Footlight MT Light", Font.BOLD | Font.ITALIC, 22));
		lblSoulMovie.setBounds(244, 6, 179, 25);
		contentPane.add(lblSoulMovie);
		
		lblByViniciusDo = new JLabel("by Vinicius do Prado and James Wander");
		lblByViniciusDo.setBounds(358, 317, 252, 28);
		contentPane.add(lblByViniciusDo);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				con.conexao();
				
				try 
				{
					con.execultaSql("SELECT * FROM tbl_funcionarios WHERE login ='"+txtUsuario.getText()+"'");
					con.rs.first();
					if(con.rs.getString("senha").equals(passSenha.getText()))
					{
					
					
						try {
							DadosLogin.setNome(con.rs.getString("nome"));
							DadosLogin.setTipo(con.rs.getString("tipo"));
							DadosLogin.setCodigo(Integer.parseInt(con.rs.getString("codigo")));
							
							TelaPrincipal home = new TelaPrincipal();
							home.setVisible(true);
							dispose();
							
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedLookAndFeelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (SQLException e1) 
				{
					JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
				con.desconecta();
				
			}
		});
		btnLogar.setBounds(363, 223, 99, 36);
		contentPane.add(btnLogar);
		
		JButton btnSairLogin = new JButton("Sair");
		btnSairLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnSairLogin.setBounds(481, 223, 99, 36);
		contentPane.add(btnSairLogin);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(364, 180, 216, 31);
		contentPane.add(passSenha);
	}
}
