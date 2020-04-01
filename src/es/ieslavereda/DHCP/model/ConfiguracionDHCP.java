package es.ieslavereda.DHCP.model;

public class ConfiguracionDHCP {

	private String global;
	private String info;
	// redes

	public ConfiguracionDHCP() {
		super();
		global = "";
		info = "";
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
	
	

}
