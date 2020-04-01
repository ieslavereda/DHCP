package es.ieslavereda.DHCP.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class Model {

	private Properties properties;
	private ConfiguracionDHCP dhcp;

	private String FILE = "app.properties";

	public Model() {

		properties = new Properties();

		// cargar datos de Properties
		obtenerProperties(FILE);
	}

	public boolean comprobarLogin(String login, String passwd) {

		return properties.getProperty("login").equals(login) && properties.getProperty("passwd").equals(passwd);
	}

	public void obtenerProperties(String FILE) {

		InetAddress IP = null;
		Integer port = null;
		String login;
		String passwd;

		// Cargamos valores desde fichero
		try {
			properties.load(new FileInputStream(FILE));
			IP = InetAddress.getByName(properties.getProperty("IP"));
			port = Integer.parseInt(properties.getProperty("port"));
			login = properties.getProperty("login");
			passwd = properties.getProperty("passwd");

		} catch (Exception e) {
			// Se ejecuta si el fichero no existe o alguna propiedad es null
		}

		// Mostramos los datos del fichero si existiera
		if (IP == null) {
			System.out.println("No existe el fichero.");
			try {
				IP = InetAddress.getByName("127.0.0.1");
			} catch (UnknownHostException e) {
			}
			port = 5555;
			login = "admin";
			passwd = "admin";
			
			saveProperties(login,passwd,IP,port);

		}
	}

	public String getLogin() {
		return properties.getProperty("login");
	}

	public String getPassword() {
		return properties.getProperty("passwd");
	}

	public String getIP() {
		return properties.getProperty("IP");
	}

	public String getPort() {
		return properties.getProperty("port");
	}

	public boolean saveProperties(String login, String passwd, InetAddress IP, int port) {

		boolean save = false;

		// Guardamos las propiedades en un fichero
		try {
			properties.setProperty("login", login);
			properties.setProperty("passwd", passwd);
			properties.setProperty("IP", IP.getHostAddress());
			properties.setProperty("port", String.valueOf(port));

			properties.store(new FileOutputStream(FILE), "Propiedades de mi aplicacion");
			save=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}
		
	public ConfiguracionDHCP cargarConfiguracion(File file) {
		return new ConfiguracionDHCP();
	}
	
	
	

}
