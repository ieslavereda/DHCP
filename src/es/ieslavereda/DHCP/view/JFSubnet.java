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

public class JFSubnet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public JFSubnet() {
		setTitle("Net");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 312);
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
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mascara");
		panel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNS");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 3,growx");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gateway");
		panel.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		textField_6 = new JTextField();
		panel.add(textField_6, "cell 1 4,growx");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("NTP-Server");
		panel.add(lblNewLabel_4, "cell 0 5,alignx trailing,aligny top");
		
		textField_7 = new JTextField();
		panel.add(textField_7, "cell 1 5,growx");
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("NetBios");
		panel.add(lblNewLabel_5, "cell 0 6,alignx trailing,aligny top");
		
		textField_8 = new JTextField();
		panel.add(textField_8, "cell 1 6,growx");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Range");
		panel.add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 7,growx");
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		panel.add(textField_5, "cell 2 7,growx");
		textField_5.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Active");
		panel.add(chckbxNewCheckBox, "cell 3 7");
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnAccion = new JButton("New button");
		panel_1.add(btnAccion);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		contentPane.setLayout(gl_contentPane);
	}
}
