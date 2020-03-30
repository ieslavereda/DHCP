package es.ieslavereda.DHCP.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import es.ieslavereda.DHCP.model.Model;
import es.ieslavereda.DHCP.view.JIFLogin;
import es.ieslavereda.DHCP.view.JIFProperties;
import es.ieslavereda.DHCP.view.Principal;

public class ControladorPrincipal implements ActionListener {

	private Model model;
	private Principal view;
	private JIFLogin jifLogin;
	private JIFProperties jifProperties;

	public ControladorPrincipal(Principal view, Model model) {
		super();
		this.model = model;
		this.view = view;

		inicializar();
	}

	public void inicializar() {

		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension(800, 600);

		view.setTitle("Gestion DHCP");
		view.setMaximumSize(dim);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setLocationRelativeTo(null);// centrado en pantalla

		// Añadir los ActionListener
		view.getMntmExit().addActionListener(this);
		view.getMntmSesion().addActionListener(this);
		view.getMntmConfiguracion().addActionListener(this);

		// Añadir los ActionCommand
		view.getMntmExit().setActionCommand("Exit");
		view.getMntmSesion().setActionCommand("Abrir JIFrame Login");
		view.getMntmConfiguracion().setActionCommand("Abrir JIFProperties");

	}

	public void go() {
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (command.equals("Exit")) {
			view.dispose();
		} else if (command.equals("Abrir JIFrame Login")) {
			abrirJIFrameSesion();
		}  else if (command.equals("Login OK")) {
			iniciarSesion();
		} else if (command.equals("Abrir JIFProperties")) {
			openProperties();
		}

	}

	private void openProperties() {
		
		if(!estaAbierto(jifProperties)) {
			jifProperties = new JIFProperties();			
			view.getDesktop().add(jifProperties);
			jifProperties.setVisible(true);
			
			// Add Listener
			jifProperties.getBtnSave().addActionListener(this);
			
			// Add command
			jifProperties.getBtnSave().setActionCommand("Save properties");
			
			jifProperties.getTextFieldLogin().setText(model.getLogin());
			jifProperties.getTextFieldIP().setText(model.getIP());
			jifProperties.getTextFieldPort().setText(model.getPort());
			jifProperties.getPasswordField().setText(model.getPassword());
			
		}
		
	}

	private void iniciarSesion() {
		
		String login = jifLogin.getTextFieldLogin().getText();
		String passwd = String.valueOf(jifLogin.getPasswordField().getPassword());
		
		if(model.comprobarLogin(login, passwd)) {
			JOptionPane.showMessageDialog(null, "Usuario correcto!", "Info", JOptionPane.INFORMATION_MESSAGE);
			jifLogin.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario incorrecto!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void abrirJIFrameSesion() {
				
		if (!estaAbierto(jifLogin)) {				
			jifLogin = new JIFLogin();
			jifLogin.setVisible(true);
			view.getDesktop().add(jifLogin);
			
			// Añadir ActionListener
			jifLogin.getBtnOk().addActionListener(this);
			
			// Añadir ActionCommand
			jifLogin.getBtnOk().setActionCommand("Login OK");
			
		}
	}

	private boolean estaAbierto(JInternalFrame o) {
		boolean existe = false;
		JInternalFrame[] frames = view.getDesktop().getAllFrames();
		for (JInternalFrame frame : frames) {
			if (frame == o)
				existe = true;
		}
		return existe;
	}

}
