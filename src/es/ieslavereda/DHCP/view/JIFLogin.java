package es.ieslavereda.DHCP.view;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import javax.swing.JPasswordField;

public class JIFLogin extends JInternalFrame {
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	private JButton btnOk;

	/**
	 * Create the frame.
	 */
	public JIFLogin() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(JIFLogin.class.getResource("/es/ieslavereda/DHCP/images/logoIES.png")));
		panel.add(label, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOk = new JButton("OK");
		btnOk.setPreferredSize(new Dimension(80, 23));
		btnOk.setMinimumSize(new Dimension(80, 23));
		btnOk.setMaximumSize(new Dimension(80, 23));
		panel_2.add(btnOk);
		panel_1.setLayout(new MigLayout("", "[213px]", "[14px][20px][14px][20px]"));
		
		JLabel lblLogin = new JLabel("Login");
		panel_1.add(lblLogin, "cell 0 0,alignx left,aligny top");
		
		textFieldLogin = new JTextField();
		panel_1.add(textFieldLogin, "cell 0 1,growx,aligny top");
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		panel_1.add(lblPassword, "cell 0 2,alignx left,aligny top");
		
		passwordField = new JPasswordField();
		panel_1.add(passwordField, "cell 0 3,growx,aligny top");
		getContentPane().setLayout(groupLayout);

	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	
}
