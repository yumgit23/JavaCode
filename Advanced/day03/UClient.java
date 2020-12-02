import java.net.*;
import java.io.*;

class UClient {
	DatagramSocket ds; //�޼�����(��ü��)
	DatagramPacket dp; //�޼���Ʋ(��������)
	int port = 5000;
	String ip;
	String ipHeader = "192.168.0.";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void init(){
		inputIp();

		try{
			ds = new DatagramSocket();
			
			while(true){
				p("������ �޼���: ");
				String msg = br.readLine();
				if(msg != null) msg = msg.trim();
				byte[] buf = msg.getBytes();
				InetAddress ia = InetAddress.getByName(ip);
				dp = new DatagramPacket(buf, buf.length, ia, port);
				ds.send(dp);
				pln("���� �Ϸ�!!");
			}
		}catch(SocketException se){
			init();
		}catch(UnknownHostException ue){
			pln("��Ʈ���� �ش缭��("+ip+")�� ã�� �� ����");
			init();
		}catch(IOException ie){
			init();
		}finally{
			ds.close();
		}
	}
	void inputIp(){
		try{
			p("IP(���ڸ�): ");
			String ipTail =  br.readLine();
			if(ipTail != null) ipTail = ipTail.trim();
			if(ipTail.length() != 0){
				ip = ipHeader + ipTail;
			}else{
				inputIp();
			}
		}catch(IOException ie){
			inputIp();
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		new UClient().init();
	}
}
