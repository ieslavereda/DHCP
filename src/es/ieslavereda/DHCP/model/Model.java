package es.ieslavereda.DHCP.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import es.ieslavereda.DHCP.common.SubNet;

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

			saveProperties(login, passwd, IP, port);

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
			save = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

	public ConfiguracionDHCP cargarConfiguracion(File file) {

		dhcp = new ConfiguracionDHCP();

		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(file));

			String linea = "";
			while ((linea = br.readLine()) != null) {
				linea = linea.replace("  ", " ").trim();

				if (linea.contains("# Configuracion global")) {
					cargarGlobal(br);
				} else if (linea.contains("# Informacion")) {
					cargarInfo(br);
				} else if (linea.contains("subnet")) {
					cargarRed(br, linea);
				}

			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return dhcp;
	}

	private void cargarRed(BufferedReader br, String linea) {

		try {

			InetAddress net = InetAddress.getByName(linea.split(" ")[1]);
			InetAddress netmask = InetAddress.getByName(linea.split(" ")[3]);
			String comment = "";
			ArrayList<InetAddress> optionDomainNameServer = new ArrayList<InetAddress>();
			InetAddress routers = null;
			ArrayList<InetAddress> range = new ArrayList<InetAddress>();
			boolean pool = false;

			while ((linea = br.readLine()) != null && !linea.contains("}")) {
				linea = linea.replace("  ", " ").replaceAll(";","").replaceAll(",", "").trim();

				if (linea.contains("option domain-name-servers")) {
					optionDomainNameServer.add(InetAddress.getByName(linea.split(" ")[2]));
					optionDomainNameServer.add(InetAddress.getByName(linea.split(" ")[3]));					
				} else if (linea.contains("option routers")) {
					routers = InetAddress.getByName(linea.split(" ")[2]);
				} else if (linea.contains("option ntp-servers")) {
					//
				} else if (linea.contains("option netbios-name-servers")) {
					//
				} else if (linea.contains("range ")) {
					pool = (linea.contains("#"))?false:true;
					linea = linea.replaceAll("#", "").trim();
					range.add(InetAddress.getByName(linea.split(" ")[1]));
					range.add(InetAddress.getByName(linea.split(" ")[2]));
				} else if (linea.contains("default-lease-time")) {
					//
				} else if (linea.contains("max-lease-time")) {
					//
				} else if (linea.contains("##")) {
					comment+=linea.replaceAll("##",	"").trim();
				}

			}

			//SubNet subnet = new SubNet(net, netmask, comment, optionDomainNameServer, routers, ntpServer, range, pool, defaultLeaseTime, maxLeaseTime);
			SubNet subnet = new SubNet(net, netmask, comment, optionDomainNameServer,routers, range, pool);

			dhcp.addSubNet(subnet);

			System.out.println(subnet);
			

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void cargarGlobal(BufferedReader br) throws IOException {
		String linea = "";

		while ((linea = br.readLine()) != null && !linea.contains("# Fin Configuracion global")) {
			dhcp.addLineToGlobal(linea);
		}
	}

	private void cargarInfo(BufferedReader br) throws IOException {

		String linea = "";

		while ((linea = br.readLine()) != null && !linea.contains("# Fin Informacion")) {
			linea = linea.replaceAll("#", "").trim();
			dhcp.addLineToInfo(linea);
		}

	}

}
