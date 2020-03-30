package es.ieslavereda.DHCP.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class JIFDHCP extends JInternalFrame {


	/**
	 * Create the frame.
	 */
	public JIFDHCP() {
		setBounds(100, 100, 910, 558);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Global", null, panel_1, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Server", null, panel, null);

	}

}
