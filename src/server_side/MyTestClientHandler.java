package server_side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.UnknownHostException;

public class MyTestClientHandler implements ClientHandler {
	Solver<String,String> sol;
	CacheManager<String,String> cm;
	
	public MyTestClientHandler(Solver<String,String> solver, CacheManager<String,String> cacheManager ) {
		this.sol = solver;
		this.cm = cacheManager;
}
	
	public void handleclient(InputStream input, OutputStream output) {
		try {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(input));
		PrintWriter outFromServer = new PrintWriter(output);
		// correspond according to a well-defined protocol
		readInputsAndSend(userInput, outFromServer, "end");
		userInput.close(); 
		outFromServer.close();		
		} catch(UnknownHostException e) {}
		catch(IOException e){}
	}

	private void readInputsAndSend(BufferedReader in, PrintWriter out,String exitStr){
		try{
			String line;
			while(!(line=in.readLine()).equals(exitStr)){
				if(cm.exist(line) == true) {
					out.println(cm.pull(line));//returning the answer by using the pull method
					out.flush();
				}
				else {
					String s = sol.solve(line);
					cm.save(line, s); 	//save the new k,v in the HM
					out.println(s);		//returning the answer after solving and saving the problem
					out.flush();
				}
			}
		} catch(IOException e) { e.printStackTrace();}
	}
}
