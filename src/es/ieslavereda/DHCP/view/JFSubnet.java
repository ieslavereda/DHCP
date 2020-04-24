package es.ieslavereda.DHCP.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFSubnet extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMascara;
	private JTextField textFieldSubnet;
	private JTextField textFieldDNS1;
	private JTextField textFieldDNS2;
	private JTextField textFieldRange1;
	private JTextField textFieldRange2;
	private JTextField textFieldGateway;
	private JTextField textFieldNTP;
	private JTextField textFieldNetBios;
	private JCheckBox chckbxRangeActive;
	private JButton btnAccion;
	private JButton btnCancelar;

	public JFSubnet() {
		setTitle("Net");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new MigLayout("", "[][grow][grow][grow]", "[24.00][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Subnet");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textFieldSubnet = new JTextField();
		panel.add(textFieldSubnet, "cell 1 0,growx");
		textFieldSubnet.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mascara");
		panel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textFieldMascara = new JTextField();
		panel.add(textFieldMascara, "cell 1 1,growx");
		textFieldMascara.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNS");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textFieldDNS1 = new JTextField();
		panel.add(textFieldDNS1, "cell 1 2,growx");
		textFieldDNS1.setColumns(10);
		
		textFieldDNS2 = new JTextField();
		panel.add(textFieldDNS2, "cell 1 3,growx");
		textFieldDNS2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gateway");
		panel.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		textFieldGateway = new JTextField();
		panel.add(textFieldGateway, "cell 1 4,growx");
		textFieldGateway.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("NTP-Server");
		panel.add(lblNewLabel_4, "cell 0 5,alignx trailing,aligny top");
		
		textFieldNTP = new JTextField();
		panel.add(textFieldNTP, "cell 1 5,growx");
		textFieldNTP.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("NetBios");
		panel.add(lblNewLabel_5, "cell 0 6,alignx trailing,aligny top");
		
		textFieldNetBios = new JTextField();
		panel.add(textFieldNetBios, "cell 1 6,growx");
		textFieldNetBios.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Range");
		panel.add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		textFieldRange1 = new JTextField();
		panel.add(textFieldRange1, "cell 1 7,growx");
		textFieldRange1.setColumns(10);
		
		textFieldRange2 = new JTextField();
		panel.add(textFieldRange2, "cell 2 7,growx");
		textFieldRange2.setColumns(10);
		
		chckbxRangeActive = new JCheckBox("Active");
		panel.add(chckbxRangeActive, "cell 3 7");
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnAccion = new JButton("New button");
		panel_1.add(btnAccion);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnCancelar);
		contentPane.setLayout(gl_contentPane);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldMascara() {
		return textFieldMascara;
	}

	public JTextField getTextFieldSubnet() {
		return textFieldSubnet;
	}

	public JTextField getTextFieldDNS1() {
		return textFieldDNS1;
	}

	public JTextField getTextFieldDNS2() {
		return textFieldDNS2;
	}

	public JTextField getTextFieldRange1() {
		return textFieldRange1;
	}

	public JTextField getTextFieldRange2() {
		return textFieldRange2;
	}

	public JTextField getTextFieldGateway() {
		return textFieldGateway;
	}

	public JTextField getTextFieldNTP() {
		return textFieldNTP;
	}

	public JTextField getTextFieldNetBios() {
		return textFieldNetBios;
	}

	public JCheckBox getChckbxRangeActive() {
		return chckbxRangeActive;
	}

	public JButton getBtnAccion() {
		return btnAccion;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	
}
