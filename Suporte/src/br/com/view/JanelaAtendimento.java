package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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

public class JanelaAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtStatus;
	private JTextField txtResolucao;
	private JTextField txtResponsavel;
	
	Long id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAtendimento frame = new JanelaAtendimento();
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
	public JanelaAtendimento() {
		setTitle("Sistema de suporte - Atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Do Chamado:");
		lblNewLabel.setBounds(58, 45, 144, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(58, 70, 173, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Status do Chamado:");
		lblNewLabel_1.setBounds(309, 45, 173, 14);
		contentPane.add(lblNewLabel_1);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(301, 70, 196, 20);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Reosoluçao:");
		lblNewLabel_2.setBounds(59, 118, 156, 14);
		contentPane.add(lblNewLabel_2);
		
		txtResolucao = new JTextField();
		txtResolucao.setBounds(58, 150, 173, 20);
		contentPane.add(txtResolucao);
		txtResolucao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Responsavel Do Chamado:");
		lblNewLabel_3.setBounds(307, 118, 190, 14);
		contentPane.add(lblNewLabel_3);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(301, 150, 196, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JTextArea txtObservacoes = new JTextArea();
		txtObservacoes.setBounds(10, 196, 248, 123);
		contentPane.add(txtObservacoes);
		
		JLabel lblNewLabel_4 = new JLabel("Observaçoes:");
		lblNewLabel_4.setBounds(101, 181, 101, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnAtualizar = new JButton("Atualizar Chamado");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDChamado cc = new CRUDChamado(); 
				
				Chamado cr = new Chamado(); 
				 
				if(txtResponsavel.getText().trim().equals("") || txtStatus.getText().trim().equals("") || 
				txtID.getText().trim().equals("") || txtResolucao.getText().trim().equals("")) {
				 JOptionPane.showMessageDialog(null, "Os campos Responsável Chamado, Id do Chamado, Status do Chamado e Data de Resolução devem ser preenchidos", 
				"Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
				} 
				else { 
				 
				 cr.setDataResolucao(txtResolucao.getText()); 
				cr.setStatusChamado(txtStatus.getText()); 
				cr.setAtendente(txtResponsavel.getText()); 
				cr.setObservacoes(txtObservacoes.getText()); 
				cr.setIdChamado(Long.parseLong(txtID.getText())); 
				 JOptionPane.showMessageDialog(null, cc.atualizar(cr)); 
				} 
				
			}
		});
		btnAtualizar.setBounds(352, 197, 165, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir Chamado");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUDChamado cc = new CRUDChamado();
				
				if(id.equals(null)) { 
					JOptionPane.showMessageDialog(null,"Selecione o chamado a ser excluído.","Erro 4000770x",JOptionPane.ERROR_MESSAGE); 
					} 
					else { 
					if(JOptionPane.showConfirmDialog(null, "Você tem certeza desta ação? \nEstá ação é permanente "+ "e não pode ser desfeita", "ATENÇÃO", JOptionPane.YES_NO_OPTION, 
					 JOptionPane.QUESTION_MESSAGE) == 0) { 
					Chamado cr = new Chamado(); 
					cr.setIdChamado(Long.parseLong(txtID.getText())); 
					JOptionPane.showConfirmDialog(null, cc.apagar(cr)); 
					} 
					}

				
			}
		});
		btnExcluir.setBounds(352, 253, 165, 23);
		contentPane.add(btnExcluir);
	}
	
}
