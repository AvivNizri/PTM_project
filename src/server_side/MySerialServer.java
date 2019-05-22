package server_side;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.io.IOException;

public class MySerialServer implements Server {
	private int port;
	private ClientHandler ch;
	private volatile boolean stop;
	
	
	public MySerialServer(int port, ClientHandler ch) {
		super();
		this.port = port;
		this.setCh(ch);
	}
	
	private void runServer() throws Exception {
		ServerSocket server=new ServerSocket(this.port);
		server.setSoTimeout(1000);
		while(!stop){
			try{
				Socket aClient=server.accept(); // blocking call
					try{
						this.ch.handleclient(aClient.getInputStream(), aClient.getOutputStream());
						
						aClient.getInputStream().close();
						aClient.getOutputStream().close();
						aClient.close();
						
					} catch(IOException e) {/*...*/}
			}catch(SocketTimeoutException e) {/*...*/}
		}
		server.close();
	}
	
	//should we use the try/catch?
	public void start(){
		new Thread(()->{
			try {
				runServer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
	
	public void stop() {
		this.stop = true;
		
	}
	@Override
	public void open(int port, ClientHandler c) {
		// TODO Auto-generated method stub
		
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ClientHandler getCh() {
		return ch;
	}

	public void setCh(ClientHandler ch) {
		this.ch = ch;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
}
