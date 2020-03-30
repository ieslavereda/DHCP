package es.ieslavereda.DHCP.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class JIFProperties extends JInternalFrame {
	private JTextField textFieldIP;
	private JTextField textFieldPort;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	private JButton btnSave;

	/**
	 * Create the frame.
	 */
	public JIFProperties() {
		setClosable(true);
		setTitle("Configuracion");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("50px"),
				ColumnSpec.decode("46px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("257px"),},
			new RowSpec[] {
				RowSpec.decode("36px"),
				RowSpec.decode("20px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel lblIp = new JLabel("IP");
		
		textFieldIP = new JTextField();
		textFieldIP.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		
		textFieldPort = new JTextField();
		textFieldPort.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		passwordField = new JPasswordField();
		panel.setLayout(new MigLayout("", "[46px][302px]", "[20px][20px][20px][20px]"));
		panel.add(lblIp, "cell 0 0,alignx right,growy");
		panel.add(textFieldIP, "cell 1 0,growx,aligny top");
		panel.add(lblPort, "cell 0 1,alignx right,growy");
		panel.add(textFieldPort, "cell 1 1,growx,aligny top");
		panel.add(lblLogin, "cell 0 2,alignx right,growy");
		panel.add(textFieldLogin, "cell 1 2,growx,aligny top");
		panel.add(lblPassword, "cell 0 3,alignx left,growy");
		panel.add(passwordField, "cell 1 3,growx,aligny top");
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnOk);
		
		btnSave = new JButton("Save");
		panel_1.add(btnSave);
		getContentPane().setLayout(groupLayout);

	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JTextField getTextFieldIP() {
		return textFieldIP;
	}

	public void setTextFieldIP(JTextField textFieldIP) {
		this.textFieldIP = textFieldIP;
	}

	public JTextField getTextFieldPort() {
		return textFieldPort;
	}

	public void setTextFieldPort(JTextField textFieldPort) {
		this.textFieldPort = textFieldPort;
	}

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public void setTextFieldLogin(JTextField textFieldLogin) {
		this.textFieldLogin = textFieldLogin;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	
}
