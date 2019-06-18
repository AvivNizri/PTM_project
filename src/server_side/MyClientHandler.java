package server_side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.List;


public class MyClientHandler implements ClientHandler {
	private Solver<Searchable<Pair<Integer, Integer>>, List<State<Pair<Integer, Integer>>>> solver;
    private CacheManager<Maze,List<State<Pair<Integer, Integer>>>> cm;
	
	public void MyClientHandler(Solver<Searchable<Pair<Integer, Integer>>, List<State<Pair<Integer, Integer>>>> solverr,
			CacheManager<Maze,List<State<Pair<Integer, Integer>>>> cacheManager) {
		
		this.solver = solverr;
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
			ArrayList<ArrayList<Integer> > matrix =  new ArrayList<ArrayList<Integer> >();
			ArrayList<Integer> a1 = new ArrayList<Integer>(); 

			while(!(line=in.readLine()).equals(exitStr)){
				String[] tmp = line.split(",");
				for(int i=0;i<line.length();i++){
					Integer num = Integer.parseInt(tmp[i]);
					a1.add(num);
				}
				matrix.add(a1);
			}		
			
			int[] start = new int[2];
			int[] end = new int[2];
			for(int i= 0;i<2;i++){
				line=in.readLine();
				String[] tmp2 = line.split(",");
				for(int j=0;j<line.length();j++){
					if(i==0){
						start[j] = Integer.parseInt(tmp2[j]);
					}
					else{
						end[j] = Integer.parseInt(tmp2[j]);
					}
				}
			}
			Pair<Integer, Integer> enter = new Pair<>(start[0],start[1]);
			Pair<Integer, Integer> exit = new Pair<>(end[0], end[1]);
			List<State<Pair<Integer, Integer>>> sol;
			Maze matProb = new Maze(matrix, enter, exit);
				if(cm.exist(matProb) == true) {
					out.println(cm.pull(matProb));//returning the answer by using the pull method
					out.flush();
				}
				else {
					sol = solver.solve(matProb);
					cm.save(matProb, sol); 	//save the new k,v in the HM
					out.println(sol);		//returning the answer after solving and saving the problem
					out.flush();
				}
			
		} catch(IOException e) { e.printStackTrace();}
	}
}
