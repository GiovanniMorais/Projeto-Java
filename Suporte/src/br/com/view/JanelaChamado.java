package br.com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;

public class JanelaChamado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDepartamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaChamado frame = new JanelaChamado();
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
	public JanelaChamado() {
		setTitle("Sistema de Suporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha todos os campos para efeturar um chamado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 11, 385, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("insira seu nome:");
		lblNewLabel_1.setBounds(158, 57, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(143, 82, 208, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Informe com qual departamentodeseja falar:");
		lblNewLabel_2.setBounds(134, 113, 261, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(134, 138, 217, 20);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Conte-nos mais sobre seu problema:");
		lblNewLabel_4.setBounds(134, 186, 217, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(134, 214, 341, 131);
		contentPane.add(txtDescricao);
		
		JButton btnRegistrar = new JButton("Registrar chamado");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				CRUDChamado cc = new CRUDChamado();
				
				Chamado soliChamado = new Chamado(); 

				if(txtNome.getText().trim().equals("") || 
						txtDepartamento.getText().trim().equals("") || 
						txtDescricao.getText().trim().equals("")) { 
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
				} 
				else { 
 
					soliChamado.setSolicitacao(txtNome.getText()); 
 
					soliChamado.setDepSolicitado(txtDepartamento.getText()); 
 
					soliChamado.setDescChamado(txtDescricao.getText()); 
 
					JOptionPane.showMessageDialog(null, cc.registrar(soliChamado)); 
 
				}
				 
		
				
			}
		});
		btnRegistrar.setBounds(0, 163, 166, 23);
		contentPane.add(btnRegistrar);

	}
}