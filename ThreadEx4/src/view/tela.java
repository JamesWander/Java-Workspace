package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MoverCarro;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class tela extends JFrame {

	private JPanel contentPane;
	JLabel lblCarro;
	JLabel lblCarro2;
	private JTextField TxVencedor;
	private JTextField TxPerdedor;
	private JButton BtIniciar;
	private MoverCarro carro;
	private MoverCarro carro2;
	private JButton BtReiniciar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela frame = new tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tela() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BtIniciar = new JButton("Iniciar Corrida");
		BtIniciar.setBounds(374, 36, 158, 33);
		contentPane.add(BtIniciar);
		
		TxVencedor = new JTextField();
		TxVencedor.setEditable(false);
		TxVencedor.setBounds(91, 60, 86, 20);
		contentPane.add(TxVencedor);
		TxVencedor.setColumns(10);
		
		TxPerdedor = new JTextField();
		TxPerdedor.setEditable(false);
		TxPerdedor.setColumns(10);
		TxPerdedor.setBounds(711, 60, 86, 20);
		contentPane.add(TxPerdedor);
		
		BtReiniciar = new JButton("Reiniciar");
		BtReiniciar.setBounds(374, 80, 158, 33);
		BtReiniciar.setVisible(false);
		contentPane.add(BtReiniciar);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVencedor.setBounds(102, 24, 75, 33);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerdedor.setBounds(722, 24, 75, 33);
		contentPane.add(lblPerdedor);
		
		lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setIcon(new ImageIcon(tela.class.getResource("/imagens/carro 2.png")));
		lblCarro2.setBounds(485, 467, 137, 133);
		contentPane.add(lblCarro2);
		
		lblCarro = new JLabel("Carro 1");
		lblCarro.setIcon(new ImageIcon(tela.class.getResource("/imagens/carro 1.png")));
		lblCarro.setBounds(293, 467, 137, 133);
		contentPane.add(lblCarro);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(tela.class.getResource("/imagens/mapa.jpg")));
		label.setBounds(0, 0, 900, 600);
		contentPane.add(label);
		
		ajustaImagen();
		
		ActionListener mover = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				carro = new MoverCarro(lblCarro,1,TxVencedor,TxPerdedor,BtReiniciar);
				carro.start();
				
				carro2 = new MoverCarro(lblCarro2,2,TxVencedor,TxPerdedor,BtReiniciar);
				carro2.start();
				
				BtIniciar.setVisible(false);
				
				
			}
		};
		
		
		ActionListener reiniciar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				reiniciar();
				
			}
		};
		
		BtReiniciar.addActionListener(reiniciar);
		BtIniciar.addActionListener(mover);
	}
	
	public void ajustaImagen()
	{
		ImageIcon carro = new ImageIcon(tela.class.getResource("/imagens/carro 1.png"));
		Image img = carro.getImage();
		Image novaimg = img.getScaledInstance(lblCarro.getWidth(), lblCarro.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(novaimg);
		lblCarro.setIcon(image);
		
		ImageIcon carro1 = new ImageIcon(tela.class.getResource("/imagens/carro 2.png"));
		Image img1 = carro1.getImage();
		Image novaimg1 = img1.getScaledInstance(lblCarro2.getWidth(), lblCarro2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image1 = new ImageIcon(novaimg1);
		lblCarro2.setIcon(image1);
	}
	
	public void reiniciar()
	{
		lblCarro2.setBounds(485, 467, 137, 133);
		lblCarro.setBounds(293, 467, 137, 133);
		ajustaImagen();
		TxVencedor.setText("");
		TxPerdedor.setText("");
		BtReiniciar.setVisible(false);
		BtIniciar.setVisible(true);
		
	}
	
	
}
