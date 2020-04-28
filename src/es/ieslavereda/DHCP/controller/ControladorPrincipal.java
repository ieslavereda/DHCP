package es.ieslavereda.DHCP.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import es.ieslavereda.DHCP.model.Model;
import es.ieslavereda.DHCP.view.JIFDHCP;
import es.ieslavereda.DHCP.view.JIFLogin;
import es.ieslavereda.DHCP.view.JIFProperties;
import es.ieslavereda.DHCP.view.Principal;

public class ControladorPrincipal implements ActionListener {

	private Model model;
	private Principal view;
	private JIFLogin jifLogin;
	private JIFProperties jifProperties;
	private JIFDHCP jifDHCP;

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
		view.getMntmDHCP().addActionListener(this);
		view.getMntmCerrarSesion().addActionListener(this);

		// Añadir los ActionCommand
		view.getMntmExit().setActionCommand("Exit");
		view.getMntmSesion().setActionCommand("Abrir JIFrame Login");
		view.getMntmConfiguracion().setActionCommand("Abrir JIFProperties");
		view.getMntmDHCP().setActionCommand("Abrir DHCP Manager");
		view.getMntmCerrarSesion().setActionCommand("Cerrar sesion");

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
		} else if (command.equals("Login OK")) {
			iniciarSesion();
		} else if (command.equals("Abrir JIFProperties")) {
			openProperties();
		} else if (command.equals("Abrir DHCP Manager")) {
			openDHCP();
		} else if (command.equals("Save properties")) {
			saveProperties();
		} else if (command.equals("Cerrar sesion")) {
			deshabilitarInicioSesion();
		}

	}

	private void saveProperties() {

		int option = JOptionPane.showConfirmDialog(jifProperties, "Estas usted seguro de guardar la configuracion",
				"Guardar configuracion", JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.YES_OPTION) {
			String login = jifProperties.getTextFieldLogin().getText();
			String passwd = String.valueOf(jifProperties.getPasswordField().getPassword());
			InetAddress IP = null;
			int port = Integer.parseInt(jifProperties.getTextFieldPort().getText());

			try {

				IP = InetAddress.getByName(jifProperties.getTextFieldIP().getText());
				if (model.saveProperties(login, passwd, IP, port))
					JOptionPane.showMessageDialog(jifProperties, "Datos grabados", "Guardar configuracion",
							JOptionPane.INFORMATION_MESSAGE);

			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(jifProperties, "Se ha producido un error. Compruebe la direccio IP",
						"Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}

	}

	private void openDHCP() {

		if (!estaAbierto(jifDHCP)) {

			jifDHCP = new JIFDHCP();
			view.getDesktop().add(jifDHCP);

			new ControladorJIFDHCP(jifDHCP, model,view).go();

		}

	}

	private void openProperties() {

		if (!estaAbierto(jifProperties)) {
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

		if (model.comprobarLogin(login, passwd)) {
			jifLogin.dispose();
			JOptionPane.showMessageDialog(null, "Usuario correcto!", "Info", JOptionPane.INFORMATION_MESSAGE);
			habilitarInicioSesion();

		} else {
			JOptionPane.showMessageDialog(null, "Usuario incorrecto!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void habilitarInicioSesion() {

		view.getMntmConfiguracion().setEnabled(true);
		view.getMntmDHCP().setEnabled(true);
		view.getMntmIniciarSesion().setEnabled(false);
		view.getMntmCerrarSesion().setEnabled(true);

	}

	private void deshabilitarInicioSesion() {

		int opcion = JOptionPane.showConfirmDialog(view, "Esta usted seguro de cerrar la sesion?", "Cerrar sesion",
				JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			
			view.getMntmConfiguracion().setEnabled(false);
			view.getMntmDHCP().setEnabled(false);
			view.getMntmIniciarSesion().setEnabled(true);
			view.getMntmCerrarSesion().setEnabled(false);
			
			JInternalFrame[] frames = view.getDesktop().getAllFrames();
			for (JInternalFrame frame : frames)
				frame.dispose();
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
