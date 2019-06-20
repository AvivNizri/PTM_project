package test;

import java.util.List;

// change this to match your code
import server_side.*;

public class TestSetter {
	

	static Server s; 
	
	public static void runServer(int port) {
		// put the code here that runs your server
		// for example:
		CacheManager cm = new FileCacheManager();
		Searcher<Pair<Integer,Integer>> searcher = new BestFirstSearch<>();
		Solver<Searchable<Pair<Integer,Integer>>, List<State<Pair<Integer,Integer>>>> algo = new SearcherAdapt<>(searcher);
		s=new MySerialServer(port, new ClientHandler(algo, cm)); 
		s.start();
	}

	public static void stopServer() {
		// put the code here that stops your server
		// for example:
		s.stop();
	}
	

}
