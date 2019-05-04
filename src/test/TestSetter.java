package test;

import server_side.CacheManager;
import server_side.ClientHandler;
import server_side.FileCacheManager;
import server_side.MySerialServer;
import server_side.MyTestClientHandler;
import server_side.Server;
import server_side.Solver;

public class TestSetter {
	
	public static void setClasses(DesignTest dt){
		
		// set the server's Interface, e.g., "Server.class"
		// don't forget to import the correct package e.g., "import server.Server"
		dt.setServerInteface(Server.class);
		// now fill in the other types according to their names
		dt.setServerClass(MySerialServer.class);
		dt.setClientHandlerInterface(ClientHandler.class);
		dt.setClientHandlerClass(MyTestClientHandler.class);
		dt.setCacheManagerInterface(CacheManager.class);
		dt.setCacheManagerClass(FileCacheManager.class);
		dt.setSolverInterface(Solver.class);
	}
	

}
