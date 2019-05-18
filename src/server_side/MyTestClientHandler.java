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
	
	//Assistant method for the user input
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
					while(cm.save(line, s)!=true) {} //basically wait until the action was finished well
					out.println(s);//returning the answer after solving and saving the problem
					out.flush();
				}
				out.println(line);//must in every iteration
				out.flush();
			}
		} catch(IOException e) { e.printStackTrace();}
	}
	
	public void handleclient(InputStream input, OutputStream output) {
		try{
			
			BufferedReader userInput=new BufferedReader(new InputStreamReader(input));
			PrintWriter outFromServer=new PrintWriter(output);
			
			// correspond according to a well-defined protocol
			readInputsAndSend(userInput,outFromServer,"end");
			
			userInput.close();
			outFromServer.close();
			
			} catch(UnknownHostException e) {/*...*/}
			catch(IOException e) {/*...*/}
	}
}
