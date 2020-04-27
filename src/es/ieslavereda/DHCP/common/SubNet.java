package es.ieslavereda.DHCP.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.commons.net.util.SubnetUtils;

public class SubNet implements Comparable{

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
		return "subnet " + net.getHostAddress() + " netmask " + netmask.getHostAddress() + " {" + "\n" +
				"## " + comment + "\n" +
				"  option domain-name-servers " + optionDomainNameServer.get(0).getHostAddress()+ ", "+optionDomainNameServer.get(1).getHostAddress()+ ";" + "\n"+
				"  option routers " + routers.getHostAddress() + ";" + "\n" +
				"  option ntp-servers " + ntpServer.getHostAddress()+";"+"\n"+
				"  option netbios-name-servers " + netbiosNameServer.getHostAddress() + ";" + "\n"+
				((pool)?"":"#")+"  range " + range.get(0).getHostAddress() +  " "+range.get(1).getHostAddress()+";"+  "\n"+
				  "  default-lease-time " + defaultLeaseTime +";"+"\n"+
				  "  max-lease-time " + maxLeaseTime +";"+"\n"+
				"}" + "\n" + hosts;
	}

	
	
	@Override
	public int compareTo(Object o) {
		
		SubNet s = (SubNet) o;
		
		return net.getHostAddress().compareTo(s.net.getHostAddress());
	}

}
