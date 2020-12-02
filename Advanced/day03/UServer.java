import java.net.*;
import java.io.*;

class UServer {
	DatagramSocket ds; //�޼�����(��ü��)
	DatagramPacket dp; //�޼���Ʋ(��������)
	int port = 5000;

	UServer(){
		try{
			ds = new DatagramSocket(port);
			pln(port+"������ UDP���� �����..");
			byte buf[] = new byte[2048];
			dp = new DatagramPacket(buf, buf.length);

            while(true){
				ds.receive(dp);
				String msg = new String(buf);
				msg = msg.trim();
				pln("Client>> " + msg);
				for(int i=0; i<buf.length; i++) buf[i]=0;
			}
		}catch(SocketException se){
		}catch(IOException ie){
		}finally{
			ds.close();
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new UServer();
	}
}
