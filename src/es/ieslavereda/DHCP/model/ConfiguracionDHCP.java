package es.ieslavereda.DHCP.model;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import es.ieslavereda.DHCP.common.Host;
import es.ieslavereda.DHCP.common.SubNet;

public class ConfiguracionDHCP {

	private String global;
	private ArrayList<String> info;
	private TreeSet<SubNet> redes;

	public ConfiguracionDHCP() {
		super();
		global = "";
		info = new ArrayList<String>();
		redes = new TreeSet<SubNet>();
	}

	public void addLineToInfo(String line) {
		info.add(line);
	}

	public void addLineToGlobal(String line) {
		global += line + "\n";
	}

	public String getGlobal() {
		return global;
	}

	public String getInfo() {
		String informacion = "";

		for (String line : info)
			informacion += line + "\n";

		return informacion;
	}

	public TreeSet<SubNet> getRedes() {
		return redes;
	}

	public boolean addSubNet(SubNet net) {
		return redes.add(net);
	}

	public SubNet getSubNet(InetAddress red) {

		SubNet subnet = null, aux = null;
		Iterator<SubNet> it = redes.iterator();

		while (it.hasNext() && subnet == null) {

			aux = it.next();
			if (aux.getNet().getHostAddress().equals(red.getHostAddress())) {
				subnet = aux;
			}
		}

		return subnet;
	}

	public void eliminarRed(InetAddress red) {

		Iterator<SubNet> it = redes.iterator();
		SubNet subnet;

		while (it.hasNext()) {
			subnet = it.next();
			if (subnet.getNet().getHostAddress().equals(red.getHostAddress()))
				it.remove();
		}

	}

//	public SubNet getSubNetByNetworkAddress(InetAddress address) {
//
//		SubNet net = null;
//
//		for (SubNet s : redes)
//			if (s.getNet().getHostAddress().equals(address.getHostAddress()))
//				net = s;
//
//		return net;
//	}

	public String toString() {
		String salida = "";
		salida += "# Configuracion global" + "\n";
		salida += global;
		salida += "# Fin Configuracion global" + "\n\n";
		salida += "# Informacion" + "\n";
		
		for (String line : info)
			salida += "# " + line + "\n";

		salida += "# Fin Informacion" + "\n\n";

		for (SubNet subnet : redes) {
			salida += subnet;
		}

		return salida;
	}

	public TreeSet<Host> getHosts(InetAddress ip) {

		Iterator<SubNet> it = redes.iterator();
		SubNet subnet;

		while (it.hasNext()) {
			subnet = it.next();
			if (subnet.getNet().getHostAddress().equals(ip.getHostAddress()))
				return subnet.getHosts();
		}

		return null;
	}

}
