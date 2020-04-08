package cn.wujunya.testTicket;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Counter implements Runnable{
	private long id;
	private int type;
	private Server server;
	private static Log log=LogFactory.getLog(Counter.class);
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	public Counter(int type,Server server) {
		super();
		this.server = server;
		this.type=type;
	}
	
	public void run() {
		while(true) {
			if(type==1) {
				int result=server.moveOrdinary();
				if(result!=0) {
					log.info(id+"柜台开始处理"+result+"号顾客！");
					int random=new Random().nextInt(3)+7;
					try {
						Thread.sleep(random*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info(id+"柜台处理完"+result+"号顾客！");
				}else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(type==2) {
				int result=server.moveFast();
				if(result!=0) {
					log.info(id+"柜台开始处理"+result+"号顾客！");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info(id+"柜台处理完"+result+"号顾客！");
				}else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(type==3) {
				int result=server.moveVIP();
				if(result!=0) {
					log.info(id+"柜台开始处理"+result+"号顾客！");
					int random=new Random().nextInt(3)+4;
					try {
						Thread.sleep(random*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info(id+"柜台处理完"+result+"号顾客！");
				}else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	} 
	
	
}
