package es.ieslavereda.DHCP.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import es.ieslavereda.DHCP.common.SubNet;
import es.ieslavereda.DHCP.model.ConfiguracionDHCP;
import es.ieslavereda.DHCP.model.Model;
import es.ieslavereda.DHCP.view.JIFDHCP;

public class ControladorJIFDHCP implements ActionListener{
	
	private JIFDHCP view;
	private Model model;
	private ConfiguracionDHCP conf;
	
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
		
		// Añadimos action command
		view.getMntmOpen().setActionCommand("Open file");
		view.getMntmSave().setActionCommand("Save file");
		
	}
	
	public void go() {
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String command = e.getActionCommand();
		
		if(command.equals("Open file")) {
			openFile();
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
		DefaultTableModel dtm = (DefaultTableModel)view.getTableNets().getModel();
		
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
		
		
		
	}
	
	

}
