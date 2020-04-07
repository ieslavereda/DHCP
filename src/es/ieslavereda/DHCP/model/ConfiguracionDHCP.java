package es.ieslavereda.DHCP.model;

import java.util.TreeSet;

import es.ieslavereda.DHCP.common.SubNet;

public class ConfiguracionDHCP {

	private String global;
	private String info;
	private TreeSet<SubNet> redes;
	
	public ConfiguracionDHCP() {
		super();
		global = "";
		info = "";
		redes = new TreeSet<SubNet>();
	}

	public void addLineToInfo(String line) {
		info += line + "\n";
	}

	public void addLineToGlobal(String line) {
		global += line + "\n";
	}

	public String getGlobal() {
		return global;
	}

	public String getInfo() {
		return info;
	}
	
	public TreeSet<SubNet> getRedes() {
		return redes;
	}

	public boolean addSubNet(SubNet net) {
		return redes.add(net);
	}

}
