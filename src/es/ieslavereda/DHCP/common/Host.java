package es.ieslavereda.DHCP.common;

import java.net.InetAddress;
import java.util.ArrayList;

public class Host {
	private String host;
	private String comment;
	private InetAddress fixedAddress;
	private String hardwareEthernet;
	private InetAddress routers;
	private ArrayList<InetAddress> domainNameServers;
	
	public Host(String host, String comment, InetAddress fixedAddress, String hardwareEthernet, InetAddress routers,
			ArrayList<InetAddress> domainNameServers) {
		super();
		this.host = host;
		this.comment = comment;
		this.fixedAddress = fixedAddress;
		this.hardwareEthernet = hardwareEthernet;
		this.routers = routers;
		this.domainNameServers = domainNameServers;
	}
		
	
}
