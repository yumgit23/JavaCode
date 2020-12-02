import java.io.*;
import java.net.*;

class FClient {  
	Socket s;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	FileInputStream fis; //Node 
	OutputStream os; //Node 
	BufferedInputStream bis; //Filter
	BufferedOutputStream bos; //Filter 

	String fname = "C:/SOO/�л����ǰ���/CHEEZE(ġ��) _ Love You(������)(bye).mp4";

	FClient(){
		connect();
	}
	void connect(){ //������ ����
		try{
			p("����IP(�⺻:127.0.0.1): ");
			String ip = br.readLine();
			if(ip != null) ip = ip.trim();
			if(ip.length() == 0) ip = "127.0.0.1";
			
			p("PORT(�⺻:4000): ");
			String portStr = br.readLine();
			if(portStr != null) portStr = portStr.trim();
			if(portStr.length() == 0) portStr = "4000";
			int port = Integer.parseInt(portStr);
			if(port<0 || port>65535){
				pln("������ ��ȿ���� ���� ��Ʈ��");
				connect();
				return;
			}

			s = new Socket(ip, port);

			ready();
		}catch(IOException ie){}
	}
	void ready(){
		try{
			fis = new FileInputStream(fname);
			bis = new BufferedInputStream(fis, 4096);
			os = s.getOutputStream();
			bos = new BufferedOutputStream(os, 4096);

			send();
		}catch(FileNotFoundException fe){
		}catch(IOException ie){}
	}
	void send(){ //file -> socket
		byte bs[] = new byte[1024];
		int i=0;
		long total = 0L;
		try{
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				pln("���� ��..."+ ( total+=i ) + "bytes");
			}
			bos.flush();
			pln("����("+fname+": "+total+"bytes) ���� �Ϸ�!!");
		}catch(IOException ie){
		}finally{
			closeAll();	
		}
	}
	void closeAll(){
		try{
			bis.close();
			bos.close();
			fis.close();
			os.close();
			s.close();
		}catch(IOException ie){}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new FClient();
	}
}
