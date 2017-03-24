import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import util.Constants;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		ServerSocket svrSocket = new ServerSocket(Constants.port);
		while (true) {
			Socket socket = svrSocket.accept();
			// 足够大的一个缓冲区
			byte[] buf = new byte[1024 * 1024];
			InputStream in = socket.getInputStream();
			int byteRead = in.read(buf, 0, 1024 * 1024);
			String dataString = new String(buf, 0, byteRead);
			System.out.println(dataString);
			in.close();
			socket.close();
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see java.lang.Object#Object()
	 */
	public Main() {

	}

}