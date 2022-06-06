import java.net.*;
import java.util.Random;
import java.io.*;

public class LoadBalancer extends Thread {
	static String hosts[] = { "localhost", "localhost" };
	static int ports[] = { 8081, 8082 };
	static int nbHosts = 2;
	static Random rand = new Random();

	Socket socket;

	public LoadBalancer(Socket s) {
		this.socket = s;
	}

	public void run () {
		try {
			// Input du client 
			InputStream clientinput = socket.getInputStream();
			// OutPut du client 
			OutputStream clientoutput = socket.getOutputStream();
			// Choix du port de comanche
			int nbcommanche = rand.nextInt(nbHosts);
			int portchoisi = this.ports[nbcommanche];
			// Socket de liaision entre le LB et la comanche
			Socket LB_to_comanche = new Socket("localhost", portchoisi);
			// Input de la comanche 
			InputStream comancheinput = LB_to_comanche.getInputStream();
			// OutPut de la comanche
			OutputStream comancheoutput = LB_to_comanche.getOutputStream();
			
			byte[] b = new byte[1024];
			int lu = clientinput.read(b);
			comancheoutput.write(b, 0, lu);
			
			// Lecture de la réponse de la comanche 
			int comanchelu; 
			// Attente de la réponse
			while((comanchelu = comancheinput.read(b)) == -1) { 
			}
			clientoutput.write(b, 0, comanchelu);
			LB_to_comanche.close();
			clientinput.close();
			clientoutput.close();
			comancheinput.close();
			comancheoutput.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8080);
			while (true) {
				Thread t = new LoadBalancer(server.accept());
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}