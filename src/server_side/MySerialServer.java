package server_side;


public class MySerialServer implements Server {
	private int port;
	private ClientHandler ch;
	private volatile boolean stop;
	
	
	public MySerialServer(int port, ClientHandler ch) {
		super();
		this.port = port;
		this.setCh(ch);
	}
	
	public void stop() {
		// TODO Auto-generated method stub
		
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
