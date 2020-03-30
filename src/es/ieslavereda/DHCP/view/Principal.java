package es.ieslavereda.DHCP.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Dimension;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmExit;
	private JDesktopPane desktop;
	private JMenuItem mntmSesion;
	private JMenuItem mntmConfiguracion;


	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/file40.png")));
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/exit40.png")));
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Sesion");
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/sesion40.png")));
		menuBar.add(mnNewMenu);
		
		mntmSesion = new JMenuItem("Iniciar sesion");
		mnNewMenu.add(mntmSesion);
		mntmSesion.setIcon(null);
		mntmSesion.setSelectedIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/sesion40.png")));
		mntmSesion.setMaximumSize(new Dimension(91, 50));
		mntmSesion.setPreferredSize(new Dimension(91, 30));
		
		mntmConfiguracion = new JMenuItem("Configuracion");
		mntmConfiguracion.setMaximumSize(new Dimension(120, 100));
		menuBar.add(mntmConfiguracion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktop = new JDesktopPane();
		contentPane.add(desktop, BorderLayout.CENTER);
	}


	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	public JDesktopPane getDesktop() {
		return desktop;
	}

	public JMenuItem getMntmSesion() {
		return mntmSesion;
	}

	public JMenuItem getMntmConfiguracion() {
		return mntmConfiguracion;
	}
}
