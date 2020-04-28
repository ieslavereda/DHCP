package es.ieslavereda.DHCP.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Dimension;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmExit;
	private JDesktopPane desktop;
	private JMenuItem mntmIniciarSesion;
	private JMenuItem mntmConfiguracion;
	private JMenuItem mntmDHCP;
	private JMenuItem mntmCerrarSesion;


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
		
		mntmIniciarSesion = new JMenuItem("Iniciar sesion");
		mnNewMenu.add(mntmIniciarSesion);
		mntmIniciarSesion.setIcon(null);
		mntmIniciarSesion.setSelectedIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/sesion40.png")));
		mntmIniciarSesion.setMaximumSize(new Dimension(1009, 50));
		mntmIniciarSesion.setPreferredSize(new Dimension(91, 30));
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.setEnabled(false);
		mnNewMenu.add(mntmCerrarSesion);
		
		mntmConfiguracion = new JMenuItem("Configuracion");
		mntmConfiguracion.setEnabled(false);
		mntmConfiguracion.setIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/settings40.png")));
		mntmConfiguracion.setMaximumSize(new Dimension(140, 100));
		menuBar.add(mntmConfiguracion);
		
		mntmDHCP = new JMenuItem("DHCP");
		mntmDHCP.setIcon(new ImageIcon(Principal.class.getResource("/es/ieslavereda/DHCP/images/dhcp40.png")));
		mntmDHCP.setMaximumSize(new Dimension(100, 100));
		menuBar.add(mntmDHCP);
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
		return mntmIniciarSesion;
	}

	public JMenuItem getMntmConfiguracion() {
		return mntmConfiguracion;
	}

	public JMenuItem getMntmDHCP() {
		return mntmDHCP;
	}


	public JMenuItem getMntmIniciarSesion() {
		return mntmIniciarSesion;
	}


	public JMenuItem getMntmCerrarSesion() {
		return mntmCerrarSesion;
	}
	
}
