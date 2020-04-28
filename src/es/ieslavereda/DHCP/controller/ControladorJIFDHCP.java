package es.ieslavereda.DHCP.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import es.ieslavereda.DHCP.common.Host;
import es.ieslavereda.DHCP.common.SubNet;
import es.ieslavereda.DHCP.model.ConfiguracionDHCP;
import es.ieslavereda.DHCP.model.Model;
import es.ieslavereda.DHCP.view.JFSubnet;
import es.ieslavereda.DHCP.view.JIFDHCP;
import es.ieslavereda.DHCP.view.Principal;

public class ControladorJIFDHCP implements ActionListener {

	private JIFDHCP view;
	private Model model;
	private ConfiguracionDHCP conf;
	private SubNet subnet;
	private JFSubnet jfSubnet;
	private Principal principal;

	public ControladorJIFDHCP(JIFDHCP view, Model model, Principal principal) {
		super();
		this.view = view;
		this.model = model;
		this.principal = principal;

		inicializar();
	}

	private void inicializar() {

		// Añadimos action listener
		view.getMntmOpen().addActionListener(this);
		view.getMntmSave().addActionListener(this);
		view.getBtnNetEdit().addActionListener(this);
		view.getBtnDelete().addActionListener(this);
		view.getBtnAdd().addActionListener(this);
		view.getComboBox().addActionListener(this);

		// Añadimos action command
		view.getMntmOpen().setActionCommand("Open file");
		view.getMntmSave().setActionCommand("Save file");
		view.getBtnNetEdit().setActionCommand("Edit net");
		view.getBtnDelete().setActionCommand("Delete Net");
		view.getBtnAdd().setActionCommand("Add Net");
		view.getComboBox().setActionCommand("refresh combo");

	}

	public void go() {
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (command.equals("Open file")) {
			openFile();
		} else if (command.equals("Edit net")) {
			editNet();
		} else if (command.equals("Delete Net")) {
			removeNet();
		} else if (command.equals("Actualizar Red")) {
			actualizarRed();
		} else if (command.equals("Add Net")) {
			addNet();
		} else if (command.equals("Add new net")) {
			addNewNet();
		} else if (command.equals("refresh combo")) {
			actualizarComboBox();
		}

	}

	private void addNewNet() {
		try {
			// Cargar datos del formulario
			InetAddress net = InetAddress.getByName(jfSubnet.getTextFieldSubnet().getText());
			InetAddress netmask = InetAddress.getByName(jfSubnet.getTextFieldMascara().getText());
			String comment = "";
			ArrayList<InetAddress> optionDomainNameServer = new ArrayList<InetAddress>();
			optionDomainNameServer.add(0, InetAddress.getByName(jfSubnet.getTextFieldDNS1().getText()));
			optionDomainNameServer.add(1, InetAddress.getByName(jfSubnet.getTextFieldDNS2().getText()));
			InetAddress routers = InetAddress.getByName(jfSubnet.getTextFieldGateway().getText());
			InetAddress ntpServer = InetAddress.getByName(jfSubnet.getTextFieldNTP().getText());
			InetAddress netbiosNameServer = InetAddress.getByName(jfSubnet.getTextFieldNetBios().getText());
			ArrayList<InetAddress> range = new ArrayList<InetAddress>();
			range.add(InetAddress.getByName(jfSubnet.getTextFieldRange1().getText()));
			range.add(InetAddress.getByName(jfSubnet.getTextFieldRange2().getText()));
			boolean pool = jfSubnet.getChckbxRangeActive().isEnabled();
			int defaultLeaseTime = 1000;
			int maxLeaseTime = 1000;

			// Creamos la red
			SubNet subnet = new SubNet(net, netmask, comment, optionDomainNameServer, routers, ntpServer,
					netbiosNameServer, range, pool, defaultLeaseTime, maxLeaseTime);

			// Añadimos la red
			conf.addSubNet(subnet);

			JOptionPane.showMessageDialog(jfSubnet, "Se ha añadido la red correctamente.", "Info",
					JOptionPane.INFORMATION_MESSAGE);

			actualizarVistas();
			jfSubnet.dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(jfSubnet, "Se ha producido un error inesperado", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void addNet() {

		jfSubnet = new JFSubnet();
		jfSubnet.getBtnAccion().setText("Add");
		jfSubnet.getBtnAccion().addActionListener(this);
		jfSubnet.getBtnAccion().setActionCommand("Add new net");
		jfSubnet.setVisible(true);
		principal.getDesktop().add(jfSubnet);

	}

	private void actualizarRed() {

		try {

			// Completar todas las modificaciones
			subnet.setNet(InetAddress.getByName(jfSubnet.getTextFieldSubnet().getText()));
			subnet.setNetmask(InetAddress.getByName(jfSubnet.getTextFieldMascara().getText()));
			subnet.getOptionDomainNameServer().set(0, InetAddress.getByName(jfSubnet.getTextFieldDNS1().getText()));
			subnet.getOptionDomainNameServer().set(1, InetAddress.getByName(jfSubnet.getTextFieldDNS2().getText()));
			subnet.setRouters(InetAddress.getByName(jfSubnet.getTextFieldGateway().getText()));
			subnet.setNtpServer(InetAddress.getByName(jfSubnet.getTextFieldNTP().getText()));
			subnet.setNetbiosNameServer(InetAddress.getByName(jfSubnet.getTextFieldNetBios().getText()));
			subnet.getRange().set(0, InetAddress.getByName(jfSubnet.getTextFieldRange1().getText()));
			subnet.getRange().set(1, InetAddress.getByName(jfSubnet.getTextFieldRange2().getText()));
			subnet.setPool(jfSubnet.getChckbxRangeActive().isSelected());

			jfSubnet.dispose();
			actualizarVistas();

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(jfSubnet, "Hay alguna direccion de red incorrecta", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void removeNet() {

		int row = view.getTableNets().getSelectedRow();
		int column = 1;

		String hostAddress = view.getTableNets().getValueAt(row, column).toString();

		try {

			System.out.println(hostAddress);

			conf.eliminarRed(InetAddress.getByName(hostAddress));

			actualizarVistas();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	private void editNet() {

		if (view.getTableNets().getSelectedRow() == -1)
			JOptionPane.showMessageDialog(view, "Debes seleccionar primero una red en la tabla", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		else {
			int row = view.getTableNets().getSelectedRow();
			int column = 1;
			try {
				subnet = null;

				InetAddress net = InetAddress.getByName(view.getTableNets().getValueAt(row, column).toString());

				subnet = conf.getSubNet(net);

				if (subnet != null) {

					jfSubnet = new JFSubnet();
					principal.getDesktop().add(jfSubnet);
					jfSubnet.setVisible(true);

					// Rellenamos el frame
					jfSubnet.getTextFieldSubnet().setText(subnet.getNet().getHostAddress());
					jfSubnet.getTextFieldMascara().setText(subnet.getNetmask().getHostAddress());
					jfSubnet.getTextFieldDNS1().setText(subnet.getOptionDomainNameServer().get(0).getHostAddress());
					jfSubnet.getTextFieldDNS2().setText(subnet.getOptionDomainNameServer().get(1).getHostAddress());
					jfSubnet.getTextFieldGateway().setText(subnet.getRouters().getHostAddress());
					jfSubnet.getTextFieldNTP().setText(subnet.getNtpServer().getHostAddress());
					jfSubnet.getTextFieldRange1().setText(subnet.getRange().get(0).getHostAddress());
					jfSubnet.getTextFieldRange2().setText(subnet.getRange().get(1).getHostAddress());
					jfSubnet.getChckbxRangeActive().setSelected(subnet.isPool());
					jfSubnet.getTextFieldNetBios().setText(subnet.getNetbiosNameServer().getHostAddress());

					// Establecer acciones y texto de botones
					jfSubnet.getBtnAccion().setText("Actualizar");
					jfSubnet.getBtnAccion().addActionListener(this);
					jfSubnet.getBtnAccion().setActionCommand("Actualizar Red");

				} else {
					JOptionPane.showMessageDialog(view, "No existe ninguna red con esa direccion", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}

	}

	private void openFile() {

		JFileChooser jfc = new JFileChooser();

		int option = jfc.showOpenDialog(view);

		if (option == JFileChooser.APPROVE_OPTION) {

			conf = model.cargarConfiguracion(jfc.getSelectedFile());
			actualizarVistas();

		}

		System.out.println(conf);
	}

	private void actualizarVistas() {

		System.out.println("daflj");

		view.getTextPaneGlobal().setText(conf.getGlobal());
		view.getTextPaneInfo().setText(conf.getInfo());

		// Actualizar tabla redes
		DefaultTableModel dtm = new DefaultTableModel();

		dtm.addColumn("Descripcion");
		dtm.addColumn("Netword adress");
		dtm.addColumn("Masc");
		dtm.addColumn("Router");
		dtm.addColumn("Pool");

		ArrayList<SubNet> redes = new ArrayList<SubNet>(conf.getRedes());

		for (SubNet red : redes) {
			dtm.addRow(
					new String[] { red.getComment(), red.getNet().getHostAddress(), red.getNetmask().getHostAddress(),
							red.getRouters().getHostAddress(), String.valueOf(red.isPool()) });
		}

		view.getTableNets().setModel(dtm);

		// Actualizar ComboBox Redes
		DefaultComboBoxModel dcm = new DefaultComboBoxModel();
		for (SubNet red : redes) {
			dcm.addElement(red.getNet().getHostAddress());
		}

		view.getComboBox().setModel(dcm);
		
		actualizarComboBox();

	}

	private void actualizarComboBox() {
		if (view.getComboBox().getSelectedIndex() != -1) {

			try {
				InetAddress ip = InetAddress.getByName(view.getComboBox().getSelectedItem().toString());
				TreeSet<Host> hosts = conf.getHosts(ip);

				// Actualizar tabla host
				DefaultTableModel dtmh = new DefaultTableModel();

				dtmh.addColumn("Descripcion");
				dtmh.addColumn("Fixed address");
				dtmh.addColumn("MAC");
				dtmh.addColumn("Hostname");

				for (Host host : hosts) {
					dtmh.addRow(new String[] { host.getComment(), host.getFixedAddress().getHostName(),
							host.getHardwareEthernet(), host.getHost() });
				}

				view.getTableHosts().setModel(dtmh);

			} catch (Exception e) {

			}
		}
		
	}

}
