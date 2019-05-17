

package com.educacionit.java.customers.client;


public class UDPTest {

	private UDPServer server;
	private UDPClient client;
	
	@Test
	public void test() {
		
		// Create our server and client intances
		server = new ThreadedUDPServer(1337);
		client = new client.ThreadedUDPClient("localhost", 1337);
		
		// Set up a handler for receiving the packets
		server.receive(new PacketHandler() {

			@Override
			public void process(Packet packet) {
				String data = new String(packet.getData()).trim();
		
				if(data.equals("CON")) {
					ThreadedUDPServer.CLIENTS.add(packet.getConnection());
					reply(new Packet("OK".getBytes(), packet.getAddr(), packet.getPort()));
				}
			}
			
		});
		
		client.receive(new PacketHandler() {

			@Override
			public void process(Packet packet) {
				String data = new String(packet.getData()).trim();
				System.out.println(data.trim());
			}
			
		});
		
		client.send("CON".getBytes());
		
		

	}
	
	public void reply(Packet packet) {
		server.broadcast(new String(packet.toString()).getBytes());
	}

}
