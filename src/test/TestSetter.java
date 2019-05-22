package test;

import server_side.FileCacheManager;

// change this to match your code

import server_side.MySerialServer;
import server_side.MyTestClientHandler;
import server_side.Server;
import server_side.StringReverser;

public class TestSetter {
	

	static Server s; 
	
	public static void runServer(int port) {
		// put the code here that runs your server
		// for example:
		s=new MySerialServer(port, new MyTestClientHandler(new StringReverser(), new FileCacheManager())); 
		s.start();
	}

	public static void stopServer() {
		// put the code here that stops your server
		// for example:
		s.stop();
	}
	

}
