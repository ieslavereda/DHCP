package es.ieslavereda.DHCP.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import es.ieslavereda.DHCP.common.SubNet;
import es.ieslavereda.DHCP.model.ConfiguracionDHCP;
import es.ieslavereda.DHCP.model.Model;
import es.ieslavereda.DHCP.view.JFSubnet;
import es.ieslavereda.DHCP.view.JIFDHCP;

public class ControladorJIFDHCP implements ActionListener{
	
	private JIFDHCP view;
	private Model model;
	private ConfiguracionDHCP conf;
	private SubNet subnet;
	private JFSubnet jfSubnet;
	
	public ControladorJIFDHCP(JIFDHCP view, Model model) {
		super();
		this.view = view;
		this.model = model;
		
		inicializar();
	}
	
	private void inicializar() {
		
		// Añadimos action listener
		view.getMntmOpen().addActionListener(this);
		view.getMntmSave().addActionListener(this);
		view.getBtnNetEdit().addActionListener(this);
		view.getBtnDelete().addActionListener(this);
		// añadir un action listener para el boton add
		
		
		// Añadimos action command
		view.getMntmOpen().setActionCommand("Open file");
		view.getMntmSave().setActionCommand("Save file");
		view.getBtnNetEdit().setActionCommand("Edit net");
		view.getBtnDelete().setActionCommand("Delete Net");
		// añadir un action command para el boton add
	}
	
	public void go() {
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String command = e.getActionCommand();
		
		if(command.equals("Open file")) {
			openFile();
		}else if(command.equals("Edit net")) {
			editNet();
		}else if(command.equals("Delete Net")) {
			removeNet();
		}else if(command.equals("Actualizar Red")) {
			actualizarRed();
		}
		// gestion del comando add
		
	}
	
	/*
	 * Crear el formulario de red en blanco
	 * Modificar el boton action
	 * Add action command 
	 * Add action listener
	 * Add subnet if needed
	 * update views
	 *  
	 */

	private void actualizarRed() {
	
		try {
			
			// Completar todas las modificaciones
			subnet.setNet(InetAddress.getByName(jfSubnet.getTextFieldSubnet().getText()));
			
			
			
			jfSubnet.dispose();
			actualizarVistas();		
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(jfSubnet, "Hay alguna direccion de red incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void editNet() {
		
		if(view.getTableNets().getSelectedRow()==-1)
			JOptionPane.showMessageDialog(view, "Debes seleccionar primero una red en la tabla", "Info", JOptionPane.INFORMATION_MESSAGE);
		else {
			int row = view.getTableNets().getSelectedRow();
			int column = 1;
			try {
				subnet = null;
				
				InetAddress net = InetAddress.getByName(view.getTableNets().getValueAt(row, column).toString());
				
				subnet = conf.getSubNet(net);
				
				if(subnet!=null) {
					
					jfSubnet = new JFSubnet();
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
					
				}else {
					JOptionPane.showMessageDialog(view, "No existe ninguna red con esa direccion", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void openFile() {
		
		JFileChooser jfc = new JFileChooser();
		
		int option = jfc.showOpenDialog(view);
		
		if(option==JFileChooser.APPROVE_OPTION) {
			
			conf = model.cargarConfiguracion(jfc.getSelectedFile());
			actualizarVistas();
			
		}
		
		
	}

	private void actualizarVistas() {
		
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
		
		for(SubNet red : redes) {
			dtm.addRow(new String[] {
					red.getComment(),
					red.getNet().getHostAddress(),
					red.getNetmask().getHostAddress(),
					red.getRouters().getHostAddress(),
					String.valueOf(red.isPool())
			});
		}
		
		view.getTableNets().setModel(dtm);
			
	}
	
	

}
