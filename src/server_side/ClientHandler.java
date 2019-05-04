package server_side;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
	public void handleclient(InputStream input, OutputStream output);
}
