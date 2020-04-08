package cn.wujunya.testTicket;

import java.util.Vector;

public class Server {
	private static Vector<Integer> ordinary=new Vector<Integer>();
	private  static Vector<Integer> fast=new Vector<Integer>();
	private  static Vector<Integer> vip=new Vector<Integer>();

	private Integer total=0;

	public synchronized void add_ordinary() {
		total++;
		ordinary.add(total);
	}

	public synchronized void add_fast() {
		total++;
		fast.add(total);
	}

	public synchronized void add_vip() {
		total++;
		vip.add(total);
	}

	public synchronized int getOrdinarySize() {
		try {
			return ordinary.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public synchronized int getFastSize() {
		try {
			return fast.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public synchronized int getVIPSize() {
		try {
			return vip.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public synchronized int moveOrdinary() {
		int result=0;
		try {
			result = ordinary.firstElement();
		} catch (Exception e) {
			return 0;
		}
		ordinary.remove(0);
		return result;
	}

	public synchronized int moveFast() {
		
		int result=0;
		try {
			result = fast.firstElement();
		} catch (Exception e) {
			return 0;
		}
		fast.remove(0);
		return result;
	}

	public synchronized int moveVIP() {
		int result=0;
		try {
			result = vip.firstElement();
		} catch (Exception e) {
			return 0;
		}
		vip.remove(0);
		return result;
	}

	public synchronized int getTotal() {
		return total;
	}
}
