package boot;

import server_side.FileCacheManager;
import server_side.MySerialServer;
import server_side.MyTestClientHandler;
import server_side.StringReverser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySerialServer n = new MySerialServer(Integer.parseInt(args[0]), new MyTestClientHandler(new StringReverser(), new FileCacheManager()));
		n.start();
	}

}
