package es.ieslavereda.DHCP.common;

import java.net.InetAddress;
import java.util.ArrayList;

public class Host implements Comparable<Host> {
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

	public String getHost() {
		return host;
	}

	public String getComment() {
		return comment;
	}

	public InetAddress getFixedAddress() {
		return fixedAddress;
	}

	public String getHardwareEthernet() {
		return hardwareEthernet;
	}

	public InetAddress getRouters() {
		return routers;
	}

	public ArrayList<InetAddress> getDomainNameServers() {
		return domainNameServers;
	}
	
	public int compareTo(Host h) {
		
		// 192.168.1.1  -> [192][168][1][1]
		// 192.168.10.1 -> [192][168][10][1]
		String[] ip1 = fixedAddress.getHostAddress().split("\\.");
		String[] ip2 = h.getFixedAddress().getHostAddress().split("\\.");

		int[] ipH1 = new int[] { Integer.parseInt(ip1[0]), Integer.parseInt(ip1[1]), Integer.parseInt(ip1[2]),
				Integer.parseInt(ip1[3]) };
		int[] ipH2 = new int[] { Integer.parseInt(ip2[0]), Integer.parseInt(ip2[1]), Integer.parseInt(ip2[2]),
				Integer.parseInt(ip2[3]) };
		if (ipH1[0] - ipH2[0] != 0)
			return ipH1[0] - ipH2[0];
		else if (ipH1[1] - ipH2[1] != 0)
			return ipH1[1] - ipH2[1];
		else if (ipH1[2] - ipH2[2] != 0)
			return ipH1[2] - ipH2[3];
		else
			return ipH1[3] - ipH2[3];

	}

	@Override
	public String toString() {
		return "Host [host=" + host + ", comment=" + comment + ", fixedAddress=" + fixedAddress + ", hardwareEthernet="
				+ hardwareEthernet + ", routers=" + routers + ", domainNameServers=" + domainNameServers + "]";
	}


		
	
}
