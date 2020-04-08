package cn.wujunya.testTicket;

public class Test {
	public static void main(String[] args) {
		Server s1=new Server();
		TicketGenerator ticketGenerator=new TicketGenerator();
		ticketGenerator.setServer(s1);
		Counter counter1=new Counter(1, s1);
		counter1.setId(1);
		Counter counter2=new Counter(1, s1);
		counter2.setId(2);
		Counter counter3=new Counter(1, s1);
		counter3.setId(3);
		Counter counter4=new Counter(1, s1);
		counter4.setId(4);
		Counter counter5=new Counter(2, s1);
		counter5.setId(5);
		Counter counter6=new Counter(3, s1);
		counter6.setId(6);
		Thread generator=new Thread(ticketGenerator);
		Thread t1=new Thread(counter1);
		Thread t2=new Thread(counter2);
		Thread t3=new Thread(counter3);
		Thread t4=new Thread(counter4);
		Thread t5=new Thread(counter5);
		Thread t6=new Thread(counter6);
		generator.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
