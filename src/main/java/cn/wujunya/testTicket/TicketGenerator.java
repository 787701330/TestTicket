package cn.wujunya.testTicket;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TicketGenerator implements Runnable{
	
	private Server server;
	private static Log log=LogFactory.getLog(TicketGenerator.class);
	
	public synchronized void add(int type) {
		int result;
		int id;
		if(type==1) {
			result=server.getOrdinarySize();
			server.add_ordinary();
			id=server.getTotal();
			log.info("您的号码牌是普通"+id+",您前面还有"+result+"个顾客！");
		}else if(type==2){
			result=server.getFastSize();
			server.add_fast();
			id=server.getTotal();
			log.info("您的号码牌是快速"+id+",您前面还有"+result+"个顾客！");
		}else {
			result=server.getVIPSize();
			server.add_vip();
			id=server.getTotal();
			log.info("您的号码牌是VIP"+id+",您前面还有"+result+"个顾客！");
		}
	}
	
	public void add_random() {
		int random=new Random().nextInt(10);
		if(random<6) {
			add(1);
		}else if(random<9){
			add(2);
		}else {
			add(3);
		}
		
	}
	
	public void run() {
		for(int i=0; i<10;i++) {
			add_random();
		}
		while(true) {
			add_random();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
	
}
