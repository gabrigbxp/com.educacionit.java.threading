package com.educacionit.java.customers.data;

import java.net.InetAddress;

public class Packet {

	private byte[] data;
	private InetAddress ip;
	private int port;
	private Connection conn;
	
	/**
	 * Create a new packet
	 * @param data The com.educacionit.java.customers.data to send
	 * @param reciever The packets' reciever
	 */
	public Packet(byte[] data, Connection receiver) {
		this.data = data;
		this.conn = receiver;
	}
	
	/**
	 * Create a new packet with simple information about the client
	 * @param data
	 * @param ip
	 * @param port
	 */
	public Packet(byte[] data, InetAddress ip, int port) {
		this.data = data;
		this.ip = ip;
		this.port = port;
		
		this.conn = new Connection(null, ip, port, 10);
	}
	
	/**
	 * Get the packet com.educacionit.java.customers.data
	 * @return the packet com.educacionit.java.customers.data
	 */
	public byte[] getData() {
		return data;
	}
	
	/**
	 * Get the ip
	 * @return the address of the receiver
	 */
	public InetAddress getAddr() {
		return ip;
	}
	
	/**
	 * Get the port
	 * @return the receivers port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Get the connection on which this packet was sent
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.conn;
	}
	
	@Override
	public String toString() {
		return "Data: " + new String(this.data) + "\n From: " + getConnection().getAddress() + ":" + getConnection().getPort();
	}

}
