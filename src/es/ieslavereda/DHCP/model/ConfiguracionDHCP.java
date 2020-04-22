package es.ieslavereda.DHCP.model;

import java.net.InetAddress;
import java.util.Iterator;
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
	
	public void eliminarRed(InetAddress red) {
		
		Iterator<SubNet> it = redes.iterator();
		SubNet subnet;
		
		while(it.hasNext()) {			
			subnet = it.next();			
			if(subnet.getNet().getHostAddress().equals(red.getHostAddress()))
				it.remove();
		}
				
	}
	
	public SubNet getSubNetByNetworkAddress(InetAddress address) {
		
		SubNet net =  null;
		
		for(SubNet s : redes)
			if(s.getNet().getHostAddress().equals(address.getHostAddress()))
				net=s;
	
		return net;		
	}
	
	public String toString() {
		String salida = "";
		salida+="# Configuracion global" + "\n";
		salida+=global;
		salida+="# Fin Configuracion global" + "\n\n";
		salida+="# Informacion";
		salida+="";
		salida+="# Fin Informacion";
		
		for(SubNet subnet : redes) {
			salida+=subnet;
		}
				
		return salida;		
	}


}
