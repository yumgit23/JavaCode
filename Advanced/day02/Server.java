import java.io.*;
import java.net.*;
import java.util.*;

class Server {
	ServerSocket ss;
	Socket s;
	int port = 3000;
	Vector<OneClientModul> v = new Vector<OneClientModul>();
	OneClientModul ocm;

	Server(){
		try{
			ss = new ServerSocket(port);
			pln(port+"�� ��Ʈ���� ���� �����...");
			while(true){
				s = ss.accept();
				ocm = new OneClientModul(this);
				v.add(ocm);
				ocm.start();
			}
		}catch(IOException ie){
			pln(port+"�� ��Ʈ�� �̹� �������");
		}finally{
            try{
				if(ss != null) ss.close();
			}catch(IOException ie){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new Server();
	}
}
