package es.ieslavereda.DHCP.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.commons.net.util.SubnetUtils;

public class SubNet implements Comparable<SubNet> {

	private InetAddress net;
	private InetAddress netmask;
	private String comment;
	private ArrayList<InetAddress> optionDomainNameServer;
	private InetAddress routers;
	private InetAddress ntpServer;
	private InetAddress netbiosNameServer;
	private ArrayList<InetAddress> range;
	private boolean pool;
	private int defaultLeaseTime;
	private int maxLeaseTime;
	private TreeSet<Host> hosts;

	public SubNet(InetAddress net, InetAddress netmask, String comment, ArrayList<InetAddress> optionDomainNameServer,
			InetAddress routers, InetAddress ntpServer, InetAddress netbiosNameServer, ArrayList<InetAddress> range,
			boolean pool, int defaultLeaseTime, int maxLeaseTime) {
		super();
		this.net = net;
		this.netmask = netmask;
		this.comment = comment;
		this.optionDomainNameServer = optionDomainNameServer;
		this.routers = routers;
		this.ntpServer = ntpServer;
		this.netbiosNameServer = netbiosNameServer;
		this.range = range;
		this.pool = pool;
		this.defaultLeaseTime = defaultLeaseTime;
		this.maxLeaseTime = maxLeaseTime;

		hosts = new TreeSet<Host>();
	}

	public void addHost(Host host) {
		hosts.add(host);
	}

	public boolean isIpInSubnet(String ip) {
		SubnetUtils utils = new SubnetUtils(net.getHostAddress(), netmask.getHostName());
		return utils.getInfo().isInRange(ip);
	}

	public InetAddress getNetbiosNameServer() {
		return netbiosNameServer;
	}

	public InetAddress getNet() {
		return net;
	}

	public InetAddress getNetmask() {
		return netmask;
	}

	public String getComment() {
		return comment;
	}

	public ArrayList<InetAddress> getOptionDomainNameServer() {
		return optionDomainNameServer;
	}

	public InetAddress getRouters() {
		return routers;
	}

	public InetAddress getNtpServer() {
		return ntpServer;
	}

	public ArrayList<InetAddress> getRange() {
		return range;
	}

	public boolean isPool() {
		return pool;
	}

	public int getDefaultLeaseTime() {
		return defaultLeaseTime;
	}

	public int getMaxLeaseTime() {
		return maxLeaseTime;
	}

	public TreeSet<Host> getHosts() {
		return hosts;
	}

	public void setNet(InetAddress net) {
		this.net = net;
	}

	public void setNetmask(InetAddress netmask) {
		this.netmask = netmask;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setOptionDomainNameServer(ArrayList<InetAddress> optionDomainNameServer) {
		this.optionDomainNameServer = optionDomainNameServer;
	}

	public void setRouters(InetAddress routers) {
		this.routers = routers;
	}

	public void setNtpServer(InetAddress ntpServer) {
		this.ntpServer = ntpServer;
	}

	public void setNetbiosNameServer(InetAddress netbiosNameServer) {
		this.netbiosNameServer = netbiosNameServer;
	}

	public void setRange(ArrayList<InetAddress> range) {
		this.range = range;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public void setDefaultLeaseTime(int defaultLeaseTime) {
		this.defaultLeaseTime = defaultLeaseTime;
	}

	public void setMaxLeaseTime(int maxLeaseTime) {
		this.maxLeaseTime = maxLeaseTime;
	}

	public void setHosts(TreeSet<Host> hosts) {
		this.hosts = hosts;
	}

	@Override
	public String toString() {

		return "# " + comment + "\n" + "subnet " + net.getHostAddress() + " netmask " + netmask.getHostAddress() + " {"
				+ "\n" + "  option domain-name-servers " + optionDomainNameServer.get(0).getHostAddress() + ", "
				+ optionDomainNameServer.get(1).getHostAddress() + ";" + "\n" + "  option routers "
				+ routers.getHostAddress() + ";" + "\n" + "  option ntp-servers " + ntpServer.getHostAddress() + ";"
				+ "\n" + "  option netbios-name-servers " + netbiosNameServer.getHostAddress() + ";" + "\n"
				+ ((pool) ? "" : "#") + "  range " + range.get(0).getHostAddress() + " " + range.get(1).getHostAddress()
				+ ";" + "\n" + "  default-lease-time " + defaultLeaseTime + ";" + "\n" + "  max-lease-time "
				+ maxLeaseTime + ";" + "\n" + "}" + "\n" + "\n";

	}
	public int compareTo(SubNet subnet) {

		// 192.168.1.1 -> [192][168][1][1]
		// 192.168.10.1 -> [192][168][10][1]
		String[] ip1 = net.getHostAddress().split("\\.");
		String[] ip2 = subnet.getNet().getHostAddress().split("\\.");

		int[] ipH1 = new int[] { Integer.parseInt(ip1[0]), Integer.parseInt(ip1[1]), Integer.parseInt(ip1[2]),
				Integer.parseInt(ip1[3]) };
		int[] ipH2 = new int[] { Integer.parseInt(ip2[0]), Integer.parseInt(ip2[1]), Integer.parseInt(ip2[2]),
				Integer.parseInt(ip2[3]) };
		if (ipH1[0] - ipH2[0] != 0)
			return ipH1[0] - ipH2[0];
		else if (ipH1[1] - ipH2[1] != 0)
			return ipH1[1] - ipH2[1];
		else if (ipH1[2] - ipH2[2] != 0)
			return ipH1[2] - ipH2[2];
		else
			return ipH1[3] - ipH2[3];

	}
	public boolean existHost(InetAddress ip) {
		return hosts.contains(new Host(ip));
	}


}
