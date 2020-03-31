package es.ieslavereda.DHCP.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class JIFDHCP extends JInternalFrame {
	private JTextField textFieldPort;
	private JTextField textFieldIP;
	private JTable tableNets;
	private JTable tableHosts;


	/**
	 * Create the frame.
	 */
	public JIFDHCP() {
		setTitle("DHCP");
		setBounds(100, 100, 910, 558);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelServer = new JPanel();
		tabbedPane.addTab("Server", null, panelServer, null);
		
		JPanel panelIPPort = new JPanel();
		
		JPanel panelInfo = new JPanel();
		
		JPanel panelBotonesServidor = new JPanel();
		GroupLayout gl_panelServer = new GroupLayout(panelServer);
		gl_panelServer.setHorizontalGroup(
			gl_panelServer.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelServer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelServer.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBotonesServidor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panelInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panelIPPort, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelServer.setVerticalGroup(
			gl_panelServer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelServer.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelIPPort, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelBotonesServidor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBotonesServidor.setLayout(new MigLayout("", "[][][grow][][][]", "[]"));
		
		JButton btnDownloadConf = new JButton("Download .conf");
		panelBotonesServidor.add(btnDownloadConf, "cell 0 0");
		
		JButton btnUploadConf = new JButton("Upload .conf");
		panelBotonesServidor.add(btnUploadConf, "cell 1 0");
		
		JButton btnJournal = new JButton("Journal");
		panelBotonesServidor.add(btnJournal, "cell 3 0");
		
		JButton btnStatus = new JButton("Status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBotonesServidor.add(btnStatus, "cell 4 0");
		
		JButton btnRestart = new JButton("Restart");
		panelBotonesServidor.add(btnRestart, "cell 5 0");
		panelInfo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelInfo.add(scrollPane_2, BorderLayout.CENTER);
		
		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		panelIPPort.setLayout(new MigLayout("", "[][188.00][80.00][]", "[]"));
		
		JLabel lblIp = new JLabel("IP Servidor");
		panelIPPort.add(lblIp, "cell 0 0,alignx trailing");
		
		textFieldIP = new JTextField();
		panelIPPort.add(textFieldIP, "cell 1 0,growx");
		textFieldIP.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		panelIPPort.add(lblPort, "cell 2 0,alignx trailing");
		
		textFieldPort = new JTextField();
		panelIPPort.add(textFieldPort, "cell 3 0,growx");
		textFieldPort.setColumns(10);
		panelServer.setLayout(gl_panelServer);
		
		JPanel panelGlobal = new JPanel();
		tabbedPane.addTab("Global", null, panelGlobal, null);
		
		JPanel panelSuperior = new JPanel();
		
		JPanel panelInferior = new JPanel();
		
		JPanel panelBotones = new JPanel();
		GroupLayout gl_panelGlobal = new GroupLayout(panelGlobal);
		gl_panelGlobal.setHorizontalGroup(
			gl_panelGlobal.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelGlobal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGlobal.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelSuperior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panelBotones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panelInferior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelGlobal.setVerticalGroup(
			gl_panelGlobal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGlobal.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelBotones, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnSave = new JButton("Save");
		panelBotones.add(btnSave);
		
		JButton btnCancelar = new JButton("Cancel");
		panelBotones.add(btnCancelar);
		
		JLabel lblInfo = new JLabel("Info");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelInferior = new GroupLayout(panelInferior);
		gl_panelInferior.setHorizontalGroup(
			gl_panelInferior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInferior.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo)
					.addContainerGap(839, Short.MAX_VALUE))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
		);
		gl_panelInferior.setVerticalGroup(
			gl_panelInferior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInferior.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
		);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		panelInferior.setLayout(gl_panelInferior);
		
		JLabel lblConfiguracionGlobal = new JLabel("Global");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConfiguracionGlobal)
					.addContainerGap(828, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
		);
		gl_panelSuperior.setVerticalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConfiguracionGlobal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
		);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		panelSuperior.setLayout(gl_panelSuperior);
		panelGlobal.setLayout(gl_panelGlobal);
		
		JPanel panelNets = new JPanel();
		tabbedPane.addTab("Nets", null, panelNets, null);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panelNets = new GroupLayout(panelNets);
		gl_panelNets.setHorizontalGroup(
			gl_panelNets.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelNets.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelNets.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelNets.setVerticalGroup(
			gl_panelNets.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNets.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnRefresh = new JButton("Refresh");
		panel_3.add(btnRefresh);
		
		JButton btnDelete = new JButton("Delete");
		panel_3.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		panel_3.add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		panel_3.add(btnAdd);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_2.add(scrollPane_3, BorderLayout.NORTH);
		
		tableNets = new JTable();
		tableNets.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Descripcion","Netword adress", "Masc", "Router",  "Pool"
			}
		));
		scrollPane_3.setViewportView(tableNets);
		panelNets.setLayout(gl_panelNets);
		
		JPanel panelHosts = new JPanel();
		tabbedPane.addTab("Hosts", null, panelHosts, null);
		
		JPanel panelHostSuperior = new JPanel();
		
		JPanel panelHostsMedio = new JPanel();
		
		JPanel panelHostBotones = new JPanel();
		GroupLayout gl_panelHosts = new GroupLayout(panelHosts);
		gl_panelHosts.setHorizontalGroup(
			gl_panelHosts.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelHosts.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelHosts.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelHostsMedio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panelHostSuperior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
						.addComponent(panelHostBotones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelHosts.setVerticalGroup(
			gl_panelHosts.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHosts.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelHostSuperior, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelHostsMedio, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelHostBotones, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelHostBotones.setLayout(new MigLayout("", "[][38.00][grow][][][]", "[]"));
		
		JLabel lblHostsEnLa = new JLabel("Hosts en la red seleccionada:");
		panelHostBotones.add(lblHostsEnLa, "cell 0 0");
		
		JLabel label = new JLabel("0");
		panelHostBotones.add(label, "cell 1 0,alignx center");
		
		JButton btnDelete_1 = new JButton("Delete");
		panelHostBotones.add(btnDelete_1, "cell 3 0");
		
		JButton btnEdit_1 = new JButton("Edit");
		panelHostBotones.add(btnEdit_1, "cell 4 0");
		
		JButton btnHostsCancel = new JButton("Cancel");
		panelHostBotones.add(btnHostsCancel, "cell 5 0");
		panelHostSuperior.setLayout(new MigLayout("", "[248.00][][grow][]", "[]"));
		
		JComboBox comboBox = new JComboBox();
		panelHostSuperior.add(comboBox, "cell 0 0,growx");
		
		JButton btnRefresh_1 = new JButton("Refresh");
		panelHostSuperior.add(btnRefresh_1, "cell 1 0");
		
		JButton btnFreeIPs = new JButton("Free IPs");
		panelHostSuperior.add(btnFreeIPs, "cell 3 0,growy");
		panelHostsMedio.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panelHostsMedio.add(scrollPane_4, BorderLayout.CENTER);
		
		tableHosts = new JTable();
		tableHosts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descripcion", "Fixed Address","MAC", "Hostname"
			}
		));
		scrollPane_4.setViewportView(tableHosts);
		panelHosts.setLayout(gl_panelHosts);

	}
}
