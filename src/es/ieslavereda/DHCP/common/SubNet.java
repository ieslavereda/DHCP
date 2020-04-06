package es.ieslavereda.DHCP.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.TreeSet;

public class SubNet {
	
	private InetAddress net;
	private InetAddress netmask;
	private String comment;
	private ArrayList<InetAddress> optionDomainNameServer;
	private InetAddress routers;
	private InetAddress ntpServer;
	private ArrayList<InetAddress> range;
	private boolean pool;
	private int defaultLeaseTime;
	private int maxLeaseTime;	
	private TreeSet<Host> hosts;
		
	public SubNet(InetAddress net, InetAddress netmask, String comment, ArrayList<InetAddress> optionDomainNameServer,
			InetAddress routers, InetAddress ntpServer, ArrayList<InetAddress> range, boolean pool,
			int defaultLeaseTime, int maxLeaseTime, TreeSet<Host> hosts) {
		super();
		this.net = net;
		this.netmask = netmask;
		this.comment = comment;
		this.optionDomainNameServer = optionDomainNameServer;
		this.routers = routers;
		this.ntpServer = ntpServer;
		this.range = range;
		this.pool = pool;
		this.defaultLeaseTime = defaultLeaseTime;
		this.maxLeaseTime = maxLeaseTime;
		this.hosts = hosts;
		
		hosts = new TreeSet<Host>();
	}




	@Override
	public String toString() {
		return "SubNet [subnet=" + net + ", netmask=" + netmask + ", comment=" + comment
				+ ", optionDomainNameServer=" + optionDomainNameServer + ", routers=" + routers + ", ntpServer="
				+ ntpServer + ", range=" + range + ", defaultLeaseTime=" + defaultLeaseTime + ", maxLeaseTime="
				+ maxLeaseTime + ", hosts=" + hosts + "]";
	}			
}
